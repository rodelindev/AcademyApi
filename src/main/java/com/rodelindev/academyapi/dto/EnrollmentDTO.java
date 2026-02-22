package com.rodelindev.academyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rodelindev.academyapi.model.Student;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    private Integer idEnrollment;

    @NotNull
    private LocalDateTime enrollmentDate;

    @NotNull
    private Student student;

    @NotNull
    private Boolean enabled;

    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;
}
