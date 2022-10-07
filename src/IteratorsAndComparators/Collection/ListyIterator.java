package IteratorsAndComparators.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    public List<String> list;
    public int index;

    public ListyIterator() {
        this.list = new ArrayList<>();
        this.index = 0;
    }

    public boolean move() {
        if (this.index < this.list.size()) {
            this.index++;
            return true;
        }
        return false;
    }

    public void create(String... elements) {
        if (elements.length > 0) {
            for (String element : elements) {
                this.list.add(element);
            }
        }
    }

    public void print() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.list.get(this.index));
    }

    public void printAll() {
        for (String s : this.list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            public int i = 0;

            @Override
            public boolean hasNext() {
                return this.i > list.size();
            }

            @Override
            public String next() {
                return list.get(i++);
            }
        };
    }
}

