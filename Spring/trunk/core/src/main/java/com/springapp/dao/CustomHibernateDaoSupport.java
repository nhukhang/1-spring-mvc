package com.springapp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

    @Autowired
    public void anyMethodName(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }
}
