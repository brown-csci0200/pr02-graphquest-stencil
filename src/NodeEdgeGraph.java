package src;

import java.util.*;

/**
 * Node-based representation for a graph
 * YOU SHOULD NOT NEED TO MODIFY THIS FILE, though you MAY do so
 * if you want to add any extra methods for part 2B (not required).
 */
public class NodeEdgeGraph implements IGraph {
    public String name;                      // Name of this graph (useful for testing)
    public HashMap<String, Node> allNodes;  // Map of label -> node object

    // ---------------------------------------------
    // the Node class
    static class Node {
        String label;  // a descriptive name for the node
        LinkedList<Node> nextNodes; // the nodes that this node can get to

        public Node(String label) {
            this.label = label;
            this.nextNodes = new LinkedList<>();
        }

        private void addEdge(Node toNode) {
            this.nextNodes.add(toNode);
        }
    }
    public NodeEdgeGraph(String graphName) {
        this.name = graphName;
        this.allNodes = new HashMap<String, Node>();
    }

    /**
     * Method to retrieve the Node object for a name
     *
     * @param label the name of the node to find
     * @return the Node that has label
     */
    public Node getNode(String label) {
        return this.allNodes.get(label);
    }

    /**
     * Method to add a new node with the given description. An exception will
     * be thrown if the description already names a node in the graph
     *
     * @param label the text description or label to associate with the node
     * @throws NodeNameExistsException if that description is already
     * associated with a node in the graph
     */
    public void addNode(String label) throws NodeNameExistsException {
        if (this.allNodes.containsKey(label)) {
            throw new NodeNameExistsException(label);
        }
        this.makeNewNode(label);
    }

    /**
     * Helper method to add a new node
     *
     * @param label the text description or label to associate with the node
     * @return the (new) node associated with the given description
     */
    private Node makeNewNode(String label) {
        Node newNode = new Node(label);
        this.allNodes.put(label, newNode);
        return newNode;
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
        Node node1 = this.allNodes.get(label1);
        if (node1 == null) { // If this node doesn't exist, create it
            node1 = this.makeNewNode(label1);
        }
        Node node2 = this.allNodes.get(label2);
        if (node2 == null) { // If this node doesn't exist, create it
            node2 = this.makeNewNode(label2);
        }

        // Add an edge between the nodes
        if (!(node1.nextNodes.contains(node2))) {
            node1.addEdge(node2);
        }
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
        this.addDirectedEdge(label1, label2);
        this.addDirectedEdge(label2, label1);
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
        Set<String> neighbors = new HashSet<String>();
        Node theNode = this.getNode(nodeLabel);
        if (theNode == null) {
            throw new IllegalArgumentException("Node " + nodeLabel + " does not exist");
        }

        for (Node n : theNode.nextNodes) {
            neighbors.add(n.label);
        }

        return neighbors;
    }

    /**
     * Get a list of all node names
     *
     * @return return the list of all node labels in the graph
     */
    public Set<String> getAllNodes() {
        Set<String> result = new HashSet<>();
        for (String key : this.allNodes.keySet()) {
            result.add(key);
        }
        return result;
    }
}
