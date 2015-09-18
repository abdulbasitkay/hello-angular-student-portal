/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.service;

import com.bentechapps.angularcrud.entity.Student;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface StudentService {

    public List<Student> getAllStudents();

    public Student getById(Long id);

    public Student createNewUser(Student student);

    public Student update(Student student);

    public void remove(Long id);
    
}
