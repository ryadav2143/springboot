package com.uvtech.springboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    private int id;
    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name cannot be null")
    private String name;
    @Column(unique = true)
    @Max(value=9999999999l)
    @Min(value=6000000000l)
    private long phone;
    @NotBlank(message = "Address is mandatory")
    @NotNull(message = "Address cannot be null")
    private String address;
    @Min(value = 1)
    private double salary;
    private char grade;

}
