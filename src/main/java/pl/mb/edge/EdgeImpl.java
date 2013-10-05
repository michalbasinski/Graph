package pl.mb.edge;

import pl.mb.vertex.Vertex;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public class EdgeImpl implements Edge {

    String label;
    Vertex origin;
    Vertex end;
    Float weight;

    public EdgeImpl() {
        this.weight = Float.POSITIVE_INFINITY;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Vertex getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

}
