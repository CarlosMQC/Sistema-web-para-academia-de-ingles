package com.academia.dto;

import org.springframework.hateoas.RepresentationModel;

public class StudentDTO extends RepresentationModel<StudentDTO> {

    private Integer idStudent;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private boolean status;

    public Integer getIdStudent() { return idStudent; }
    public void setIdStudent(Integer idStudent) { this.idStudent = idStudent; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}