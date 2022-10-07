package Generics.GenericBoxOfInteger;

public class GenericBox<T> {
    T entry;

    public GenericBox(T entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", entry.getClass().getName(), entry);
    }
}
