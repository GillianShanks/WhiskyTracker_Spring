package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> returnWhiskiesBasedOnYear(int year) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    @Transactional
    public List<Whisky> getWhiskiesFromDistilleryBasedOnAge(Long distilleryID, int age) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class); // get all the whiskies
            cr.createAlias("distillery", "distillery");
            cr.add(Restrictions.eq("distillery.id", distilleryID));
            cr.add(Restrictions.eq("age", age));

            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    @Transactional
    public List<Whisky> getWhiskiesFromRegion(String region) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
        cr.createAlias("distillery", "distillery");
        cr.add(Restrictions.eq("distillery.region", region));
        results = cr.list();
        return results;
    }
}
