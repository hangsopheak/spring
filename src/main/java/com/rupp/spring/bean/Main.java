package com.rupp.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        TestDomain objA = (TestDomain) context.getBean("testDomain");

        objA.setMessage("I'm object A");
        
        System.out.println(objA.getMessage());
        
        
        
        /**Test Annotation Configruation*/
        ApplicationContext appContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        TestDomain testObject = (TestDomain) appContext.getBean("testDomain");
        testObject.setMessage("I'm object TestDomain from Bean Annotation");
        System.out.println(testObject.getMessage());
        
     
        /** otherway around annotation */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("BeansWithAnnotation.xml");

        TestDomain obj = ctx.getBean(TestDomain.class);
        obj.setMessage("Another message with register()");
        System.out.println(obj.getMessage());
        
        /**shutdown*/
        ctx.registerShutdownHook();
                
    }

}
