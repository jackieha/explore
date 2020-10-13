package com.gsf.web.controller;

import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author shuaifeng.gao
 * @since 2019-10-02 13:46
 **/
@Controller
public class TestController {
//    @RequestMapping("/")
//    public Object root(HttpServletRequest request, String key){
//        Map res = Maps.newHashMap();
//        res.put("key", key);
//        return res;
//    }
//
    @RequestMapping("/ng/g1")
    public Object ngg1(HttpServletRequest request, String key){
        Map res = Maps.newHashMap();
        res.put("key", key);
        return res;
    }

    @GetMapping("/ng/tt")
    @ResponseBody
    public QResp ngg2(HttpServletRequest request){
        User u = new User();
        u.setAge("12");
        u.setName("gsf");
        QResp<User> r = new QResp<>();
        r.setCode("121");
        r.setMsg("abacdassa");
        r.setData(u);
        return r;
    }


    @Data
    public static class User{
        private String name;
        private String age;
    }

    @Data
    public static class QResp<T>{
        private String code;
        private String msg;
        private T data;
    }
//
//    @RequestMapping("/ng/g1/g2")
//    public Object ngg2(HttpServletRequest request, String key){
//        Map res = Maps.newHashMap();
//        res.put("key", key);
//        return res;
//    }

    @RequestMapping("/")
    public Object root(HttpServletRequest request, HttpServletResponse response, String k){
        Map<String, String> res = Maps.newHashMap();
        res.put("k", k);
        Cookie c = new Cookie("gsf", k);
        c.setMaxAge(10000);
        response.addCookie(c);
        addUri(request, res);
        return res;
    }

    @RequestMapping("/s1")
    public Object s1(HttpServletRequest request, HttpServletResponse response, String k){
        Map<String, String> res = Maps.newHashMap();
        res.put("k", k);
        Cookie c = new Cookie("gsf", k);
        c.setMaxAge(10000);
        response.addCookie(c);
        addUri(request, res);

        return res;
    }

    @RequestMapping("/s1/s2")
    public Object s2(HttpServletRequest request, HttpServletResponse response, String k){
        Map<String, String> res = Maps.newHashMap();
        res.put("k", k);
        Cookie c = new Cookie("gsf", k);
        c.setMaxAge(10000);
        response.addCookie(c);
        addUri(request, res);

        return res;
    }

    @RequestMapping("/s1/s2/s3")
    public Object s3(HttpServletRequest request, HttpServletResponse response, String k){
        Map<String, String> res = Maps.newHashMap();
        res.put("k", k);
        Cookie c = new Cookie("gsf", k);
        c.setMaxAge(10000);
        response.addCookie(c);
        addUri(request, res);

        return res;
    }

    private void addUri(HttpServletRequest request, Map<String, String> res){
        res.put("uri", request.getRequestURI());
        res.put("URL", request.getRequestURL().toString());
    }

//    @RequestMapping("/ng/s1")
//    public Object s1(HttpServletResponse response, String k, String d){
//        Map<String, String> res = Maps.newHashMap();
//        res.put("k", k);
//        res.put("d", d);
//        Cookie c = new Cookie("gsf", k);
//        if (!StringUtils.isEmpty(d)){
//            c.setDomain(d);
//        }
//        c.setMaxAge(10000);
//        response.addCookie(c);
//        return res;
//    }
//
//    @RequestMapping("/ng/s1/s2")
//    public Object s2(HttpServletResponse response, String k, String d){
//        Map<String, String> res = Maps.newHashMap();
//        res.put("k", k);
//        res.put("d", d);
//        Cookie c = new Cookie("gsf", k);
//        if (!StringUtils.isEmpty(d)){
//            c.setDomain(d);
//        }
//        c.setMaxAge(10000);
//        response.addCookie(c);
//        return res;
//    }
}
