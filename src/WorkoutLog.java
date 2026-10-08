import java.util.ArrayList;

public class WorkoutLog {
    private ArrayList<Workout> workouts;

    public WorkoutLog() {
        workouts = new ArrayList<Workout>();
    }

    public void addWorkout(Workout w) {
        workouts.add(w);
    }

    public double getTotalVolume() {
        double volume = 0;

        for (Workout w: workouts) {
            volume += w.getReps() * w.getWeight() * w.getSets();
        }

        return volume;
    }
}
