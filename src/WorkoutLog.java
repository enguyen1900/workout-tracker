import java.util.ArrayList;

public class WorkoutLog {
    private ArrayList<Workout> workouts;

    public WorkoutLog() {
        workouts = new ArrayList<>();
    }

    public void addWorkout(Workout w) {
        workouts.add(w);
    }

    public double getTotalVolume() {
        double volume = 0;

        for (Workout w : workouts) {
            volume += w.getSets() * w.getReps() * w.getWeight();
        }

        return volume;
    }

    public ArrayList<Workout> getWorkoutsByExercise(String exercise) {
        ArrayList<Workout> matches = new ArrayList<>();

        for (Workout w : workouts) {
            if (w.getExercise().equalsIgnoreCase(exercise)) {
                matches.add(w);
            }
        }

        return matches;
    }

    @Override
    public String toString() {
        if (workouts.isEmpty()) {
            return "No workouts logged";
        }

        String message = "";
        for (Workout w : workouts) {
            message += w + "\n";
        }
        return message;
    }
}