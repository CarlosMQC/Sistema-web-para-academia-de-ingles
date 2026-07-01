package com.academia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {
    
    @Id
    @EqualsAndHashCode.Include
    private Integer idRole;
    
    @Column(nullable = false, length = 70)
    private String name;
    
    @Column(nullable = true, length = 150)
    private String description;

    public Role() {
    }

    public Role(Integer idRole, String name, String description) {
        this.idRole = idRole;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }
}