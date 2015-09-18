package com.bentechapps.angularcrud.dao.impl;

import com.bentechapps.angularcrud.dao.Dao;
import com.bentechapps.angularcrud.entity.AngularEntity;
import java.io.Serializable;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.hibernate.Criteria;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Log4j
@Repository
public abstract class AbstractDaoHibernateImpl<T extends AngularEntity> implements Dao<T> {

    private final Class<T> domainClass;
    @Autowired
    SessionFactory sf;

    public AbstractDaoHibernateImpl(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    @Transactional
    @Override
    public void delete(T object) {
        getSession().delete(object);
    }

    @Transactional
    @Override
    public T load(Serializable id) {
        return (T) getSession().get(domainClass, id);
    }

    @Override
    @Transactional
    public void save(T object) {
        getSession().saveOrUpdate(object);
    }

    @Transactional
    @Override
    public List<T> findAll() {
        Criteria criteria = getSession().createCriteria(domainClass);
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Transactional
    @Override
    public List<T> findAll(int start, int size) {
        Criteria criteria = getSession().createCriteria(domainClass);
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        criteria.setFetchSize(start);
        criteria.setFetchSize(size);
        return criteria.list();
    }

    @Override
    public int countAll() {
        Criteria criteria = getSession().createCriteria(domainClass);
        criteria.setProjection(Projections.rowCount());
        return ((Long) criteria.uniqueResult()).intValue();
    }

    @Override
    public Session getSession() {
        return sf.getCurrentSession();
    }
}
