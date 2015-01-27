package com.dempe.weixin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: zhengdaxia
 * Date: 15/1/27
 * Time: 下午10:51
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@ComponentScan
@EnableConfigurationProperties
@EnableAutoConfiguration
public class WeixinBootstrap {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeixinBootstrap.class, args);
    }
}
