package com.kgc;

import com.kgc.zuukfilter.PreFilter;
import com.kgc.zuukfilter.PreFilter2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class KgczuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(KgczuulApplication.class, args);
    }


    public PreFilter preFilter()
    {
        return new PreFilter();
    }

    public PreFilter2 preFilter2()
    {
        return new PreFilter2();
    }
}
