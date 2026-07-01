package com.academia.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(name = "document_number", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false)
    private boolean status;

    public Student() {
    }

    public Integer getIdStudent() { 
        return idStudent; 
    }
    
    public void setIdStudent(Integer idStudent) { 
        this.idStudent = idStudent; 
    }

    public String getFirstName() { 
        return firstName; 
    }
    
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
    
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    public String getDni() { 
        return dni; 
    }
    
    public void setDni(String dni) { 
        this.dni = dni; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }

    public boolean isStatus() { 
        return status; 
    }
    
    public void setStatus(boolean status) { 
        this.status = status; 
    }
}