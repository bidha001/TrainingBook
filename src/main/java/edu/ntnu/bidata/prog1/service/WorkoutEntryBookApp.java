package edu.ntnu.bidata.prog1.service;

import edu.ntnu.bidata.prog1.ui.WorkoutEntryUi;

public class WorkoutEntryBookApp {
    public static void main(String[] args) {
        WorkoutEntryUi workoutEntryUi = new WorkoutEntryUi();
        workoutEntryUi.init();
        workoutEntryUi.start();
    }
}

