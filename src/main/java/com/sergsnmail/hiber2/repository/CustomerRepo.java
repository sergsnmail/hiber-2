package com.sergsnmail.hiber2.repository;

import com.sergsnmail.hiber2.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class CustomerRepo implements EntityCRUD<Customer>{

    private SessionFactory sessionFactory;

    private Session session = null;

    @Autowired
    public CustomerRepo(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Override
    public void create(Customer entity) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {}
    }

    @Override
    public Customer get(Class<Customer> cls, Long id) {
        Customer customer = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            customer = session.get(cls, id);
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer entity) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {}
    }

    @Override
    public void delete(Customer entity) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {}
    }
}
