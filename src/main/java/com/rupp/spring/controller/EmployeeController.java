/***/
package com.rupp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rupp.spring.domain.EmployeeDTO;
import com.rupp.spring.service.employee.EmployeeService;

/**
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
@Controller ("employeeController")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    
    public EmployeeDTO createNewEmployee() {
        return service.createNewEmployee();
    }
}
