package pl.mb.builders.impl;

import pl.mb.graph.GraphImpl;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public class GraphImplBuilder {
    private GraphImpl graph;

    public GraphImplBuilder() {
        graph = new GraphImpl();
    }

    public GraphImplBuilder withName(String name) {
        graph.setName(name);
        return this;
    }

    public GraphImpl build() {
        return graph;
    }
}
