import java.time.LocalDate;

public class Workout {
    private int sets;
    private int reps;
    private double weight;
    private String exercise;
    private LocalDate date;

    public Workout(String exercise, int sets, int reps, double weight, LocalDate date) {
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.exercise = exercise;
        this.date = date;
    }

    //getters

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }

    public String getExercise() {
        return exercise;
    }

    public LocalDate getDate() {
        return date;
    }
}
