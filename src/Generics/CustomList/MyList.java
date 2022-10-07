package Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyList<T extends Comparable<T>> {

    public List<T> data = new ArrayList<>();


    public void add(T element){
        this.data.add(element);
    }

    public void remove(int index){
        this.data.remove(index);
    }

    public boolean contains(T element){
        return this.data.contains(element);
    }

    public void swap(int index1, int index2){
        Collections.swap(this.data,index1,index2);
    }

    public int countGreaterThan(T element){
        int count = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax(){
      return  this.data.stream().max(Comparator.naturalOrder()).orElse(null);
    }

    public T getMin(){
        return  this.data.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public void print(){
        for (T datum : this.data) {
            System.out.println(datum);
        }
    }


}
