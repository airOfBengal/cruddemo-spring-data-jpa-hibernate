package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findById(Long id);
    void deleteById(Long id);

    InstructorDetail findInstructorDetailById(Long id);
    void deleteInstructorDetailById(Long id);
}
