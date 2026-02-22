package com.rodelindev.academyapi.service.impl;

import com.rodelindev.academyapi.model.Enrollment;
import com.rodelindev.academyapi.repository.IEnrollmentRepository;
import com.rodelindev.academyapi.repository.IGenericRepository;
import com.rodelindev.academyapi.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
        enrollment.getDetails().forEach(details -> details.setEnrollment(enrollment));
        return repository.save(enrollment);
    }

    @Override
    public Map<String, List<String>> getStudentsGroupedByCourse() {
        return repository.findAll()
                .stream()
                .flatMap(e -> e.getDetails().stream())
                .collect(
                        groupingBy(
                                detail -> detail.getCourse().getName(),
                                Collectors.mapping(
                                        detail -> detail.getEnrollment().getStudent().getFirstName() + " " +
                                                detail.getEnrollment().getStudent().getLastName(),
                                        Collectors.toList()
                                )
                        )
                );
    }
}
