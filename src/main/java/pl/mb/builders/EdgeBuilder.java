package pl.mb.builders;

import pl.mb.edge.Edge;
import pl.mb.vertex.Vertex;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Time: 10:19
 * Created with IntelliJ IDEA.
 */
public interface EdgeBuilder {
    Edge build();

    EdgeBuilder withWeight(Float weight);

    EdgeBuilder withLabel(String label);

    EdgeBuilder withOrigin(Vertex origin);

    EdgeBuilder withEnd(Vertex end);
}
