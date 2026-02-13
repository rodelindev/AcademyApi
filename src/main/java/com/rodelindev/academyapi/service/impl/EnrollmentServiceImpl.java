package com.rodelindev.academyapi.service.impl;

import com.rodelindev.academyapi.model.Enrollment;
import com.rodelindev.academyapi.repository.IEnrollmentRepository;
import com.rodelindev.academyapi.repository.IGenericRepository;
import com.rodelindev.academyapi.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CrudImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepository repository;

    @Override
    protected IGenericRepository<Enrollment, Integer> getRepo() {
        return repository;
    }

    @Override
    public Enrollment save(Enrollment enrollment) throws Exception {
        //enrollment.getDetails().forEach(details -> details.setCourse(enrollment));
        return repository.save(enrollment);
    }
}
