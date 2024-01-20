package lib.util;

public class ItemBoxer<T> {
    T value;

    public ItemBoxer(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ItemBoxer(" + this.getValue() + ")";
    }
}
