package com.ecommerce.config;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Create default admin user if not exists
            if (!userRepository.existsByUsername("admin")) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@ecommerce.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setFirstName("Admin");
                admin.setLastName("User");
                userRepository.save(admin);
                System.out.println("✅ Default admin user created - Username: admin, Password: admin123");
            }

            // Create default test user if not exists
            if (!userRepository.existsByUsername("arun23")) {
                User user = new User();
                user.setUsername("arun23");
                user.setEmail("arun23@ecommerce.com");
                user.setPassword(passwordEncoder.encode("password123"));
                user.setFirstName("Arun");
                user.setLastName("Kumar");
                userRepository.save(user);
                System.out.println("✅ Default user created - Username: arun23, Password: password123");
            }
        };
    }
}
