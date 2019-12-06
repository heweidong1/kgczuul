package com.kgc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Test
{
    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String getPort(){
        return "配置文件中的端口为："+this.port;
    }

}
