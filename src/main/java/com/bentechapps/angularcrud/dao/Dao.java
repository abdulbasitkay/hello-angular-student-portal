/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.dao;

import com.bentechapps.angularcrud.entity.AngularEntity;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Daniel
 * @param <T>
 */
public interface Dao<T extends AngularEntity> {

    public void delete(T o);

    public T load(Serializable id);

    public void save(T o);

    public List<T> findAll();

    public List<T> findAll(int start, int size);

    public int countAll();

    public Session getSession();
}
