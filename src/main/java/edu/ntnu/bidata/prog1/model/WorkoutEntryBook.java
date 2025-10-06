package edu.ntnu.bidata.prog1.model;

import java.util.ArrayList;

public class WorkoutEntryBook
{
    private final ArrayList<WorkoutEntry> entries = new ArrayList<>();

    public void addEntry(WorkoutEntry entry)
    {
        entries.add(entry);
    }

    public ArrayList<WorkoutEntry> getEntries()
    {
        return new ArrayList<>(entries);
    }

    // return new list of entries.
    //delete as entrty
    //find entry from specific date
    // find entry by trainerName
    // find entry by workout type

}