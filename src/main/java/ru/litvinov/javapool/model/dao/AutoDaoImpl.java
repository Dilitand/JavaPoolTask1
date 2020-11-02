package ru.litvinov.javapool.model.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public int addAuto(Auto auto) {
        Session session = sessionFactory.getCurrentSession();
        sessionFactory.getCurrentSession().save(auto);
        return auto.getId();
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
        session.clear();
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

    @Override
    @SuppressWarnings("unchecked")
    public List<Auto> listAutoByParams(String model, int minSpeed, int maxSpeed, int minMileAge, int maxMileAge,int qCurrentPage, int qCountPage) {
        Session session = sessionFactory.getCurrentSession();
        Query<Auto> query = session.createQuery("FROM Auto a WHERE a.model like CONCAT('%',:model,'%') and a.maxspeed > :minSpeed and a.maxspeed < :maxSpeed and a.mileage > :minMileAge and a.mileage < :maxMileAge")
                .setParameter("model",model)
                .setParameter("minSpeed",minSpeed).setParameter("maxSpeed",maxSpeed)
                .setParameter("minMileAge",minMileAge).setParameter("maxMileAge",maxMileAge);
        if (qCurrentPage > 0 && qCountPage > 0) {
            query.setFirstResult((qCurrentPage-1)*qCountPage);
            query.setMaxResults(qCountPage);
        }
        List<Auto> list = query.list();
        return list;
    }
}
