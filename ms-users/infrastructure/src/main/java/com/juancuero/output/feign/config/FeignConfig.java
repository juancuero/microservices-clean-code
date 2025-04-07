package com.juancuero.output.feign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.juancuero.output.feign.*")
public class FeignConfig {

}
