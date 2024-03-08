package sol;

import src.NodeNameExistsException;

public interface IGraph {
    void addNode(String descr) throws NodeNameExistsException;
    void addDirectedEdge(String descr1, String descr2);
    void addUndirectedEdge (String descr1, String descr2);
    int countSelfEdges();
    boolean reachesAllOthers(String fromNodeLabel);

    // Add additional functions below here for GraphUtils
}
