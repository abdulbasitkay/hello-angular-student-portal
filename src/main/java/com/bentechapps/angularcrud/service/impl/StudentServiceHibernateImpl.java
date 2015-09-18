/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.service.impl;

import com.bentechapps.angularcrud.dao.StudentDao;
import com.bentechapps.angularcrud.entity.Student;
import com.bentechapps.angularcrud.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceHibernateImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student getById(Long id) {
        return studentDao.load(id);
    }

    @Override
    public Student createNewUser(Student student) {
        studentDao.save(student);
        return student;
    }

    @Override
    public Student update(Student student) {
        studentDao.save(student);
        return student;
    }

    @Override
    public void remove(Long id) {
        studentDao.delete(studentDao.load(id));
    }

}
