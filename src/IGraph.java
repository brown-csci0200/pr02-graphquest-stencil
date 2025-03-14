package src;

import java.util.List;
import java.util.Set;

/**
 * Interface for Graphs of different formats
 *
 * YOU SHOULD NOT MODIFY THIS FILE.
 */
public interface IGraph {
    void addNode(String label);
    void addDirectedEdge(String label1, String label2);
    void addUndirectedEdge(String label1, String label2);

    Set<String> getNeighbors(String nodeLabel);
    Set<String> getAllNodes();
}
