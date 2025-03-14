package sol;

import src.IGraph;
import src.NodeNameExistsException;

import java.util.ArrayList;
import java.util.Set;

public class EdgeArrayGraph implements IGraph {
    String name;  // Name of the graph
    ArrayList<ArrayList<Boolean>> edgeArray; // Adjacency matrix (see handout)
    // TODO:  Add other fields...


    public EdgeArrayGraph(String graphName) {
        this.name = graphName;
        this.edgeArray = new ArrayList<ArrayList<Boolean>>();
        // TODO:  Set up other fields...
    }

    /**
     * Method to add a new node with the given description. An exception will
     * be thrown if the description already names a node in the graph
     *
     * @param label the label to associate with the node
     * @throws NodeNameExistsException if that description is already
     * associated with a node in the graph
     */
    public void addNode(String label)  {
        // TODO: Implement this!
    }

    /**
     * Method to add a directed edge between the nodes associated with the given
     * descriptions. If label1 and label2 are not already
     * valid node labels in the graph, those nodes are also created.
     * If the edge already exists, no changes are made
     * (and no exceptions or warnings are raised)
     *
     * @param label1 the source node for the edge
     * @param label2 the target node for the edge
     */
    public void addDirectedEdge(String label1, String label2) {
        // TODO: Implement this!
    }

    /**
     * Method to add an undirected edge between the nodes associated with the given
     * descriptions. This is equivalent to adding two directed edges, one from
     * label1 to label2, and another from label2 to label1.
     * If label1 and label2 are not already valid node labels in the graph,
     * those nodes are also created.
     *
     * @param label1 the source node for the edge
     * @param label2 the target node for the edge
     */
    public void addUndirectedEdge(String label1, String label2) {
        // TODO: Implement this!
    }

    /**
     * Method to return a LinkedList of the descriptors of the nodes
     * that can be reached on a direct edge from this node.
     * Assumes that nodeLabel is a valid node label in the graph.
     *
     * @param nodeLabel the description for the source node
     * @return LinkedList of descriptions for nodes to which nodeLabel has an edge
     */
    public Set<String> getNeighbors(String nodeLabel) {
        // TODO: Implement this!
        return null;
    }

    /**
     * Get a list of all node names
     *
     * @return return the list of all node labels in the graph
     */
    public Set<String> getAllNodes() {
        // TODO: Implement this!
        return null;
    }

}
