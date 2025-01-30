package com.example.pos_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "users")
public class User{
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, name = "full_name")
    private String fullName;

    @Column(nullable = false, updatable = false, insertable = false)
    private java.sql.Timestamp createdAt;

    @Column(nullable = false, insertable = false)
    private java.sql.Timestamp updatedAt;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private Role role;

   public enum Role {
      ADMIN,
      CASHIER    
  }
}
