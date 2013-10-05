package pl.mb.vertex;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public class VertexImpl<T> implements Vertex<T> {
    T value;

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }
}
