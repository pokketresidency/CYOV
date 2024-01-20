package com.cyov.marketplace.model.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phoneNumberId;

    @Column(nullable = false)
    private String phoneNumber;

    private String type;

    private Boolean isPrimary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and Setters
}
