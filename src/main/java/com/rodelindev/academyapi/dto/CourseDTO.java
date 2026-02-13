package com.rodelindev.academyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Integer idCourse;

    @NonNull
    private String name;

    @NonNull
    private String acronym;

    @NonNull
    private Boolean enabled;
}
