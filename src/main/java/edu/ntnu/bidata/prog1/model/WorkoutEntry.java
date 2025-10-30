package edu.ntnu.bidata.prog1.model;

import java.time.LocalDateTime;

/**
 * Represents a workout entry with user, workout type, text description, and date and time.
 *
 * @author Binit Dhungana
 * @version 2025-09-29
 */
public class WorkoutEntry
{
    private final String trainerName;
    private final String workout;
    private final String text;
    private final LocalDateTime timestamp;

  /**
     * Create an instance of WorkoutEntry.
     *
     * @param trainerName the name of the user who made the workout.
     * @param workout     the type of workout.
     * @param text        description of the workout.
     * @param timestamp   the date and time when the workout was logged. If null, current date and time is used.
     * @throws IllegalArgumentException if trainerName or workout is null or empty, or if text is null.
     */
    public WorkoutEntry(String trainerName, String workout, String text, LocalDateTime timestamp)
    {
        if (trainerName == null || trainerName.isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be null or empty");
        }
        if (workout == null || workout.isEmpty()) {
            throw new IllegalArgumentException("Workout cannot be null or empty");
        }
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }

        this.trainerName = trainerName;
        this.workout = workout;
        this.text = text;
        this.timestamp = (timestamp == null) ? LocalDateTime.now() : timestamp;
    }

    /**
     * Trainer name who made workout.
     *
     * @return the trainer name who made workout.
     */
    public String getTrainerName()
    {
        return trainerName;
    }

    /**
     * The type of workout.
     *
     * @return the type of workout.
     */
    public String getWorkout()
    {
        return workout;
    }

    /**
     * The description text of the workout.
     *
     * @return the description text of the workout.
     */
    public String getText(){
        return text;
    }


    /**
     * The date and time when the workout was logged in the system.
     *
     * @return the date and time when the workout was logged in the system.
     */
    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    /**
     * Returns a string representation of the workout entry.
     *
     * @return a string representation of the workout entry.
     */
    @Override
    public String toString()
    {
        return "Trainer: " + trainerName
                + "\nTitle: " + workout
                + "\nWhen: " + timestamp
                + "\nText: " + text
                + "\n-------------------------------";

    }
}






