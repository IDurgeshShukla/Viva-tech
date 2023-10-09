package com.example.VivatechProject.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    private Integer mobileNo;
    private String userName;

}
