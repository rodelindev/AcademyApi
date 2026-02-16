package com.rodelindev.academyapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rodelindev.academyapi.model.Course;
import com.rodelindev.academyapi.model.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDTO {

    @JsonBackReference
    private Integer idEnrollmentDetail;

    @NonNull
    private Course course;

    @NonNull
    private Enrollment enrollment;

    @NonNull
    private String classroom;
}
