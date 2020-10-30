package ru.litvinov.javapool.model.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.litvinov.javapool.model.entity.Auto;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AutoDaoImpl implements AutoDao{

    private SessionFactory sessionFactory;

    @Autowired
    public AutoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAuto(Auto auto) {
        sessionFactory.getCurrentSession().save(auto);
    }

    @Override
    public void updateAuto(Auto auto) {
        sessionFactory.getCurrentSession().update(auto);
    }

    @Override
    public String removeAuto(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Auto auto = session.load(Auto.class,id);
        if (auto != null){
            session.delete(auto);
            return "Auto with id = " + id + " is deleted";
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Auto getAutoById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Auto auto = session.get(Auto.class, id);
        return auto;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Auto> listAuto() {
        Session session = sessionFactory.getCurrentSession();
        List<Auto> list = session.createQuery("FROM Auto").list();
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Auto> listAutoByModel(String model) {
        Session session = sessionFactory.getCurrentSession();
        List<Auto> list = session.createQuery("FROM Auto a WHERE a.model = :model").setParameter("model",model).list();
        return list;
    }
}
