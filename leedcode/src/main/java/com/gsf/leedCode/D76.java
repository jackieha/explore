package com.gsf.leedCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author shuaifeng.gao
 * @since 2020-05-23 17:31
 **/
public class D76 {

    public static void main(String[] args) {

        String s = "abcd";
        D76 d = new D76();
        System.out.println(d.minWindow2("BOCBD", "BC"));
    }

    public String minWindow2(String s, String t){
        if (s == null || s.length() == 0
                || t == null || t.length() == 0
                || s.length() < t.length()){
            return "";
        }
        int[] need = new int[128];
        int[] window = new int[128];

        // 初始化 need
        for (char c : t.toCharArray()){
            need[c]++;
        }

        int l = 0, r = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int count = 0;

        // 遍历 s
        while (r < s.length()){
            char rc = s.charAt(r);
            if (need[rc] == 0){
                r++;
                continue;
            }
            if (window[rc] < need[rc]){
                count++;
            }
            window[rc]++;
            while (count == t.length()){
                if ((r - l + 1) < len){
                    start = l;
                    len = r - l + 1;
                }
                char lc = s.charAt(l);
                if (need[lc] == 0){
                    l++;
                    continue;
                }
                if (need[lc] == window[lc]){
                    count--;
                }
                window[lc]--;
                l++;
            }
            r++;
        }
        if (len == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start + len);
    }


    private Map<Character, Integer> need = new HashMap<>();
    private Map<Character, Integer> window = new HashMap<>();

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0
                || t == null || t.length() == 0
                || s.length() < t.length()){
            return "";
        }
        // 初始化 need
        for (char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int start = 0, len = Integer.MAX_VALUE;

        // 遍历 s
        while (r < s.length()){
            char rc = s.charAt(r);
            window.put(rc, window.getOrDefault(rc, 0) + 1);
            while (isMatch() && l <= r){
                if ((r - l + 1) < len){
                    start = l;
                    len = r - l + 1;
                }
                char lc = s.charAt(l);
                window.put(lc, window.getOrDefault(lc, 0) - 1);
                l++;
            }
            r++;
        }
        if (len == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start + len);
    }

    private boolean isMatch(){
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
