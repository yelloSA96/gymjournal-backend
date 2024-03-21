package me.thomassuebwicha.gymjournal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeightEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String exercise;
    private int sets;
    private int reps;

    public WeightEntry(Long id, String exercise, int sets, int reps) {
        this.id = id;
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
    }

    public WeightEntry() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "GymEntry{" +
                "id=" + id +
                ", exercise='" + exercise + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                '}';
    }
}

