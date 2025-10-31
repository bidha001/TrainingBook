package edu.ntnu.bidata.prog1.ui;

import edu.ntnu.bidata.prog1.model.WorkoutEntry;
import edu.ntnu.bidata.prog1.model.WorkoutEntryBook;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Handles all user interaction, including input and output, for the Workout Entry Book application.
 * Provides methods to display menus, read user input, and perform actions such as adding,
 * listing, searching, and deleting workout entries.
 *
 * <ul>
 *   <li>Display the main menu and handle user selections.</li>
 *   <li>Print all workout entries.</li>
 *   <li>Add a new workout entry based on user input.</li>
 *   <li>Search for workout entries by trainer name.</li>
 *   <li>Search for workout entries by workout title.</li>
 *   <li>Search for workout entries by date.</li>
 *   <li>Delete a workout entry by index.</li>
 * </ul>
 *
 * @author Binit Dhungana
 * @version 2025-09-29
 */
public class WorkoutEntryUi
{
    private final WorkoutEntryBook workoutEntryBook;
    private final Scanner sc = new Scanner(System.in);

    /**
     * Constructs a WorkoutEntryUi instance with an empty WorkoutEntryBook.
     */
    public WorkoutEntryUi()
    {
        this.workoutEntryBook = new WorkoutEntryBook();
    }

    /**
     * Prints all workout entries in the workout entry book.
     * If there are no entries, informs the user accordingly.
     * Otherwise, lists all entries with their respective indices.
     */
    public void printAllEntries()
    {
        Iterator<WorkoutEntry> it = this.workoutEntryBook.getIterator();
        int count = workoutEntryBook.getNumberOfEntries();
        if (count == 0)
        {
            System.out.println("No workout entries found.");
            return;
        }

        System.out.println("Total entries: " + count);
        int i = 0;
        while (it.hasNext())
        {
            System.out.println("[" + (++i) + "] " + it.next());
        }
    }

    /**
     * Deletes a workout entry by its index based on user input.
     * Prompts the user for the index of the entry to delete.
     * If the index is valid, deletes the entry and confirms the deletion.
     * If the index is invalid or not a number, informs the user accordingly.
     */
    private void deleteByIndex()

    {
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

    /**
     * Fills the workout entry book with predefined test data.
     * Adds several workout entries with sample trainer names, workout titles, and details.
     */
    private void fillWithTestData()
    {
        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Binit",
                "Squat",
                "Started with a warm-up of 12 reps without any weights. "
                        + "Then performed 4 working sets, beginning at 20 kg and increasing the weight by 15 kg each set, "
                        + "finishing with 60 kg in the final set.",
                null
        ));

        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Anish",
                "Bench Press",
                "Completed 3 sets of 10 reps at 450 kg with 90 seconds of rest between sets. "
                        + "For the final heavy set, increased the load to 1000 kg and managed 6 solid reps.",
                null
        ));

        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Omkar",
                "Deadlift",
                "Started with leg and back stretches to prevent soreness during the workout. "
                        + "Warmed up with 60 kg, then performed 4 working sets of 12 reps, "
                        + "starting at 120 kg and adding 20 kg with each set.",
                null
        ));

        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Shraddha",
                "Biceps",
                "Began with 2 warm-up sets of 8 reps at 10 kg to warm up the muscles. "
                        + "Then performed 3 main sets of 12 reps at 10 kg, focusing on form, control, and proper technique.",
                null
        ));

        this.workoutEntryBook.addEntry(new WorkoutEntry(
                "Sawbeen",
                "Triceps",
                "Started with 2 warm-up sets of 8 reps at 20 kg. "
                        + "Followed by 4 working sets of 12 reps at 30 kg, "
                        + "increasing the weight by 10 kg each set while maintaining good form throughout.",
                null
        ));
    }

    /**
     * Displays the main menu and prompts the user for a choice.
     *
     * @return the user's menu choice as an integer.
     */
    private int showMenu()
    {
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
     * Prompts the user for trainer name, workout title, and details.
     * Creates a new WorkoutEntry and adds it to the workout entry book.
     */
    private void addEntryFromInput()
    {
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
    private void searchByTrainerName()
    {
        System.out.print("Enter trainer name: ");
        String name = sc.nextLine();

        var matches = workoutEntryBook.findByTrainerName(name);

        if (matches.isEmpty()) {
            System.out.println("No entries found for trainer: " + name);
        } else {
            System.out.println("Entries for trainer: " + name);
            for (int i = 0; i < matches.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + matches.get(i));
            }
        }
    }

    /**
     * Searches for workout entries by workout title.
     * Prompts the user for a workout title and displays all matching entries.
     * If no entries are found, informs the user accordingly.
     */
    private void searchByWorkout()
    {
        System.out.print("Enter workout title: ");
        String workout = sc.nextLine();

        var matches = workoutEntryBook.findByWorkout(workout);

        if (matches.isEmpty()) {
            System.out.println("No entries found for workout: " + workout);
        } else {
            System.out.println("Entries for workout: " + workout);
            for (int i = 0; i < matches.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + matches.get(i));
            }
        }
    }

    /**
         * Searches for workout entries by date.
         * Prompts the user for a date in the format yyyy-MM-dd and displays all entries from that date.
         * If no entries are found or if the date format is invalid, informs the user accordingly.
         */
    private void searchByDate()
    {
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
     * Starts the user interface, displaying the menu and handling user input.
     * Continues to prompt the user until they choose to quit.
     */
    public void start()
    {
        boolean finished = false;
        while (!finished) {
            switch (showMenu())
            {
                case 1 -> addEntryFromInput();
                case 2 -> printAllEntries();
                case 3 -> searchByTrainerName();
                case 4 -> searchByWorkout();
                case 5 -> searchByDate();
                case 6 -> deleteByIndex();
                case 7 ->
                {
                    System.out.println("Thank you!");
                    sc.close();
                    finished = true;
                }
                    default -> System.out.println("Please choose a number 1–6.");
            }
        }
    }

    /**
     * Initializes the user interface with test data.
     */
    public void init()
    {
        fillWithTestData();
    }
}




