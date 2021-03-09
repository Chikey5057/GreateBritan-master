package h8.chikey.service;

import h8.chikey.dao.DAO;
import h8.chikey.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceManufacturer implements DAO<Manufacturer,Integer> {
    public ServiceManufacturer(SessionFactory factory) {
        this.factory = factory;
    }

    SessionFactory factory;
    public void create(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        }

    }
    public void delete(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        }
    }
    public void update(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        }
    }
    public Manufacturer read(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Manufacturer.class,integer);
        }
    }
    public List<Manufacturer> readAll() {
        try(Session session = factory.openSession()){

            Query<Manufacturer> query = session.createQuery("FROM Manufacturer");
            return query.list();
        }
    }
}
