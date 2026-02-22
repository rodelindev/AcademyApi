package com.rodelindev.academyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotNull
    @JsonProperty( value = "last_name")
    private String lastName;

    @NotNull
    @JsonProperty( value = "dni")
    private String DNI;

    @NotNull
    private Integer age;
}
