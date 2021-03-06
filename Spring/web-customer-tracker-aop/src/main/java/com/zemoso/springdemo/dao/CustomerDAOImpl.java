package com.zemoso.springdemo.dao;

import com.zemoso.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session=sessionFactory.getCurrentSession();

        Query<Customer> query=session.createQuery("from Customer order by firstName",Customer.class);

        List<Customer> customers=query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession=sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId){
        Session currentSession=sessionFactory.getCurrentSession();

        Customer customer=currentSession.get(Customer.class,theId);

        return customer;

    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();

        Customer customer=currentSession.get(Customer.class,theId);

        currentSession.delete(customer);
    }
}
