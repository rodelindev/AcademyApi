package com.rodelindev.academyapi.service;

import com.rodelindev.academyapi.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICrud<Enrollment, Integer> {
    Map<String, List<String>> getStudentsGroupedByCourse();
}
