package com.example.The.Big.Project.model;


import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class UserDetails {
    private String email;
    private String username;
    private String password;
}
