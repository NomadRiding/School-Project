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
    @Column(name = "plot")
    private Integer plot;

    @Column(name = "pace")
    private Integer pace;

    @Column(name = "tone")
    private Integer tone;

    @Column(name = "world_development")
    private Integer worldDevelopment;

    @Column(name = "re_read")
    private Integer reRead;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private double averageRating;

    public double calculateAverageRating() {
        return (plot + pace + tone + worldDevelopment + reRead) / 5.0;
    }
    private void updateAverageRating() {
        this.averageRating = calculateAverageRating();
    }

    public void setPlot(Integer plot) {
        this.plot = plot;
        updateAverageRating();
    }

    public void setPace(Integer pace) {
        this.pace = pace;
        updateAverageRating();
    }

    public void setTone(Integer tone) {
        this.tone = tone;
        updateAverageRating();
    }

    public void setWorldDevelopment(Integer worldDevelopment) {
        this.worldDevelopment = worldDevelopment;
        updateAverageRating();
    }

    public void setReRead(Integer reRead) {
        this.reRead = reRead;
        updateAverageRating();
    }

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
