package Generics.CustomList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter<T> {

    public static <T extends Comparable<T>> List<T> sort(MyList<T> list) {
        List<T> sorted = list.data.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return list.data = sorted;
    }
}
