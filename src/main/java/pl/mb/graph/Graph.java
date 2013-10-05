package pl.mb.graph;

import pl.mb.edge.Edge;
import pl.mb.exceptions.NoSuchVertexInGraph;
import pl.mb.vertex.Vertex;

import java.util.Set;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public interface Graph {
    void addVertex(Vertex vertex);

    Set<Vertex> getVertices();

    void addEdge(Edge edge) throws NoSuchVertexInGraph;

    Set<Edge> getEdges();

    Set<Edge> getAllEdgesIncidentWithGivenVertex(Vertex vertex);

    Set<Vertex> getAllVerticesAdjacentWithGivenVertex(Vertex vertex);

    void removeVertex(Vertex vertex);

    boolean isVertexInGraph(Vertex vertex);

}
