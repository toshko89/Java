package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    List<Fish> fishInPool;
    String name;
    int capacity;
    int size;

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {
        Fish sameName = this.fishInPool.stream()
                .filter(f -> f.getName().equals(fish.getName())).findFirst().orElse(null);
        if (sameName == null && this.fishInPool.size() < this.capacity) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        return this.fishInPool.removeIf(f -> f.getName().equals(name));
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Aquarium: ")
                .append(this.name)
                .append(" ^ Size: ")
                .append(this.size)
                .append(System.lineSeparator());
        for (Fish fish : this.fishInPool) {
            stringBuilder.append(fish.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
