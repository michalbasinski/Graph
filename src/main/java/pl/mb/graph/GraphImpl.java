package pl.mb.graph;

import pl.mb.edge.Edge;
import pl.mb.exceptions.NoSuchVertexInGraph;
import pl.mb.facades.EdgeFacade;
import pl.mb.facades.impl.EdgeFacadeImpl;
import pl.mb.vertex.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public class GraphImpl implements Graph {

    String name;
    Set<Vertex> vertices;
    Set<Edge> edges;

    public GraphImpl() {
        vertices = new HashSet<Vertex>();
        edges = new HashSet<Edge>();
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    @Override
    public boolean isVertexInGraph(Vertex vertex) {
        return vertices.contains(vertex);
    }

    @Override
    public void addEdge(Edge edge) throws NoSuchVertexInGraph {
        if (vertices.contains(edge.getOrigin()) && vertices.contains(edge.getEnd())) {
            edges.add(edge);
        } else {
            throw new NoSuchVertexInGraph();
        }
    }

    @Override
    public void removeVertex(Vertex vertex) {
        vertices.remove(vertex);
        for (Edge edge : edges) {
            EdgeFacade edgeFacade = createEdgeFacade(edge);
            if (edgeFacade.isEdgeIncidentToVertex(vertex)) {
                edges.remove(edge);
            }
        }
    }

    @Override
    public Set<Edge> getAllEdgesIncidentWithGivenVertex(Vertex vertex) {
        Set<Edge> incidentEdges = new HashSet<Edge>();

        for (Edge edge : edges) {
            EdgeFacade edgeFacade = createEdgeFacade(edge);
            if (edgeFacade.isEdgeIncidentToVertex(vertex)) {
                incidentEdges.add(edge);
            }
        }
        return incidentEdges;
    }

    @Override
    public Set<Vertex> getAllVerticesAdjacentWithGivenVertex(Vertex vertex) {
        Set<Vertex> adjacentVertices = new HashSet<Vertex>();
        for (Edge edge : edges) {
            if (vertex == edge.getOrigin()) {
                adjacentVertices.add(edge.getEnd());
            }
        }
        return adjacentVertices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(Set<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }

    private EdgeFacade createEdgeFacade(Edge edge) {
        return new EdgeFacadeImpl(edge);
    }
}
