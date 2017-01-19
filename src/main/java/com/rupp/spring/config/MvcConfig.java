package com.rupp.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.rupp.spring.dao", 
        "com.rupp.spring.controller", 
        "com.rupp.spring.service"})
public class MvcConfig {

}
