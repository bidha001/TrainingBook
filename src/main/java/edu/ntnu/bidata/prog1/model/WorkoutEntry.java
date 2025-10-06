package edu.ntnu.bidata.prog1.model;

import java.time.LocalDateTime;

/**
 * Represents a workout entry with user, workout type, text description, and live date and time.
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
     *
     * @param trainerName the trainerName who did workout.
     * @param workout the type of workout.
     * @param text the details of workout.
     * @param timestamp the date and time when the workout was logged.
     */
    public WorkoutEntry(String trainerName, String workout, String text, LocalDateTime timestamp) {
        if (trainerName == null || trainerName.isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be null or empty");
        }
        if (workout == null || workout.isEmpty()) {
            throw new IllegalArgumentException("Workout cannot be null or empty");
        }
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }

        this.trainerName = trainerName;
        this.workout = workout;
        this.text = text;
        this.timestamp = (timestamp == null) ? LocalDateTime.now() : timestamp;

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
     * The details of workout.
     *
     * @return the details of workout.
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
}






