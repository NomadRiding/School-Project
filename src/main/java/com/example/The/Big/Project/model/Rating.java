package com.example.The.Big.Project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Rating {
    @Id
    private Integer plot;
    private Integer pace;
    private Integer tone;
    private Integer worldDevelopment;
    private Integer reRead;
}
