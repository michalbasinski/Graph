package pl.mb.edge;

import pl.mb.vertex.Vertex;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public interface Edge {
    Vertex getOrigin();

    void setOrigin(Vertex origin);

    Vertex getEnd();

    void setEnd(Vertex end);

    Float getWeight();

    void setWeight(Float weight);

    String getLabel();

    void setLabel(String label);
}
