package com.rodelindev.academyapi.controller;

import com.rodelindev.academyapi.dto.CourseDTO;
import com.rodelindev.academyapi.model.Course;
import com.rodelindev.academyapi.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/courses")
public class CourseController {

    private final ICourseService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getCourses() throws Exception {
        var list = service.findAll().stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Integer id) throws Exception {
        Course obj = service.findById(id);
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO dto) throws Exception {
        Course obj = service.save(convertToEntity(dto));
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(
            @Valid @PathVariable Integer id,
            @RequestBody CourseDTO dto
    ) throws Exception {
        Course obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    private CourseDTO convertToDTO(Course entity) {
        return modelMapper.map(entity, CourseDTO.class);
    }

    private Course convertToEntity(CourseDTO dto) {
        return modelMapper.map(dto, Course.class);
    }
}
