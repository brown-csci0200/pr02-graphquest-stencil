package test;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashSet;

import sol.IGraph;
import sol.NodeEdgeGraph;
import sol.Scheduler;
import src.NoScheduleException;
import src.NodeNameExistsException;

/**
 * This class contains *examples* for using the Scheduler
 * You SHOULD NOT try to make these tests pass, since you won't
 * be implementing the Scheduler yet!
 * (Instead, you'll do this in the next assignment, in Python!)
 */
public class SchedulerExamples {
    private final String n1 = "lab 1";
    private final String n2 = "lab 2";
    private final String n3 = "lab 3";
    private final String n4 = "lab 4";

    // Build a simple graph "lab 1" <-> "lab 2" <-> "lab 3"
    private IGraph makeSimpleGraph() {
        IGraph g = new NodeEdgeGraph("a graph");
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addUndirectedEdge(n1, n2); // adds n1 -> n2, n2 -> n1
        g.addUndirectedEdge(n2, n3); // adds n2 -> n3, n3 -> n2
        return g;
    }

    @Test
    public void testCheckValidityTrue() {
        IGraph simpleGraph = makeSimpleGraph();

        ArrayList<HashSet<String>> proposedSchedule = new ArrayList<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add(n1);
        set1.add(n3);
        set1.add(n4);
        proposedSchedule.add(set1);
        HashSet<String> set2 = new HashSet<>();
        set2.add(n2);
        proposedSchedule.add(set2);

        Assert.assertTrue(Scheduler.checkValidity(simpleGraph, proposedSchedule));
    }

    @Test
    public void testCheckValidityFalse() {
        IGraph simpleGraph = makeSimpleGraph();

        ArrayList<HashSet<String>> proposedSchedule = new ArrayList<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add(n3);
        set1.add(n4);
        proposedSchedule.add(set1);
        HashSet<String> set2 = new HashSet<>();
        set2.add(n1);
        set2.add(n2);
        proposedSchedule.add(set2);

        Assert.assertFalse(Scheduler.checkValidity(simpleGraph, proposedSchedule));
    }

    @Test
    public void testFindScheduleValid() throws NoScheduleException {
        IGraph simpleGraph = makeSimpleGraph();
        ArrayList<HashSet<String>> schedule = Scheduler.findSchedule(simpleGraph);
        Assert.assertTrue(Scheduler.checkValidity(simpleGraph, schedule));
    }

    @Test
    public void testFindScheduleInvalid() {
        IGraph simpleGraph = makeSimpleGraph();
        simpleGraph.addUndirectedEdge(n3, n1); // This edge should make it impossible to schedule
        Assert.assertThrows(
                NoScheduleException.class,
                () -> Scheduler.findSchedule(simpleGraph));
    }
}
