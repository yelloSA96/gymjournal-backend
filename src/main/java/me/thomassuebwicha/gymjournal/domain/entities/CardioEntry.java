package me.thomassuebwicha.gymjournal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CardioEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String exercise;
    private int duration; // in minutes
    private int distance; // in meters

    public CardioEntry(Long id, String exercise, int duration, int distance) {
        this.id = id;
        this.exercise = exercise;
        this.duration = duration;
        this.distance = distance;
    }

    public CardioEntry() {

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    @Override
    public String toString() {
        return "CardioEntry{" +
                "id=" + id +
                ", exercise='" + exercise + '\'' +
                ", duration=" + duration +
                ", distance=" + distance +
                '}';
    }
}