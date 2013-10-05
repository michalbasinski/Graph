package pl.mb.facades.impl;

import pl.mb.edge.Edge;
import pl.mb.facades.EdgeFacade;
import pl.mb.vertex.Vertex;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public class EdgeFacadeImpl implements EdgeFacade {
    private Edge edge;

    public EdgeFacadeImpl(Edge edge) {
        this.edge = edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public Edge getEdge() {
        return edge;
    }

    @Override
    public boolean isEdgeIncidentToVertex(Vertex vertex) {
        return (vertex == edge.getOrigin() || vertex == edge.getEnd());
    }
}
