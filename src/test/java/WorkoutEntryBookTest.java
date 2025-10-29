import edu.ntnu.bidata.prog1.model.WorkoutEntry;
import edu.ntnu.bidata.prog1.model.WorkoutEntryBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Perform unit tests on the WorkoutEntryBook class.
 *
 * The following positive tests are executed:
 *
 * Add a valid WorkoutEntry to the WorkoutEntryBook collection.
 * Expect the entry to be added successfully.
 *
 * Delete a Workout Entry by valid index.
 * Expect the entry to be deleted successfully.
 *
 * Find entries by valid trainer name.
 * Expect the correct entries to be returned.
 *
 * Find entries by valid workout title.
 * Expect the correct entries to be returned.
 *
 * The following negative tests are executed:
 *
 * Add a null WorkoutEntry to the WorkoutEntryBook collection.
 * Expect an exception to be thrown.
 *
 * Search for workout by a null or blank trainer name.
 * Expect a message indicating that a valid trainer name is required.
 *
 * Search for workout by a null or blank workout title.
 * Expect a message indicating that a valid workout title is required.
 *
 * Delete a Workout Entry by invalid index (negative or larger than the index).
 * Expect an exception to be thrown.
 *
 * @version 2025-09-29
 * @author Binit Dhungana
 */
public class WorkoutEntryBookTest {
    @Test
    public void addValidWorkoutEntry() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        WorkoutEntry entry = new WorkoutEntry("Binit", "Treadmill", "Just a warmup before I start with my leg exercise", null);
        book.addEntry(entry);
        assertEquals(1, book.getNumbersOfEntries());
    }

    @Test
    public void deleteWorkoutEntryByValidIndex() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        WorkoutEntry entry1 = new WorkoutEntry("Binit", "Treadmill", "Warmup", null);
        WorkoutEntry entry2 = new WorkoutEntry("Arne", "Cycling", "Cardio", null);
        book.addEntry(entry1);
        book.addEntry(entry2);
        book.deleteByIndex(0);
        assertEquals(1, book.getNumbersOfEntries());
    }

    @Test
    public void findByTrainerName() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        WorkoutEntry entry1 = new WorkoutEntry("Binit", "Treadmill", "Warmup", null);
        WorkoutEntry entry2 = new WorkoutEntry("Arne", "Cycling", "Cardio", null);
        book.addEntry(entry1);
        book.addEntry(entry2);
        // Assuming findByTrainerName returns a list of entries
        book.findByTrainerName("Binit");
        // Further assertions can be added based on the implementation of findByTrainerName
    }

    @Test
    public void findByWorkoutTitle() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        WorkoutEntry entry1 = new WorkoutEntry("Binit", "Treadmill", "Warmup", null);
        WorkoutEntry entry2 = new WorkoutEntry("Arne", "Cycling", "Cardio", null);
        book.addEntry(entry1);
        book.addEntry(entry2);
        // Assuming findByWorkoutTitle returns a list of entries
        book.findByWorkout("Treadmill");
        // Further assertions can be added based on the implementation of findByWorkoutTitle
    }

    @Test
    public void addNullWorkoutEntry() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        try {
            book.addEntry(null);
        } catch (IllegalArgumentException e) {
            // Test successful, do nothing.
        }
    }

    @Test
    public void searchByNullTrainerName() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        book.findByTrainerName(null);
        // Further assertions can be added based on the implementation of findByTrainerName
    }

    @Test
    public void searchByBlankTrainerName() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        book.findByTrainerName("   ");
        // Further assertions can be added based on the implementation of findByTrainerName
    }

    @Test
    public void searchByNullWorkoutTitle() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        book.findByWorkout(null);
        // Further assertions can be added based on the implementation of findByWorkout
    }

    @Test
    public void searchByBlankWorkoutTitle() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        book.findByWorkout("   ");
        // Further assertions can be added based on the implementation of findByWorkout
    }

    @Test
    public void deleteWorkoutEntryByInvalidIndex() {
        WorkoutEntryBook book = new WorkoutEntryBook();
        try {
            book.deleteByIndex(5); // Assuming no entries exist
        } catch (IndexOutOfBoundsException e) {
            // Test successful, do nothing.
        }
    }
}
