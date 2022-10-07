package Generics.GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Swap<T> {
    List<T> data = new ArrayList<>();

    public static <T> void swap(List<T> data, int index1, int index2) {
        Collections.swap(data, index1, index2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T datum : data) {
            sb.append(String.format("%s: %s", datum.getClass().getName(), datum)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
