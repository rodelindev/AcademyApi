package com.rodelindev.academyapi.service.impl;

import com.rodelindev.academyapi.model.Student;
import com.rodelindev.academyapi.repository.IGenericRepository;
import com.rodelindev.academyapi.repository.IStudentRepository;
import com.rodelindev.academyapi.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudImpl<Student, Integer> implements IStudentService {

    private final IStudentRepository repository;

    @Override
    protected IGenericRepository<Student, Integer> getRepo() {
        return repository;
    }
}
