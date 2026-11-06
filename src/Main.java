import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        WorkoutLog log = new WorkoutLog();
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1. Add workout");
            System.out.println("2. View all workouts");
            System.out.println("3. Total volume");
            System.out.println("4. Search by exercise");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            String option = input.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.print("Exercise name: ");
                    String exercise = input.nextLine();
                    int sets = readInt(input, "How many sets: ");
                    int reps = readInt(input, "How many reps: ");
                    double weight = readDouble(input, "How much weight (lb): ");

                    log.addWorkout(new Workout(exercise, sets, reps, weight, LocalDate.now()));
                    System.out.println("Workout added.");
                }
                case "2" -> System.out.println(log);
                case "3" -> System.out.println("Total volume: " + log.getTotalVolume() + " lb");
                case "4" -> {
                    System.out.print("Exercise to search for: ");
                    String exerciseWanted = input.nextLine();
                    ArrayList<Workout> results = log.getWorkoutsByExercise(exerciseWanted);

                    if (results.isEmpty()) {
                        System.out.println("No workouts found for " + exerciseWanted);
                    } else {
                        for (Workout w : results) {
                            System.out.println(w);
                        }
                    }
                }
                case "5" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Enter 1-5.");
            }
        }

        input.close();
    }

    // Keeps asking until the user types a valid whole number
    private static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    // Same as readInt, but allows decimals like 22.5
    private static double readDouble(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}