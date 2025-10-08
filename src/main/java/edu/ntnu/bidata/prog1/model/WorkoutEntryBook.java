package edu.ntnu.bidata.prog1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manages a collection of workout entries.
 *
 * @version 2025-09-29
 * @author Binit Dhungana
 */
public class WorkoutEntryBook {
    private ArrayList<WorkoutEntry> entries;

    /**
     * Constructs an empty WorkoutEntryBook.
     */
    public WorkoutEntryBook() {
        this.entries = new ArrayList<>();
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
        entries.add(entry);
    }


    /**
     * Finds and prints all workout entries for a specific trainer name.
     *
     * @param trainerName the trainer name to search for.
     */
    public void findByTrainerName(String trainerName) {
        if (trainerName == null || trainerName.isBlank()) {
            System.out.println("Please provide a trainer name.");
            return;
        }
        String needle = trainerName.trim();
        boolean found = false;
        Iterator<WorkoutEntry> it = entries.iterator();
        while (it.hasNext()) {
            WorkoutEntry e = it.next();
            if (e.getTrainerName().equalsIgnoreCase(needle)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No entries found for trainer: " + trainerName);
        }
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
        for (WorkoutEntry e : entries) {
            if (e.getTimestamp().toLocalDate().equals(date)) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Deletes a workout entry by its index.
     *
     * @param index the index of the workout entry to delete.
     * @return true if the entry was deleted, false if the index is invalid.
     */
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= entries.size()) {
            return false;
        }
        entries.remove(index);
        return true;
    }


    /**
     * Returns the number of workout entries in the collection.
     *
     * @return the number of workout entries.
     */
    public int getNumbersOfEntries() {
        return this.entries.size();
    }

    /**
     * Returns an iterator over the workout entries.
     *
     * @return an iterator over the workout entries.
     */
    public Iterator<WorkoutEntry> getIterator() {
        return this.entries.iterator();
    }
}