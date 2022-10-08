package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExerciseCount(int exerciseCount) {
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise current = this.exercises.stream()
                .filter((exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)))
                .findFirst().orElse(null);
        if (current != null) {
            this.exercises.removeIf((exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)));
            return true;
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream()
                .filter((exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)))
                .findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream()
                .max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Workout type: ").append(this.type).append(System.getProperty("line.separator"));
        for (Exercise exe : this.exercises) {
            stringBuilder.append("Exercise: ").append(exe).append(System.getProperty("line.separator"));
        }

        return stringBuilder.toString();
    }
}
