package edu.ntnu.bidata.prog1.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * Represents a workout entry with user, workout type, text description, and date and time.
 *
 * @author Binit Dhungana
 * @version 2025-09-29
 */
public class WorkoutEntry {
    private final String trainerName;
    private final String workout;
    private final String text;
    private final LocalDateTime timestamp;

    /**
     * Constructs a WorkoutEntry with the specified details.
     *
     * @param trainerName the user who made workout.
     * @param workout     the type of workout.
     * @param text        the details of what has been done.
     * @param timestamp   the date and time when the workout was logged.
     */
    public WorkoutEntry(String trainerName, String workout, String text, LocalDateTime timestamp) {
        this.trainerName = trainerName;
        this.workout = workout;
        this.text = text;
        this.timestamp = (timestamp == null) ? LocalDateTime.now() : timestamp;

        if (trainerName == null || trainerName.isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be null or empty");
        }
        if (workout == null || workout.isEmpty()) {
            throw new IllegalArgumentException("Workout cannot be null or empty");
        }
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
    }

    /**
     * The user who made workout.
     *
     * @return the user who made workout.
     */
    public String getTrainerName() {
        return trainerName;
    }

    /**
     * The type of workout.
     *
     * @return the type of workout.
     */
    public String getWorkout() {
        return workout;
    }

    /**
     * The details of what has been done.
     *
     * @return the details of what has been done.
     */
    public String getText() {
        return text;
    }


    /**
     * The date and time when the workout was logged.
     *
     * @return the date and time when the workout was logged in and out.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * The type of workout.
     *
     * @return the type of workout.
     */
    @Override
    public String toString() {
        return "Trainer: " + trainerName
                + " | Title: " + workout
                + " | When: " + timestamp
                + "\n  Text: " + text;
    }
}






