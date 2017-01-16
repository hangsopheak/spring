package com.rupp.spring.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rupp.spring.bean.TestDomain;

public class MainJavaConfiguration {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        /** otherway around annotation */
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowiredConfiguration.class);

        MyService myService = ctx.getBean(MyService.class);
        
        TestDomain obj = myService.getTestDomain();
        obj.setMessage("Another message with java configuration");
        System.out.println(obj.getMessage());
        
    }

}
