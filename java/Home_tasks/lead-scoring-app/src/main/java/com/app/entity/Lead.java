package com.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "leads")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String phone;

    private String company;

    @PositiveOrZero(message = "Annual volume must be non-negative")
    private Double annualVolume;

    @NotBlank(message = "Trading experience is required")
    @Column(nullable = false)
    private String tradingExperience;

    private Integer responseScore;
    private Integer engagementScore;
    private Integer scoreTotal;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Long createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = System.currentTimeMillis();
        }
    }
}