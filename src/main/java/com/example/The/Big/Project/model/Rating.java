package com.example.The.Big.Project.model;


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
    private double averageRating;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


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
