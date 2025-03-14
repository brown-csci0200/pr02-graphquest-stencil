package sol;

import src.IGraph;
import src.NoRouteException;

import java.util.HashSet;
import java.util.LinkedList;

public class GraphUtils {

    public GraphUtils() {}

    /**
     * Method to use breadth-first-search (BFS) to check whether there is a path
     *     from one node to another in a graph. Assumes that both fromNodeLabel
     *     and toNodeLabel are valid node labels in graph.
     *
     * NOTE:  This is method is provided FOR EXAMPLE PURPOSES ONLY.
     * You should not need to use it in your implementation, but you may
     * find it a good reference to copy and modify as you write
     * other methods (like getRoute).
     *
     * @param graph the graph to traverse
     * @param fromNodeLabel name of the node from which to start searching
     * @param toNodeLabel   name of the node we want to reach
     * @return boolean indicating whether such a route exists
     */
    public static boolean hasRouteExample(IGraph graph, String fromNodeLabel, String toNodeLabel) {
        // set up and initialize data structures
        HashSet<String> visited = new HashSet<>();
        LinkedList<String> toCheck = new LinkedList<>();
        toCheck.add(fromNodeLabel);

        // process nodes to search for toNode
        while (!toCheck.isEmpty()) {
            String checkNodeLabel = toCheck.pop();
            if (checkNodeLabel.equals(toNodeLabel)) {
                return true;
            } else if (!visited.contains(checkNodeLabel)) {
                visited.add(checkNodeLabel);
                for (String n : graph.getNeighbors(checkNodeLabel)) {
                    toCheck.add(n);
                }
            }
        }
        return false;
    }

    /**
     * Method to produce a sequence of nodes that constitutes a shortest path
     *     from fromNodeLabel to toNodeLabel. Assumes that both fromNodeLabel
     *     and toNodeLabel are valid node labels in theGraph.
     * Throws a NoRouteException if no such path exists
     *
     * @param theGraph the graph to traverse
     * @param fromNodeLabel the node from which to start searching
     * @param toNodeLabel   the node we want to reach
     * @return List of nodes in order of the path
     * @throws NoRouteException if no such path exists
     */
    public static LinkedList<String> getRoute(IGraph theGraph, String fromNodeLabel, String toNodeLabel)
            throws NoRouteException {
        // TODO:  Fill in!
        return null;
    }
}