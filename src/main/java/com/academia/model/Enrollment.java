package com.academia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollment;

    @ManyToOne
    @JoinColumn(name="id_student", nullable = false, 
                foreignKey = @ForeignKey(name="FK_ENROLLMENT_STUDENT"))
    private Student student;

    @ManyToOne
    @JoinColumn(name="id_course", nullable = false, 
                foreignKey = @ForeignKey(name="FK_ENROLLMENT_COURSE"))
    private Course course;

    @Column(nullable = false)
    private boolean status;
}