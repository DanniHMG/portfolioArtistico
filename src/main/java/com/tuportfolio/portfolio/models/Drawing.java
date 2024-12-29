package com.tuportfolio.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Drawing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String technique;
    private String fileName; // Cambiamos imageUrl por fileName
    private LocalDateTime createdAt;

    @Transient // Este campo no se guarda en la base de datos
    private String imageUrl;

    public String getImageUrl() {
        if (fileName != null) {
            return "/uploads/" + fileName;
        }
        return null;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}