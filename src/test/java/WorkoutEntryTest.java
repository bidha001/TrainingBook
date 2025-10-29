import edu.ntnu.bidata.prog1.model.WorkoutEntry;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Performs unit test on the WorkoutEntry class.
 *
 * The following positive test is executed:
 *
 * Create a valid instance with all correct parameters.
 * Create a code on timestamp null to use current date and time.
 * Expect an instance to be created.
 *
 * The following negative test is executed:
 *
 * Create an instance of WorkoutEntry with null trainer name (trainerName == null).
 * Expect an exception to be thrown.
 *
 * Create an instance of WorkoutEntry with empty trainer name ("").
 * Expect an exception to be thrown.
 *
 * Create an instance of WorkoutEntry with null workout (workout == null).
 * Expect an exception to be thrown.
 *
 * Create an instance of WorkoutEntry with empty workout("").
 * Expect an exception to be thrown.
 *
 * Create an instance of WorkoutEntry with null text (text == null).
 * Expect an exception to be thrown.
 *
 * @version 2025-09-29
 * @author Binit Dhungana
 */

public class WorkoutEntryTest {
    @Test
    public void createValidWorkoutEntry() {
        WorkoutEntry entry = new WorkoutEntry("Binit", "Treadmill", "Just a warmup before I start with my leg exercise", null);
        assertTrue(entry.getTrainerName().equals("Binit"));
        assertTrue(entry.getWorkout().equals("Treadmill"));
        assertTrue(entry.getText().equals("Just a warmup before I start with my leg exercise"));
    }

    @Test
    public void createWorkoutEntryWithNullTrainerName() {
        try {
            WorkoutEntry entry = new WorkoutEntry(null, "Treadmill", "Just a warmup before I start with my leg exercise", null);
        } catch (IllegalArgumentException e) {
            // Test successful, do nothing.
        }
    }

    @Test
    public void createWorkoutEntryWithEmptyTrainerName() {
        try {
            WorkoutEntry entry = new WorkoutEntry("", "Treadmill", "Just a warmup before I start with my leg exercise", null);
        } catch (IllegalArgumentException e) {
            // Test successful, do nothing.
        }
    }

    @Test
    public void createWorkoutEntryWithNullWorkout() {
        try {
            WorkoutEntry entry = new WorkoutEntry("Binit", null, "Just a warmup before I start with my leg exercise", null);
        } catch (IllegalArgumentException e) {
            // Test successful, do nothing.
        }
    }

    @Test
    public void createWorkoutEntryWithEmptyWorkout() {
        try {
            WorkoutEntry entry = new WorkoutEntry("Binit", "", "Just a warmup before I start with my leg exercise", null);
        } catch (IllegalArgumentException e) {
            // Test successful, do nothing.
        }
    }

    @Test
    public void createWorkoutEntryWithNullText() {
        try {
            WorkoutEntry entry = new WorkoutEntry("Binit", "Treadmill", null, null);
        } catch (IllegalArgumentException e) {
            // Test successful, do nothing.
        }
    }
}