package com.rodelindev.academyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rodelindev.academyapi.model.EnrollmentDetail;
import com.rodelindev.academyapi.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    private Integer idEnrollment;

    @NonNull
    private LocalDateTime enrollmentDate;

    @NonNull
    private Student student;

    @NonNull
    private List<EnrollmentDetail> details;

    @NonNull
    private Boolean enabled;
}
