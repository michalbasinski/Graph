package pl.mb.builders.impl;

import pl.mb.builders.EdgeBuilder;
import pl.mb.edge.Edge;
import pl.mb.edge.EdgeImpl;
import pl.mb.vertex.Vertex;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Time: 10:20
 * Created with IntelliJ IDEA.
 */
public class EdgeImplBuilder implements EdgeBuilder {
    private Edge edge;

    public EdgeImplBuilder() {
        edge = new EdgeImpl();
    }

    @Override
    public Edge build() {
        return edge;
    }

    @Override
    public EdgeBuilder withWeight(Float weight) {
        edge.setWeight(weight);
        return this;
    }

    @Override
    public EdgeBuilder withLabel(String label) {
        edge.setLabel(label);
        return this;
    }

    @Override
    public EdgeBuilder withOrigin(Vertex origin) {
        edge.setOrigin(origin);
        return this;
    }

    @Override
    public EdgeBuilder withEnd(Vertex end) {
        edge.setEnd(end);
        return this;
    }
}
