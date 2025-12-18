package com.astik.microservice.inventry.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventry_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Inventry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String skuCode;
    private int quantity;
}
