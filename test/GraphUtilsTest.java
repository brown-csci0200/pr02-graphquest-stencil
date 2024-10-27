package test;

import org.junit.Assert;
import org.junit.Test;

import sol.EdgeArrayGraph;
import sol.GraphUtils;
import sol.IGraph;
import sol.NodeEdgeGraph;
import src.NoRouteException;
import src.NodeNameExistsException;

import java.util.LinkedList;

public class GraphUtilsTest {

    // Tip:  to save on typing, define node names as constants
    // to use throughout our tests
    // (the keyword "final" tells Java this variable won't ever change)
    private final String n1 = "node 1";
    private final String n2 = "node 2";
    private final String n3 = "node 3";
    private final String n4 = "node 4";
    // Feel free to add more!



    // Helper to create the graph n1 -> n2 -> n3
    // (Assumes graph is empty at start)
    private void makeSimpleGraph(IGraph g) throws NodeNameExistsException {
        // Creates the graph n1 -> n2 -> n3
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addDirectedEdge(n1, n2);
        g.addDirectedEdge(n2, n3);
    }

    // Demo: checking routes with hasRoute
    @Test
    public void testHasRoute()  {
        NodeEdgeGraph simpleGraph = new NodeEdgeGraph("a graph");
        makeSimpleGraph(simpleGraph);

        Assert.assertTrue(GraphUtils.hasRouteExample(simpleGraph, n1, n3));
        Assert.assertFalse(GraphUtils.hasRouteExample(simpleGraph, n3, n1));
    }

    //
    @Test
    public void testGetRouteSimple() throws NoRouteException {
        NodeEdgeGraph simpleGraph = new NodeEdgeGraph("a graph");
        makeSimpleGraph(simpleGraph);

        LinkedList<String> route = GraphUtils.getRoute(simpleGraph, n1, n3);

        // Expected path:  n1 -> n2 -> n3
        LinkedList<String> expectedRoute = new LinkedList<>();
        expectedRoute.add(n1);
        expectedRoute.add(n2);
        expectedRoute.add(n3);

        Assert.assertEquals(expectedRoute, route);
    }

    @Test
    public void testGetRouteSimpleNoRoute() throws NoRouteException {
        NodeEdgeGraph simpleGraph = new NodeEdgeGraph("a graph");
        makeSimpleGraph(simpleGraph);
        // Should be no route n3 -> n1
        Assert.assertThrows(NoRouteException.class,
                () -> GraphUtils.getRoute(simpleGraph, n3, n1));
    }

    @Test
    public void testGetRouteSimpleEdgeArray() throws NoRouteException {
        EdgeArrayGraph simpleGraph = new EdgeArrayGraph("a graph");
        makeSimpleGraph(simpleGraph);

        LinkedList<String> route = GraphUtils.getRoute(simpleGraph, n1, n3);

        LinkedList<String> expectedRoute = new LinkedList<>();
        expectedRoute.add(n1);
        expectedRoute.add(n2);
        expectedRoute.add(n3);

        Assert.assertEquals(expectedRoute, route);
    }




}
