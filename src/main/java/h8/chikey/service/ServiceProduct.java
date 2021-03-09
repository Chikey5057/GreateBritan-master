package h8.chikey.service;

import h8.chikey.dao.DAO;
import h8.chikey.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.List;

public class ServiceProduct implements DAO<Product,Integer> {


    public ServiceProduct(SessionFactory factory) {
        this.factory = factory;
    }

    SessionFactory factory;
    @Override
    public void create(Product product) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Product product) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Product product) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product read(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Product.class,integer);
        }
    }

    @Override
    public List<Product> readAll() {
        try(Session session = factory.openSession()){
            Query<Product> query = session.createQuery("FROM Product");
            return query.list();
        }
    }
}
