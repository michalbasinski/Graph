package pl.mb.graph;

import org.junit.Before;
import org.junit.Test;
import pl.mb.builders.impl.EdgeImplBuilder;
import pl.mb.builders.impl.GraphImplBuilder;
import pl.mb.edge.Edge;
import pl.mb.exceptions.NoSuchVertexInGraph;
import pl.mb.vertex.Vertex;
import pl.mb.vertex.VertexImpl;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * Author: Michał Basiński
 * Date: 05.10.13
 * Time: 10:54
 * Created with IntelliJ IDEA.
 */
public class GraphTest {
    private Graph graph;
    private static final String VERTEX_TEST_VALUE = "TEST_VALUE";

    Vertex<String> testVertexOne;
    Vertex<String> testVertexTwo;
    Vertex<String> testVertexThree;

    Edge testEdgeOne;

    @Before
    public void setUp() throws NoSuchVertexInGraph {
        testVertexOne = new VertexImpl<String>();
        testVertexOne.setValue(VERTEX_TEST_VALUE);

        testVertexTwo = new VertexImpl<String>();
        testVertexTwo.setValue(VERTEX_TEST_VALUE);

        testVertexThree = new VertexImpl<String>();
        testVertexThree.setValue(VERTEX_TEST_VALUE);

        testEdgeOne = new EdgeImplBuilder().withOrigin(testVertexOne).withEnd(testVertexTwo).build();

        graph = new GraphImplBuilder().build();

        graph.addVertex(testVertexOne);
        graph.addVertex(testVertexTwo);
        graph.addVertex(testVertexThree);
        graph.addEdge(testEdgeOne);
    }

    @Test
    public void shouldFindAllAdjacentVerticesWithGivenVertex() {
        //given
        Set<Vertex> adjacentVertices = new HashSet<Vertex>();
        adjacentVertices.add(testVertexTwo);

        //when
        Set<Vertex> returnedVertices = graph.getAllVerticesAdjacentWithGivenVertex(testVertexOne);

        //then
        assertEquals(adjacentVertices, returnedVertices);
    }

    @Test
    public void shouldFindAllEdgesIncidentToGivenVertex() {
        //given
        Set<Edge> incidentEdges = new HashSet<Edge>();
        incidentEdges.add(testEdgeOne);

        //when
        Set<Edge> edgesIncidentWithVertexOne = graph.getAllEdgesIncidentWithGivenVertex(testVertexOne);
        Set<Edge> edgesIncidentWithVertexTwo = graph.getAllEdgesIncidentWithGivenVertex(testVertexTwo);

        //then
        assertEquals(incidentEdges, edgesIncidentWithVertexOne);
        assertEquals(incidentEdges, edgesIncidentWithVertexTwo);
    }

    @Test
    public void shouldThrowExceptionWhenEdgeContainsVertexNotIncludedInVerticesSet() {
        //given
        Vertex<String> testVertexFour = new VertexImpl<String>();
        testVertexFour.setValue(VERTEX_TEST_VALUE);

        Edge testEdgeTwo = new EdgeImplBuilder().withOrigin(testVertexThree).withEnd(testVertexFour).build();

        try {
            //when
            graph.addEdge(testEdgeTwo);
            fail("Exception was not thrown!");
        } catch (NoSuchVertexInGraph e) {
            //then
            System.out.println("TEST PASSED: Exception was thrown");
        }
    }

    @Test
    public void shouldCheckIfVertexHasCorrectValue(){
        //given
        Set<Vertex> vertices = graph.getVertices();
        Vertex<String> testVertex = null;

        //when
        for(Vertex vertex : vertices){
            if (vertex == testVertexOne){
                testVertex = vertex;
                break;
            }
        }

        //then
        assertEquals(testVertexOne.getValue(), testVertex.getValue());
    }

}
