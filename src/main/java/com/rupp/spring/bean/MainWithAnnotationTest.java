package com.rupp.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rupp.spring.service.MyService;

public class MainWithAnnotationTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans_autowired.xml");
        
        MyService myService  = (MyService) ctx.getBean("myService");
        
        TestDomain obj = myService.getTestDomain();
        obj.setMessage("Another message with register()");
        System.out.println(obj.getMessage());
        
        
        TestDomain objA = (TestDomain) ctx.getBean("testDomain");
        System.out.println(objA.getMessage());
        
        
        
    }

}
