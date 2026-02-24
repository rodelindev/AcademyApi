package com.rodelindev.academyapi.controller;

import com.rodelindev.academyapi.dto.EnrollmentDTO;
import com.rodelindev.academyapi.model.Enrollment;
import com.rodelindev.academyapi.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/enrollments")
public class EnrollmentController {

    private final IEnrollmentService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getEnrollments() throws Exception {
        var list = service.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/courses/students")
    public ResponseEntity<Map<String, List<String>>> getStudentsByCourse() {
        Map<String, List<String>> obj = service.getStudentsGroupedByCourse();
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> findById(@PathVariable Integer id) throws Exception {
        Enrollment obj = service.findById(id);
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> save(@Valid @RequestBody EnrollmentDTO dto) throws Exception {
        Enrollment obj = service.save(convertToEntity(dto));
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(
            @Valid @PathVariable Integer id,
            @RequestBody EnrollmentDTO dto
    ) throws Exception {
        Enrollment obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private EnrollmentDTO convertToDTO(Enrollment entity) {
        return modelMapper.map(entity, EnrollmentDTO.class);
    }

    private Enrollment convertToEntity(EnrollmentDTO dto) {
        return modelMapper.map(dto, Enrollment.class);
    }
}
