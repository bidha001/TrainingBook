package edu.ntnu.bidata.prog1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a collection of workout entries.
 *
 * Add a workout entry to the collection.
 * Find workout entries by trainer name.
 * Find workout entries by workout type.
 * Find workout entries by date.
 * Delete a workout entry by index.
 * Get the number of workout entries in the collection.
 * Get an iterator over the workout entries.
 *
 * @version 2025-09-29
 * @author Binit Dhungana
 */
public class WorkoutEntryBook
{
    private ArrayList<WorkoutEntry> entries;

    /**
     * Creates an instance of WorkoutEntryBook.
     */
    public WorkoutEntryBook()
    {
        this.entries = new ArrayList<>();
    }


    /**
     * Adds a workout entry to the collection.
     *
     * @param entry the workout entry to be added.
     * @throws IllegalArgumentException if the entry is null.
     */
    public void addEntry(WorkoutEntry entry)
    {
        if (entry == null)
        {
            throw new IllegalArgumentException("Workout entry cannot be null");
        }
        entries.add(entry);
    }


    /**
     * Finds and prints all workout entries for a specific trainer name.
     *
     * @param trainerName the trainer name to search for.
     */
    public void findByTrainerName(String trainerName)
    {
        if (trainerName == null || trainerName.isBlank())
        {
            System.out.println("Please provide a trainer name.");
            return;
        }

        String needle = trainerName.trim();
        boolean found = false;
        Iterator<WorkoutEntry> it = entries.iterator();
        while (it.hasNext())
        {
            WorkoutEntry e = it.next();
            if (e.getTrainerName().equalsIgnoreCase(needle))
            {
                System.out.println(e);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("No entries found for trainer: " + trainerName);
        }
    }

    /**
     * Finds and prints all workout entries for a specific workout type.
     *
     * @param workout the workout type to search for.
     */
    public void findByWorkout(String workout)
    {
        if (workout == null || workout.isBlank())
        {
            System.out.println("Please provide a workout type.");
            return;
        }

        String needle = workout.trim();
        boolean found = false;
        Iterator<WorkoutEntry> it = entries.iterator();
        while (it.hasNext())
        {
            WorkoutEntry e = it.next();
            if (e.getWorkout().equalsIgnoreCase(needle))
            {
                System.out.println(e);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("No entries found for workout type: " + workout);
        }
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
    public boolean deleteByIndex(int index)
    {
        if (index < 0 || index >= entries.size())
        {
            return false;
        }
        entries.remove(index);
        return true;
    }


    /**
     * Returns the number of workout entries in the collection.
     *
     * @return the number of workout entries in the collection.
     */
    public int getNumbersOfEntries()
    {
        return this.entries.size();
    }

    /**
     * Returns an iterator over the workout entries in the collection.
     *
     * @return an iterator over the workout entries in the collection.
     */
    public Iterator<WorkoutEntry> getIterator()
    {
        return this.entries.iterator();
    }
}