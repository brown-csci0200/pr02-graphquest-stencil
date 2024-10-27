package sol;

import src.NodeNameExistsException;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Interface for Graphs of different formats
 *
 * YOU SHOULD NOT NEED TO MODIFY THIS FILE.
 * If you do, you MUST NOT change any of the methods listed here,
 * which will break the autograder.  You MAY add new methods, if you want.
 */
public interface IGraph {
    void addNode(String label);
    void addDirectedEdge(String label1, String label2);
    void addUndirectedEdge (String label1, String label2);

    List<String> getNeighbors(String nodeLabel);
    List<String> getNodes();
}
