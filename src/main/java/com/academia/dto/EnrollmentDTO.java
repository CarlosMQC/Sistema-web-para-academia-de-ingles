package com.academia.dto;

import org.springframework.hateoas.RepresentationModel;

public class EnrollmentDTO extends RepresentationModel<EnrollmentDTO> {

    private Integer idEnrollment;
    private StudentDTO student;
    private CourseDTO course;
    private boolean status;

    public Integer getIdEnrollment() {
        return idEnrollment;
    }

    public void setIdEnrollment(Integer idEnrollment) {
        this.idEnrollment = idEnrollment;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}