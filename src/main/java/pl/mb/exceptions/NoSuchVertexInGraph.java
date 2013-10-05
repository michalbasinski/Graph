package pl.mb.exceptions;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Time: 10:11
 * Created with IntelliJ IDEA.
 */
public class NoSuchVertexInGraph extends Exception {
    public NoSuchVertexInGraph() {
        super();
    }

    public NoSuchVertexInGraph(String message) {
        super(message);
    }
}
