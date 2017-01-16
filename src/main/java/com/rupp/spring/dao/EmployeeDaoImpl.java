package com.rupp.spring.dao;

import org.springframework.stereotype.Repository;

import com.rupp.spring.domain.EmployeeDTO;
@Repository() //"employeeDaoImpl"
public class EmployeeDaoImpl implements EmployeeDAO {

    @Override
    public EmployeeDTO createNewEmployee() {
        final EmployeeDTO e = new EmployeeDTO();
        e.setId(1);
        e.setFirstName("Mak");
        e.setLastName("Sophea");
        return e;
    }

}
