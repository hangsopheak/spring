package com.rupp.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainWithAnnotationTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        /** otherway around annotation */
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("BeansWithAnnotation.xml");

        TestDomain obj = ctx.getBean(TestDomain.class);
        obj.setMessage("Another message with register()");
        System.out.println(obj.getMessage());
        
        /**shutdown*/
        ctx.registerShutdownHook();
                
    }

}
