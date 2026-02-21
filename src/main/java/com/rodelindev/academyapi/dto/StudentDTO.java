package com.rodelindev.academyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "first_name")

    private String firstName;

    @NonNull
    @JsonProperty( value = "last_name")
    private String lastName;

    @NonNull
    @JsonProperty( value = "dni")
    private String DNI;

    @NonNull
    private Integer age;
}
