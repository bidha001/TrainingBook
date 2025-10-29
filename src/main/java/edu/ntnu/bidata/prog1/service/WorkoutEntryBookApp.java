package edu.ntnu.bidata.prog1.service;

import edu.ntnu.bidata.prog1.ui.WorkoutEntryUi;

/**
 * The main application class for the Workout Entry Book.
 *
 * This class contains the main method which serves as the entry point
 * for the application. It initializes and starts the user interface
 * for managing workout entries.
 *
 * @version 2025-09-29
 * @author Binit Dhungana
 */
public class WorkoutEntryBookApp
{
/**
     * The main method to start the Workout Entry Book application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        WorkoutEntryUi workoutEntryUi = new WorkoutEntryUi();
        workoutEntryUi.init();
        workoutEntryUi.start();
    }
}

