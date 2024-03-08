package sol;

import src.*;
import java.util.HashMap;
import java.util.LinkedList;


public class NodeEdgeGraph implements IGraph{
    public String name;
    public HashMap<String, Node> allNodes;

    // ---------------------------------------------
    // the Node class
    static class Node {
        String descr;  // a descriptive name for the node
        LinkedList<Node> nextNodes; // the nodes that this node can get to

        public Node(String descr) {
            this.descr = descr;
            this.nextNodes = new LinkedList<>();
        }

        private void addEdge(Node toNode) {
            this.nextNodes.add(toNode);
        }
    }
    public NodeEdgeGraph(String name) {
        this.name = name;
        this.allNodes = new HashMap<String, Node>();
    }

    /**
     * Method to retrieve the Node object for a name
     *
     * @param label the name of the node to find
     * @return the Node that has label as its description
     */
    public Node getNode(String label) {
        return this.allNodes.get(label);
    }

    /**
     * Method to add a new node with the given description. An exception will
     * be thrown if the description already names a node in the graph
     *
     * @param descr the text description or label to associate with the node
     * @throws NodeNameExistsException if that description is already
     * associated with a node in the graph
     */
    public void addNode(String descr) throws NodeNameExistsException {
        if (this.allNodes.containsKey(descr))
            throw new NodeNameExistsException(descr);
        addNodeUnchecked(descr);
    }

    /**
     * An internal method to add a node without checking whether it exists.
     * This is useful for internally avoiding the exception handling when
     * we already know the node doesn't exist.
     *
     * @param descr the text description or label to associate with the node
     * @return the (new) node associated with the given description
     */
    private Node addNodeUnchecked(String descr) {
        Node newNode = new Node(descr);
        this.allNodes.put(descr, newNode);
        return newNode;
    }

    /**
     * Method to add a directed edge between the nodes associated with the given
     * descriptions. If descr1 and descr2 are not already
     * valid node labels in the graph, those nodes are also created.
     * If the edge already exists, no changes are made
     * (and no exceptions or warnings are raised)
     *
     * @param descr1 the source node for the edge
     * @param descr2 the target node for the edge
     */
    public void addDirectedEdge(String descr1, String descr2) {
        Node node1 = this.allNodes.get(descr1);
        if (node1 == null) node1 = this.addNodeUnchecked(descr1);
        Node node2 = this.allNodes.get(descr2);
        if (node2 == null) node2 = this.addNodeUnchecked(descr2);
        if (!(node1.nextNodes.contains(node2))) {
            node1.addEdge(node2);
        }
    }

    /**
     * Method to add an undirected edge between the nodes associated with the given
     * descriptions. This is equivalent to adding two directed edges, one from
     * descr1 to descr2, and another from descr2 to descr1.
     * If descr1 and descr2 are not already valid node labels in the graph,
     * those nodes are also created.
     *
     * @param descr1 the source node for the edge
     * @param descr2 the target node for the edge
     */
    public void addUndirectedEdge(String descr1, String descr2) {
        this.addDirectedEdge(descr1, descr2);
        this.addDirectedEdge(descr2, descr1);
    }

    /**
     * Method to count how many nodes have edges to themselves
     *
     * @return the number of nodes that have edges to themselves
     */
    public int countSelfEdges() {
        return 0; // Implement this!
    }

    /**
     * Method to check whether a given node has edges to every other node (with or without an edge to itself).
     * Assumes that fromNodeLabel is a valid node label in the graph.
     *
     * @param fromNodeLabel the node to check
     * @return true if fromNodeLabel has an edge to every other node, otherwise false
     */
    public boolean reachesAllOthers(String fromNodeLabel) {
        return false; // Implement this!
    }
}
