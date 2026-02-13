package com.rodelindev.academyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class EnrollmentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollmentDetail;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "fk_detail_course"))
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_enrollment", nullable = false, foreignKey = @ForeignKey(name = "fk_detail_enrollment"))
    private Enrollment enrollment;

    @Column(nullable = false)
    private String classroom;
}
