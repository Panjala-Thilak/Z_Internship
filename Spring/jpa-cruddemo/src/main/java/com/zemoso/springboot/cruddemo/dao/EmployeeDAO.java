package com.zemoso.springboot.cruddemo.dao;

import java.util.List;

import com.zemoso.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
