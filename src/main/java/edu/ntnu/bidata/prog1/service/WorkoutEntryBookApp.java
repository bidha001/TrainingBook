package edu.ntnu.bidata.prog1.service;

import edu.ntnu.bidata.prog1.ui.WorkoutEntryUi;

/**
 * The main application class for the Workout Entry Book.
 * It initializes and starts the user interface and starting the concole-based interaction
 * for managing workout entries.
 *
 * @version 2025-09-29
 * @author Binit Dhungana
 */
public class WorkoutEntryBookApp
{
    /**
     * Starts the Workout Entry Book application.
     *<p>
     * This method initializes the UI and loads any predefines
     * test data, and start the main interaction loop where users can add, list,
     * search, and delete workout entries.
     *</p>
     * @param args command-line arguments.
     */
    public static void main(String[] args)
    {
        WorkoutEntryUi workoutEntryUi = new WorkoutEntryUi();
        workoutEntryUi.init();
        workoutEntryUi.start();
    }
}

