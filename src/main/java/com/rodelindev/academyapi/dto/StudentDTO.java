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
public class StudentDTO {

    private Integer idStudent;

    @NonNull
    private String first_name;

    @NonNull
    private String last_name;

    @NonNull
    private String DNI;

    @NonNull
    private Integer age;
}
