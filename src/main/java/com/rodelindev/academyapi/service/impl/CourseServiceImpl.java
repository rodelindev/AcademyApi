package com.rodelindev.academyapi.service.impl;

import com.rodelindev.academyapi.model.Course;
import com.rodelindev.academyapi.repository.ICourseRepository;
import com.rodelindev.academyapi.repository.IGenericRepository;
import com.rodelindev.academyapi.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CrudImpl<Course, Integer> implements ICourseService {

    private final ICourseRepository repository;

    @Override
    protected IGenericRepository<Course, Integer> getRepo() {
        return repository;
    }
}
