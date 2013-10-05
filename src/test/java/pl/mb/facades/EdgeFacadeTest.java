package pl.mb.facades;

import org.junit.Before;
import org.junit.Test;
import pl.mb.edge.Edge;
import pl.mb.edge.EdgeImpl;
import pl.mb.facades.impl.EdgeFacadeImpl;
import pl.mb.vertex.Vertex;
import pl.mb.vertex.VertexImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Time: 12:53
 * Created with IntelliJ IDEA.
 */
public class EdgeFacadeTest {

    private final static String VERTEX_TEST_VALUE = "TEST_VALUE";

    private EdgeFacade facade;
    private Edge edge;
    private Vertex<String> testVertexOne;
    private Vertex<String> testVertexTwo;

    @Before
    public void setUp(){
        testVertexOne = new VertexImpl<String>();
        testVertexOne.setValue(VERTEX_TEST_VALUE);

        testVertexTwo = new VertexImpl<String>();
        testVertexTwo.setValue(VERTEX_TEST_VALUE);

        edge = new EdgeImpl();
        edge.setOrigin(testVertexOne);
        edge.setEnd(testVertexTwo);
        facade = new EdgeFacadeImpl(edge);
    }

    @Test
    public void shouldReturnTrueWhenEdgeIsIncidentToGivenVertex(){
        //given

        //when
        boolean returnedValueOne = facade.isEdgeIncidentToVertex(testVertexOne);
        boolean returnedValueTwo = facade.isEdgeIncidentToVertex(testVertexTwo);

        //then
        assertTrue(returnedValueOne);
        assertTrue(returnedValueTwo);
    }

    @Test
    public void shouldReturnFalseWhenEdgeIsNotIncidentToGivenVertex(){
        //given
        Vertex<String> testVertex = new VertexImpl<String>();
        testVertex.setValue(VERTEX_TEST_VALUE);

        //when
        boolean returnedValue = facade.isEdgeIncidentToVertex(testVertex);

        //then
        assertFalse(returnedValue);
    }
}
