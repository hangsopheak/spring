package com.rupp.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rupp.spring.bean.TestDomain;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        final ApplicationContext context = new ClassPathXmlApplicationContext("Beans_autowired.xml");
        MyService myService = (MyService) context.getBean("myService");
        TestDomain objA = myService.getTestDomain();
        objA.setMessage("I'm object A");
        System.out.println(objA.getMessage());
    }

}
