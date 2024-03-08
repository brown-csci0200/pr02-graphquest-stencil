package test;

import org.junit.Assert;
import org.junit.Test;

import sol.GraphUtils;
import sol.IGraph;
import sol.NodeEdgeGraph;
import src.NoRouteException;
import src.NodeNameExistsException;

import java.util.LinkedList;

public class GraphUtilsTest {
    // Assumes that graph will be empty, modifies it in-place
    private void addSimpleGraphNodes(IGraph graph) throws NodeNameExistsException {
        graph.addNode("node 1");
        graph.addNode("node 2");
        graph.addNode("node 3");
        graph.addNode("node 4");
    }

    // Assumes that graph will have nodes from `addSimpleGraphNodes`,
    //     modifies it in-place
    private void addSimpleGraphEdges(IGraph graph) {
        graph.addDirectedEdge("node 1", "node 2");
        graph.addDirectedEdge("node 2", "node 3");
    }

    // Assumes that graph will be empty, modifies it in-place
    private void makeSimpleGraph(IGraph graph) throws NodeNameExistsException {
        addSimpleGraphNodes(graph);
        addSimpleGraphEdges(graph);
    }

    @Test
    public void testGetRouteSimple(){
        try {
            NodeEdgeGraph simpleGraph = new NodeEdgeGraph("a graph");
            makeSimpleGraph(simpleGraph);

            String fromNode = "node 1";
            String toNode = "node 3";
            LinkedList<String> route = GraphUtils.getRoute(simpleGraph, fromNode, toNode);

            LinkedList<String> expectedRoute = new LinkedList<>();
            expectedRoute.add("node 1");
            expectedRoute.add("node 2");
            expectedRoute.add("node 3");

            Assert.assertEquals(expectedRoute, route);
        }
        catch (NodeNameExistsException e) {
            // fail() automatically stops and fails the current test with an error message
            Assert.fail("Could not create graph to test");
        } catch (NoRouteException e) {
            Assert.fail("getRoute did not find a route");
        }
    }

    @Test
    public void testGetRouteSimpleNoRoute(){
        try {
            NodeEdgeGraph simpleGraph = new NodeEdgeGraph("a graph");
            makeSimpleGraph(simpleGraph);
            String fromNode = "node 1";
            String toNode = "node 4";
            Assert.assertThrows(
                    NoRouteException.class,
                    () -> GraphUtils.getRoute(simpleGraph, fromNode, toNode));
        }
        catch (NodeNameExistsException e) {
            Assert.fail("Could not create graph to test");
        }
    }

    @Test
    public void testCountSelfEdgesSimple() {
        try {
            IGraph basicGraph = new NodeEdgeGraph("a graph");
            basicGraph.addNode("node 1");
            basicGraph.addDirectedEdge("node 1", "node 1");
            Assert.assertEquals(1, basicGraph.countSelfEdges());
        } catch (NodeNameExistsException e) {
            Assert.fail("Could not create graph to test");
        }
    }

    @Test
    public void testReachesAllOthersSimple(){
        IGraph basicGraph = new NodeEdgeGraph("b graph");
        basicGraph.addUndirectedEdge("node 1", "node 2");
        Assert.assertTrue(basicGraph.reachesAllOthers("node 1"));
        Assert.assertTrue(basicGraph.reachesAllOthers("node 2"));
    }
}
