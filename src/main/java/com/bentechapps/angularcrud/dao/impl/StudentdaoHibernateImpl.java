/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.dao.impl;

import com.bentechapps.angularcrud.dao.StudentDao;
import com.bentechapps.angularcrud.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentdaoHibernateImpl extends AbstractDaoHibernateImpl<Student> implements StudentDao {

    public StudentdaoHibernateImpl() {
        super(Student.class);
    }
    
}
