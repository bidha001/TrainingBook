package edu.ntnu.bidata.prog1.ui;

import edu.ntnu.bidata.prog1.model.WorkoutEntry;
import edu.ntnu.bidata.prog1.model.WorkoutEntryBook;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Responsible for all user interaction, input and output.
 * <ul>
 *   <li>Show menu and get selection from user</li>
 *   <li>Based on menu selected:</li>
 *   <ul>
 *     <li>Print all workout entries</li>
 *     <li>Add new workout entry based on user input</li>
 *     <li>Search for workout entry by trainer name or date given by user</li>
 *     <li>Delete workout entry by index</li>
 *   </ul>
 * </ul>
 */
public class WorkoutEntryUi {
    private final WorkoutEntryBook workoutEntryBook;
    private final Scanner sc = new Scanner(System.in);

    /**
     * Creates an instance of WorkoutEntryUi.
     */
    public WorkoutEntryUi() {
        this.workoutEntryBook = new WorkoutEntryBook();
    }

    /**
     * Prints all workout entries to the console.
     *
     * <p>This version uses a while-loop and Iterator to iterate over all
     * the workout entry elements in the workout entry book.
     * It also prints the total number of entries at the beginning.
     */
    public void printAllEntries() {
        Iterator<WorkoutEntry> it = this.workoutEntryBook.getIterator();
        int count = workoutEntryBook.getNumbersOfEntries();
        if (count == 0) {
            System.out.println("No workout entries found.");
            return;
        }

        System.out.println("Total entries: " + count);
        int i = 0;
        while (it.hasNext()) {
            System.out.println("[" + (++i) + "] " + it.next());
        }
    }


    /**
     * Deletes a workout entry by its index.
     * Prompts the user for the index and attempts to delete the corresponding entry.
     * Provides feedback on whether the deletion was successful or if the index was invalid.
     */
    private void deleteByIndex() {
        System.out.print("Index to delete (0-based): ");
        String s = sc.nextLine();
        try {
            int idx = Integer.parseInt(s.trim());
            boolean ok = workoutEntryBook.deleteByIndex(idx);
            System.out.println(ok ? "Deleted." : "Invalid index.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        }
    }

    /** Fills the workout entry book with some test data.
     *
     * This method is useful for testing and demonstration purposes.
     */
    private void fillWithTestData() {
        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Binit",
                "Treadmill",
                "Completed a 5 km run at a steady pace. Focused on maintaining a heart rate of around 140 bpm. "
                        + "Started with a 5-minute warm-up walk and ended with 3 minutes of cooldown at a slower speed.",
                null
        ));

        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Anna",
                "Bench Press",
                "Performed 3 sets of 10 reps at 45 kg. Took 90 seconds of rest between each set. "
                        + "Focused on slow descent and proper breathing technique. Felt stable shoulder engagement today.",
                null
        ));

        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Binit",
                "Cycling",
                "20-minute indoor cycling session at moderate resistance. "
                        + "Maintained cadence between 85–90 RPM. "
                        + "Included two 30-second sprints at the end for intensity boost.",
                null
        ));

        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Sofia",
                "Deadlift",
                "Warm-up: 2 sets of 8 reps at 60 kg. "
                        + "Main sets: 3 sets of 5 reps at 90 kg. Focused on form and hip drive. "
                        + "Lower back felt slightly tight after the last set, noted for next session.",
                null
        ));

        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Jonas",
                "Swimming",
                "Swam 40 laps (1 km total) focusing on freestyle technique. "
                        + "Alternated between steady and sprint intervals. "
                        + "Worked on breathing every 3 strokes to improve endurance.",
                null
        ));

    }

    /**
     * Displays the menu to the user and captures their selection.
     *
     * @return the menu choice entered by the user as an integer.
     *         Returns -1 if the input is invalid (not a number).
     */
    private int showMenu() {
        int menuChoice = 0;

        System.out.println("\n***** Workout Entry Application v0.1 *****");
        System.out.println("1. Add workout entry");
        System.out.println("2. List all workout entries");
        System.out.println("3. Search by trainer name");
        System.out.println("4. Search by workout title");
        System.out.println("5. Search by date (yyyy-MM-dd)");
        System.out.println("6. Delete by index");
        System.out.println("7. Quit");
        System.out.print("Choose (1-7): ");
        String line = sc.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Adds a new workout entry based on user input.
     * Prompts the user for trainer name, workout title, and details,
     * then creates a new WorkoutEntry and adds it to the workout entry book.
     *
     */
        private void addEntryFromInput() {
            System.out.print("Trainer name: ");
            String name = sc.nextLine();
            System.out.print("Workout title: ");
            String title = sc.nextLine();
            System.out.print("Details: ");
            String text = sc.nextLine();

            WorkoutEntry entry = new WorkoutEntry(name, title, text, LocalDateTime.now());
            workoutEntryBook.addEntry(entry);
            System.out.println("Entry added.");
        }

        /**
         * Searches for workout entries by trainer name.
         * Prompts the user for a trainer name and displays all matching entries.
         * If no entries are found, informs the user accordingly.
         */
        private void searchByTrainerName() {
            System.out.print("Enter trainer name: ");
            String name = sc.nextLine();
            workoutEntryBook.findByTrainerName(name);
        }

        /**
         * Searches for workout entries by workout title.
         * Prompts the user for a workout title and displays all matching entries.
         * If no entries are found, informs the user accordingly.
         */
        private void searchByWorkout(){
            System.out.print("Enter workout title: ");
            String workout = sc.nextLine();
            workoutEntryBook.findByWorkout(workout);
        }

        /**
         * Searches for workout entries by date.
         * Prompts the user for a date in the format yyyy-MM-dd and displays all entries from that date.
         * If no entries are found or if the date format is invalid, informs the user accordingly.
         */
        private void searchByDate() {
            System.out.print("Enter date (yyyy-MM-dd): ");
            String s = sc.nextLine();
            try {
                LocalDate d = LocalDate.parse(s.trim());
                var list = workoutEntryBook.findByDate(d);
                if (list.isEmpty()) {
                    System.out.println("No entries on " + d + ".");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i));
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid date format.");
            }
        }

    /**
     * Initializes the user interface by filling the workout entry book with test data.
     */
    public void init() {
            fillWithTestData();
        }

        /**
         * Starts the user interface. This is the main method for running the application.
         * The application stays in this method as long as the user has not decided to quit.
         */
        public void start() {
            boolean finished = false;
            while (!finished) {
                switch (showMenu()) {
                    case 1 -> addEntryFromInput();
                    case 2 -> printAllEntries();
                    case 3 -> searchByTrainerName();
                    case 4 -> searchByWorkout();
                    case 5 -> searchByDate();
                    case 6 -> deleteByIndex();
                    case 7 -> {
                        System.out.println("Thank you!");
                        sc.close();
                        finished = true;
                    }
                    default -> System.out.println("Please choose a number 1–6.");
                }
            }
        }
    }




