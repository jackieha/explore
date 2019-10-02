package com.gsf.web.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author shuaifeng.gao
 * @since 2019-10-02 13:46
 **/
@RestController
public class TestController {

    @RequestMapping("/g1")
    public Object g1(String key){
        Map res = Maps.newHashMap();
        res.put("key", key);
        return res;
    }

    @RequestMapping("/g1/l2")
    public Object g1l2(String key){
        Map res = Maps.newHashMap();
        res.put("key", key);
        return res;
    }

    @RequestMapping("/g2")
    public Object g2(HttpServletRequest request, String key){
        Map res = Maps.newHashMap();
        res.put("uri", request.getRequestURI());
        res.put("URL", request.getRequestURL().toString());
        res.put("key", key);
        return res;
    }

    @RequestMapping("/g2/l2")
    public Object g2l2(HttpServletRequest request, String key){
        Map res = Maps.newHashMap();
        res.put("uri", request.getRequestURI());
        res.put("URL", request.getRequestURL().toString());
        res.put("key", key);
        return res;
    }

}
