package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    List<Person> roster;
    String name;
    int capacity;

    public Hotel(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Person person) {
        if (this.roster.size() <= this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        return this.roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return this.roster.stream()
                .filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The people in the hotel ")
                .append(this.name).append(" are:").append(System.lineSeparator());

        for (Person person : this.roster) {
            stringBuilder.append(person).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
