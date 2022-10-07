package Generics.GenericBox;

public class Box<T> {

    T entry;

    public Box(T entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", entry.getClass().getName(), entry);
    }
}
