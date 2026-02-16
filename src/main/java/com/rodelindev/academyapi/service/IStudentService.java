package com.rodelindev.academyapi.service;

import com.rodelindev.academyapi.model.Student;

import java.util.List;

public interface IStudentService extends ICrud<Student, Integer> {
    List<Student> findAllStudentsDesc();
}
