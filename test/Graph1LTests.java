import GraphImp.Graph1L;
import GraphInterface.Graph;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Sample JUnit test fixture for SequenceSmooth.
 *
 * @author Farid Kamizi
 *
 */
public final class Graph1LTests {
    private static Map<Integer, Set<Integer>> g = new HashMap<>();

    /**
     * Constructs and returns a sequence of the integers provided as arguments.
     *
     * @param args
     *            0 or more integer arguments
     * @return the sequence of the given arguments
     * @ensures createFromArgs= [the sequence of integers in args]
     */
    private Graph<Integer> createVerticesFromArgs(Integer... args) {
        Graph<Integer> g = new Graph1L<Integer>();
        for (Integer x : args) {
            assert !g.contains(
                    x) : "Violation of: every entry in args is unique";
            g.add(x);
        }
        return g;
    }

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Map<Integer, Set<Integer>> createFromArgsTest(Integer... args) {
        g.clear();
        for (Integer x : args) {
            assert !g.containsKey(
                    x) : "Violation of: every entry in args is unique";
            g.put(x, new HashSet<Integer>());
        }
        return g;
    }

    /**
     *
     * @param vertexOne
     * @param vertexTwo
     */
    private void connectVertices(Integer vertexOne, Integer vertexTwo) {
        assert (g
                .containsKey(vertexOne)) : "Violation of: vertexOne is in this";
        assert (g
                .containsKey(vertexTwo)) : "Violation of: vertexTwo is in this";

        for (Entry<Integer, Set<Integer>> mapEntry : g.entrySet()) {

            Set<Integer> degreeSet = new HashSet<>(mapEntry.getValue());

            if (mapEntry.getKey().equals(vertexOne)) {
                degreeSet.add(vertexTwo);
                mapEntry.setValue(degreeSet);
            } else if (mapEntry.getKey().equals(vertexTwo)) {
                degreeSet.add(vertexOne);
                mapEntry.setValue(degreeSet);
            }

        }

    }

    /**
     *
     */
    @Test
    public void testAddEmpty() {
        /*
         * Set up variables
         */
        Graph<Integer> q = new Graph1L<>();
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5);
        /*
         * Call method under test
         */
        q.add(5);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(qExpected, q.getRep());

    }

    @Test
    public void testConnectEmpty() {
        Graph<Integer> q = this.createVerticesFromArgs(5, 6);
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5, 6);

        this.connectVertices(5, 6);

        q.connect(5, 6);

        assertEquals(qExpected, q.getRep());
    }

    @Test
    public void testAdjacency() {
        Graph<Integer> q = this.createVerticesFromArgs(5, 6);
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5, 6);

        this.connectVertices(5, 6);

        Set<Integer> v1 = qExpected.get(5);
        Set<Integer> v2 = qExpected.get(6);

        q.connect(5, 6);

        assertTrue(v1.contains(6));
        assertTrue(v2.contains(5));
        assertTrue(q.isAdjacent(5, 6));
    }

    @Test
    public void testRemoveLeavingOne() {
        Graph<Integer> q = this.createVerticesFromArgs(5, 6);
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5, 6);

        this.connectVertices(5, 6);
        q.connect(5, 6);

        int remove = 6;

        q.remove(remove);
        Set<Integer> valSet = qExpected.remove(remove);

        for (Integer x : valSet) {
            if (qExpected.containsKey(x)) {
                qExpected.get(x).remove(remove);
            }
        }

        assertEquals(qExpected, q.getRep());
    }

    @Test
    public void testMultiRelation() {
        Graph<Integer> q = new Graph1L<>();
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5, 6, 7,
                8);

        q.add(5);
        q.add(6);
        q.add(7);

        Set<Integer> vertices = new HashSet<>();
        vertices.add(5);
        vertices.add(6);
        vertices.add(7);

        q.add(vertices, 8);

        this.connectVertices(8, 5);
        this.connectVertices(8, 6);
        this.connectVertices(8, 7);

        assertEquals(qExpected, q.getRep());
    }

    @Test
    public void testRemove() {
        Graph<Integer> q = this.createVerticesFromArgs(5, 6);
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5, 6);

        this.connectVertices(5, 6);
        q.connect(5, 6);

        g.get(5).remove(6);
        g.get(6).remove(5);

        q.disconnect(5, 6);

        assertEquals(qExpected, q.getRep());
    }

//      --- TEST TEMPLATE BELOW ---
//    @Test
//    public void testTemplate() {
//        setUp();
//        Graph.Graph<Integer> q = new GraphImp.Graph1L<>();
//        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest();
//        tearDown();
//    }
}
