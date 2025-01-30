package com.example.pos_system.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Id;
//import org.springframework.format.annotation.DurationFormat.Unit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.EnumType;

@Entity
@Getter
@Setter

@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Unit unit;

    @Column(nullable = false)
    private int stock;

    @Temporal(TemporalType.DATE)
    private LocalDate expiryDate;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, insertable = false)
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false, insertable = false)
    private java.sql.Timestamp updatedAt;

    public enum Unit {
        KG, LITRE, PCS, BOX
    }

    public Long getCategoryId() {
        return category != null ? category.getId() : null;
    }
}
