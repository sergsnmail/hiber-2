package com.sergsnmail.hiber2.repository;

import com.sergsnmail.hiber2.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class ProductRepo implements EntityCRUD<Product>{

    private SessionFactory sessionFactory;
    private Session session = null;
    @Autowired
    public ProductRepo(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Override
    public void create(Product entity) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {}
    }

    @Override
    public Product get(Class<Product> cls, Long id) {
        Product product = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            product = session.get(cls, id);
            session.getTransaction().commit();
        } catch (Exception ex) {}
        return product;
    }

    @Override
    public void update(Product entity) {
        try {Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {}
    }

    @Override
    public void delete(Product entity) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }  catch (Exception ex) {}
    }
}
