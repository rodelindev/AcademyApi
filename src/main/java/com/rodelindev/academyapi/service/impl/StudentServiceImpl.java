package com.rodelindev.academyapi.service.impl;

import com.rodelindev.academyapi.model.Student;
import com.rodelindev.academyapi.repository.IGenericRepository;
import com.rodelindev.academyapi.repository.IStudentRepository;
import com.rodelindev.academyapi.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudImpl<Student, Integer> implements IStudentService {

    private final IStudentRepository repository;

    @Override
    protected IGenericRepository<Student, Integer> getRepo() {
        return repository;
    }

    @Override
    public List<Student> findAllStudentsDesc() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toList());
    }
}
