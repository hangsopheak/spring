package com.rupp.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rupp.spring.config.MvcConfig;
import com.rupp.spring.controller.EmployeeController;

public class Main {
    public static void main(String[] args) {

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MvcConfig.class);

        // EmployeeManager manager = (EmployeeManager) context.getBean(EmployeeManager.class);
        // OR this will also work
        EmployeeController controller = (EmployeeController) context.getBean("employeeController");

        System.out.println(controller.createNewEmployee());
        context.close();
    }
}
