package com.zemoso.springboot.cruddemo.service;

import com.zemoso.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> finaAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
