package com.rodelindev.academyapi.controller;

import com.rodelindev.academyapi.dto.StudentDTO;
import com.rodelindev.academyapi.model.Student;
import com.rodelindev.academyapi.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents() throws Exception {
        var list = service.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/students/age/desc")
    public ResponseEntity<List<StudentDTO>> getStudentsDesc() throws Exception {
        var list = service.findAllStudentsDesc()
                .stream()
                .map(this::convertToDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) throws Exception {
        Student obj = service.findById(id);
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO dto) throws Exception {
        Student obj = service.save(convertToEntity(dto));
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(
            @Valid @PathVariable Integer id,
            @RequestBody StudentDTO dto
    ) throws Exception {
        Student obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private StudentDTO convertToDTO(Student entity) {
        return modelMapper.map(entity, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }
}
