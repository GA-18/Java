package com.xiaoya.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.Set;

@Controller
public class MyController {
    private static JedisPool jedisPool;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @PostConstruct
    public void dbPoll(){
        jedisPool=new JedisPool(host,port);
    }
    @RequestMapping("/getShengfen")
    @ResponseBody
    public Set<String> getShengfen(){
        Set<String> shengfen;
        Jedis jedis=jedisPool.getResource();
        shengfen=jedis.zrange("shengfen",0,-1);
        System.out.println("=--------------");
        System.out.println(shengfen);
        for (String s:shengfen
             ) {
            System.out.println(s);
        }
        return shengfen;
    }
}
