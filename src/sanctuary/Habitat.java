package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public List<Elephant> getData() {
        return data;
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean remove(String name) {
        return this.data.removeIf(el -> el.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream().filter(el -> el.getRetiredFrom().equals(retiredFrom))
                .findFirst().orElse(null);
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant elephant : this.data) {
            stringBuilder.append(elephant.getName()).append(" came from: ")
                    .append(elephant.getRetiredFrom()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
