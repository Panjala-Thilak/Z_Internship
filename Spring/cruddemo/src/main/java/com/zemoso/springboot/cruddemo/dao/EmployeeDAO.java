package com.zemoso.springboot.cruddemo.dao;

import com.zemoso.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
