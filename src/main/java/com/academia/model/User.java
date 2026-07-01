package com.academia.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUser;
    
    @Column(nullable = false, length = 70, unique = true)
    private String username;
    
    @Column(nullable = false, length = 100)
    private String password;
    
    @Column(nullable = false)
    private boolean enabled;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name= "user_role",
            joinColumns= @JoinColumn(name="id_user", referencedColumnName = "idUser"),
            inverseJoinColumns =  @JoinColumn(name="id_role", referencedColumnName = "idRole"))
    private List<Role> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student", nullable = true)
    private Student student;

    public String getUsername() {
        return this.username;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public Student getStudent() {
        return this.student;
    }
	public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
	public void setStudent(Student student) {
        this.student = student;
    }
}