package edu.ntnu.bidata.prog1.model;

import java.time.LocalDate;
import java.util.*;

/**
 * Represents a collection of workout entries which allows adding,searching, and removing workout entries.
 * Users can retrieve entries based on trainer name, workout type, or date,
 * as well as obtain the total number of stored entries or iterate through them.
 *
 * <ul>
 * <li>Add a workout entry to the collection.<li>
 * <li>Find workout entries by trainer name.<li>
 * <li>Find workout entries by workout type.<li>
 * <li>Find workout entries by date.<li>
 * <li>Delete a workout entry by index.<li>
 * <li>Get the number of workout entries in the collection.<li>
 * <li>Get an iterator over the workout entries.<li>
 *</ul>
 *
 * @version 2025-09-29
 * @author Binit Dhungana
 */
public class WorkoutEntryBook
{
    private final List<WorkoutEntry> entries = new ArrayList<>();

    // Map to keep track of trainer statistics
    private final LinkedHashMap<String, Integer> trainerCounts = new LinkedHashMap<>();

    /**
     * Registers a new trainer in the register.
     * If the trainer already exists, no action is taken.
     *
     * @param name the name of the trainer to be registered.
     * @throws IllegalArgumentException if the name is null or blank.
     */
    public void registerTrainer(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Trainer name cannot be null or blank");
        }
        String key = name.trim();
        trainerCounts.putIfAbsent(key, 0);
    }

    /**
     * Returns a list of all registered trainers.
     */
    public List<String> getTrainers() {
        return new ArrayList<>(trainerCounts.keySet());
    }

    /**
     * Returns a map of trainer names to their corresponding workout entry counts.
     */
    public Map<String, Integer> getTrainerStats() {
        return new LinkedHashMap<>(trainerCounts);
    }


    /**
     * Adds  workout entry to the collection in WorkoutEntryBook.
     *
     * @param entry the workout entry to be added in the collection.
     * @throws IllegalArgumentException if the entry is null.
     */
    public void addEntry(WorkoutEntry entry)
    {
        if (entry == null)
        {
            throw new IllegalArgumentException("Workout entry cannot be null");
        }
        entries.add(entry);

        String trainer = entry.getTrainerName().trim();
        trainerCounts.put(trainer, trainerCounts.getOrDefault(trainer, 0) + 1);
    }

    /**
     * Finds and returns a list of workout entries for a specific trainer name.
     *
     * @param trainerName the trainer name to search for.
     * @return a list of workout entries for the specified trainer name.
     */
    public List<WorkoutEntry> findByTrainerName(String trainerName)
    {
        if (trainerName == null || trainerName.isBlank())
        {
            return List.of(); // Return an empty list if invalid input
        }

        String needle = trainerName.trim();
        List<WorkoutEntry> result = new ArrayList<>();

        for (WorkoutEntry e : entries)
        {
            if (e.getTrainerName().equalsIgnoreCase(needle))
            {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Finds and returns a list of workout entries for a specific workout type.
     *
     * @param workout the workout type to search for.
     * @return a list of workout entries for the specified workout type.
     */
    public List<WorkoutEntry> findByWorkout(String workout)
    {
        if (workout == null || workout.isBlank())
        {
            return List.of();
        }

        String needle = workout.trim();
        List<WorkoutEntry> result = new ArrayList<>();

        for (WorkoutEntry e : entries)
        {
            if (e.getWorkout().equalsIgnoreCase(needle))
            {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Finds and returns a list of workout entries for a specific date.
     *
     * @param date the date to search for.
     * @return a list of workout entries for the specified date.
     * @throws IllegalArgumentException if the date is null.
     */
    public List<WorkoutEntry> findByDate(LocalDate date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Date cannot be null");
        }
        List<WorkoutEntry> result = new ArrayList<>();
        for (WorkoutEntry e : entries)
        {
            if (e.getTimestamp().toLocalDate().equals(date))
            {
                result.add(e);
            }
        }
        return result;
    }


    /**
     * Deletes a workout entry by its index in the collection.
     *
     * @param index the index of the workout entry to be deleted.
     * @return true if the entry was successfully deleted, false if the index is invalid.
     */
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= entries.size()) {
            return false;
        }
        WorkoutEntry removed = entries.remove(index);

        // keep trainer register in sync
        String trainer = removed.getTrainerName().trim();
        int newCount = trainerCounts.getOrDefault(trainer, 0) - 1;
        if (newCount <= 0) {
            trainerCounts.remove(trainer);
        } else {
            trainerCounts.put(trainer, newCount);
        }
        return true;
    }
    /**
     * Returns the number of workout entries in the collection.
     *
     * @return the number of workout entries in the collection.
     */
    public int getNumberOfEntries()
    {
        return entries.size();
    }

    /**
     * Returns an iterator over the workout entries in the collection.
     *
     * @return an iterator over the workout entries in the collection.
     */
    public Iterator<WorkoutEntry> getIterator()
    {
        return entries.iterator();
    }
}