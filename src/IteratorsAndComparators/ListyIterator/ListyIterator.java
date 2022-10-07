package IteratorsAndComparators.ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterator<T> {
    public List<T> list;
    public int index;

    public ListyIterator() {
        this.list = new ArrayList<>();
        this.index = 0;
    }

    public void create(T... elements) {
        if (elements.length > 0) {
            for (T element : elements) {
                this.list.add(element);
            }
        }
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.list.get(this.index));
    }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }

    @Override
    public T next() {
        return this.list.get(index);
    }
}

//    List<T> records;
//    private int index = 0;
//
//    public void create(T... record) {
//        records = new ArrayList<>();
//        if (record.length > 0) {
//            for (T t : record) {
//                records.add(t);
//            }
//        }
//    }
//
//    public boolean move() {
//        index++;
////        if (hasNext()) {
////            Collections.swap(this.records, i, i + 1);
////            return true;
////        }
//        return true;
//    }
//
//    public void print() {
//        System.out.println(records.get(index));
//    }
//
//    @Override
//    public boolean hasNext() {
//        return this.records.listIterator().hasNext();
//    }
//
//    @Override
//    public T next() {
//        return this.records.get(index);
//    }
