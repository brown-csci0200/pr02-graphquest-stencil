package test;

import org.junit.Assert;
import org.junit.Test;

import sol.GraphUtils;
import src.IGraph;
import src.NodeEdgeGraph;
import src.NoRouteException;

import java.util.LinkedList;
import java.util.Set;

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
    private void makeSimpleGraph(IGraph g) {
        // Creates the graph n1 -> n2 -> n3
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addDirectedEdge(n1, n2);
        g.addDirectedEdge(n2, n3);
    }

    // -------------------- TESTS FOR PART 1 ------------------------------------

    // Demo: getting neighbors on a graph
    @Test
    public void testGetNeighborsExample() {
        NodeEdgeGraph g = new NodeEdgeGraph("a graph");
        g.addDirectedEdge("a", "b");
        g.addDirectedEdge("a", "c");

        Set<String> aNeighbors = g.getNeighbors("a");
        Assert.assertTrue(aNeighbors.contains("b"));
        Assert.assertFalse(aNeighbors.contains("d"));
    }


    // -------------------- TESTS FOR PART 2 ------------------------------------

    // Demo: checking routes with hasRoute
    @Test
    public void testHasRouteExample()  {
        NodeEdgeGraph simpleGraph = new NodeEdgeGraph("a graph");
        makeSimpleGraph(simpleGraph);

        Assert.assertTrue(GraphUtils.hasRouteExample(simpleGraph, n1, n3));
        Assert.assertFalse(GraphUtils.hasRouteExample(simpleGraph, n3, n1));
    }

    @Test
    public void testGetRouteSimpleExample() throws NoRouteException {
        NodeEdgeGraph simpleGraph = new NodeEdgeGraph("a graph");
        makeSimpleGraph(simpleGraph);

        LinkedList<String> route = GraphUtils.getRoute(simpleGraph, n1, n3);

        // Expected path:  n1 -> n2 -> n3
        LinkedList<String> expectedRoute = new LinkedList<>();
        expectedRoute.add(n1);
        expectedRoute.add(n2);
        expectedRoute.add(n3);

        // Shorthand:  this line is equivalent to the previous three add()'s!
        // expectedRoute.addAll(List.of(new String[]{n1, n2, n3}));

        Assert.assertEquals(expectedRoute, route);
    }

    // Here's an example test for when a route is not found, which throws a NoRouteException
    @Test
    public void testGetRouteSimpleNoRouteExample() throws NoRouteException {
        NodeEdgeGraph simpleGraph = new NodeEdgeGraph("a graph");
        makeSimpleGraph(simpleGraph);
        // Should be no route n3 -> n1
        Assert.assertThrows(NoRouteException.class,
                () -> GraphUtils.getRoute(simpleGraph, n3, n1));
    }

}
