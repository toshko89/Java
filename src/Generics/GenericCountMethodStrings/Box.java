package Generics.GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    public List<T> values = new ArrayList<>();

    public Box(T value) {
        this.values.add(value);
    }

    public Box() {
    }

    public int searchElements(List<T> values, T search) {
        int count = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).compareTo(search) > 0) {
                count++;
            }
        }
        return count;
    }

}

