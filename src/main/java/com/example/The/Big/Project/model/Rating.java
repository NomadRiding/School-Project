package com.example.The.Big.Project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer plot;
    private Integer pace;
    private Integer tone;
    private Integer worldDevelopment;
    private Integer reRead;
    @Column(name = "average_rating")
    private double averageRating = 0.0;

    @JsonBackReference
    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;


    @Override
    public String toString() {
        return "Rating{" +
                "reRead=" + reRead +
                ", worldDevelopment=" + worldDevelopment +
                ", tone=" + tone +
                ", pace=" + pace +
                ", plot=" + plot +
                ", id=" + id +
                '}';
    }
}
