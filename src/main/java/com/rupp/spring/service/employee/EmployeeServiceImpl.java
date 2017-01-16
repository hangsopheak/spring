package com.rupp.spring.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupp.spring.dao.EmployeeDAO;
import com.rupp.spring.domain.EmployeeDTO;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO dao;
    
    @Override
    public EmployeeDTO createNewEmployee() {
        return dao.createNewEmployee();
    }

}
