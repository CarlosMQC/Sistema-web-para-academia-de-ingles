package com.academia.dto;

import java.time.LocalDateTime;

public class EnrollmentDTO {

    private Integer idEnrollment;
    private LocalDateTime datetime;
    private StudentDTO student;
    private Boolean enabled;

    public Integer getIdEnrollment() {
        return idEnrollment;
    }

    public void setIdEnrollment(Integer idEnrollment) {
        this.idEnrollment = idEnrollment;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}