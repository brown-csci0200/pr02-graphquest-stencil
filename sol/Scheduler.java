package sol;

import java.util.*;

import src.NoScheduleException;

public class Scheduler {

    public Scheduler() {}

    /**
     * Method which checks if a given allocation of labs adheres to
     *     the scheduling constraints of the graph. Assumes that
     *     all lab names in proposedAlloc are valid labels in theGraph.
     *
     * @param theGraph the graph to try to schedule
     * @param proposedAlloc the proposed allocation of labs between Kathi and Elijah
     * @return boolean indicating whether the proposed allocation is valid
     */
    public static boolean checkValidity(IGraph theGraph, ArrayList<HashSet<String>> proposedAlloc) {
        // NON-TODO:  You'll implement this method in HW4 (in Python), so don't implement it now!
        // For now, we just want you to plan how you *would* implement it given a graph that implements IGraph.
        return false;
    }

    /**
     * Method to compute a valid split of the graph nodes
     *     without violating scheduling constraints,
     *     if such a split exists
     * Throws a NoScheduleException if no such split exists
     *
     * @param theGraph the graph to try to schedule
     * @return an ArrayList of HashSets of node labels that constitute a
     *         valid split of the graph
     * @throws NoScheduleException if no such split exists
     */
    public static ArrayList<HashSet<String>> findSchedule(IGraph theGraph)
            throws NoScheduleException {
        // NON-TODO:  You'll implement this method in HW4 (in Python), so don't implement it now!
        // For now, we just want you to plan how you *would* implement it given a graph that implements IGraph.
        return null;
    }
}
