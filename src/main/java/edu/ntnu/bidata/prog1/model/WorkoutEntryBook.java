package edu.ntnu.bidata.prog1.model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of workout entries.
 *
 * @version 2025-09-29
 * @author Binit Dhungana
 */
public class WorkoutEntryBook {
    private final ArrayList<WorkoutEntry> workoutEntries;

    public WorkoutEntryBook() {
        this.workoutEntries = new ArrayList<>();
    }

    /**
     * Adds a new workout entry to the collection.
     *
     * @param entry the workout entry to add.
     * @throws IllegalArgumentException if the entry is null.
     */
    public void addEntry(WorkoutEntry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Workout entry cannot be null");
        }
        workoutEntries.add(entry);
    }

    /**
     * Returns a list of all workout entries.
     *
     * @return a list of all workout entries.
     */
    public List<WorkoutEntry> getAllEntries() {
        return new ArrayList<>(workoutEntries);
    }

    /**
     * Deletes a workout entry by its index.
     *
     * @param index the index of the workout entry to delete.
     * @return true if the entry was deleted, false if the index is invalid.
     */
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= workoutEntries.size()) {
            return false;
        }
        workoutEntries.remove(index);
        return true;
    }

    /**
     * Finds all workout entries for a specific date.
     *
     * @param date the date to search for.
     * @return a list of workout entries on the specified date.
     * @throws IllegalArgumentException if the date is null.
     */
    public List<WorkoutEntry> findByDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        List<WorkoutEntry> result = new ArrayList<>();
        for (WorkoutEntry e : workoutEntries) {
            if (e.timestamp().toLocalDate().equals(date)) {
                result.add(e);
            }
        }
        return result;
    }
}