package com.rupp.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfigurationBase {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        
        /**Test java code Configruation*/
        ApplicationContext appContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        TestDomain testObject = (TestDomain) appContext.getBean("testDomain");
        testObject.setMessage("I'm object TestDomain from Bean Annotation");
        System.out.println(testObject.getMessage());
                
    }

}
