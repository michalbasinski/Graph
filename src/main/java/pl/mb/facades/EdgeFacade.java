package pl.mb.facades;

import pl.mb.edge.Edge;
import pl.mb.vertex.Vertex;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Created with IntelliJ IDEA.
 */

public interface EdgeFacade {
    void setEdge(Edge edge);

    Edge getEdge();

    boolean isEdgeIncidentToVertex(Vertex vertex);
}
