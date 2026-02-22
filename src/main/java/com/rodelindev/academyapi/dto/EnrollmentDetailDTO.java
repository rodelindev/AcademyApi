package com.rodelindev.academyapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.rodelindev.academyapi.model.Course;
import com.rodelindev.academyapi.model.Enrollment;
import jakarta.validation.constraints.NotNull;
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
    private EnrollmentDTO Enrollment;

    @NotNull
    private CourseDTO course;

    @NotNull
    private String classroom;
}
