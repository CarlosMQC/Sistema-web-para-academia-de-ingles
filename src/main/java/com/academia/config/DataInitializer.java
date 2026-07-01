package com.academia.config;

import com.academia.model.Role;
import com.academia.model.User;
import com.academia.repository.RoleRepository;
import com.academia.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.ArrayList;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            Role adminRole = roleRepository.findById(1).orElseGet(() -> {
                Role newRole = new Role(1, "ADMIN", "Administrador del sistema");
                return roleRepository.save(newRole);
            });

            roleRepository.findById(2).orElseGet(() -> {
                Role studentRole = new Role(2, "STUDENT", "Estudiante de la academia");
                return roleRepository.save(studentRole);
            });

            if (userRepository.findByUsername("admin").isEmpty()) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("12345"));
                admin.setEnabled(true);
                admin.setRoles(new ArrayList<>(Arrays.asList(adminRole)));
                
                userRepository.save(admin);
            }
        };
    }
}