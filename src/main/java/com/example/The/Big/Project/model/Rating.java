package com.example.The.Big.Project.model;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Rating {
    private Integer plot;
    private Integer pace;
    private Integer tone;
    private Integer worldDevelopment;
    private Integer reRead;
}
