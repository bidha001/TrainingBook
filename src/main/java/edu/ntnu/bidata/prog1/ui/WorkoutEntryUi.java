package edu.ntnu.bidata.prog1.ui;

import edu.ntnu.bidata.prog1.model.WorkoutEntry;
import edu.ntnu.bidata.prog1.model.WorkoutEntryBook;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class WorkoutEntryUi {
    private final WorkoutEntryBook workoutEntryBook;
    //read about this scanner class
    private final Scanner sc = new Scanner(System.in);

    public WorkoutEntryUi() {
        this.workoutEntryBook = new WorkoutEntryBook();
    }

    //read about this println method
    private void printWorkoutEntryDetails(WorkoutEntry entry) {
        System.out.println(entry);
    }

    //read about this iterator pattern
    public void printAllEntries() {
        Iterator<WorkoutEntry> it = this.workoutEntryBook.getIterator();
        int i = 0;
        if (!it.hasNext()) {
            System.out.println("No workout entries found.");
        }
        while (it.hasNext()) {
            System.out.println("[" + (++i) + "] " + it.next());
        }
    }

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

    private int showMenu() {
        int menuChoice = 0;

        System.out.println("\n***** Workout Entry Application v0.1 *****");
        System.out.println("1. Add workout entry");
        System.out.println("2. List all workout entries");
        System.out.println("3. Search by trainer name");
        System.out.println("4. Search by date (yyyy-MM-dd)");
        System.out.println("5. Quit");
        System.out.print("Choose (1-5): ");
        String line = sc.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
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

        private void searchByTrainerName() {
            System.out.print("Enter trainer name: ");
            String name = sc.nextLine();
            workoutEntryBook.findByTrainerName(name);
        }

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

        public void init() {
            fillWithTestData();
        }

        public void start() {
            boolean finished = false;
            while (!finished) {
                switch (showMenu()) {
                    case 1 -> addEntryFromInput();
                    case 2 -> printAllEntries();
                    case 3 -> searchByTrainerName();
                    case 4 -> searchByDate();
                    case 5 -> {
                        System.out.println("Thank you!");
                        finished = true;
                    }
                    default -> System.out.println("Please choose a number 1–5.");
                }
            }
        }
    }



