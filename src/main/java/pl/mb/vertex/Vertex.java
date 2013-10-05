package pl.mb.vertex;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public interface Vertex<T> {

    void setValue(T value);

    T getValue();
}
