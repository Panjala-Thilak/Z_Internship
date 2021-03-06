package com.zemoso.springboot.cruddemo.dao;

import com.zemoso.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    private EntityManager entityManager;


    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        Session currentSession=entityManager.unwrap(Session.class);

        Query<Employee> query=currentSession.createQuery("from Employee",Employee.class);

        List<Employee> employees=query.getResultList();

        return employees;
    }
}
