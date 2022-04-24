import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import components.stopwatch.Stopwatch1;

/**
 * Sample JUnit test fixture for SequenceSmooth.
 *
 * @author Farid Kamizi
 *
 */
public final class Graph1LTests {
    /**
     *
     */
    private static Stopwatch1 timer = new Stopwatch1();
    private static Map<Integer, Set<Integer>> g = new HashMap<>();

    /**
     *
     */
    private static void setUp() {
        timer.start();
    }

    /**
     *
     */
    private static void tearDown() {
        timer.stop();
    }

    /**
     *
     * @return return the time duration of a test.
     */
    private static Double duration() {
        double elapsed = timer.elapsed() / 1000.00;
        return elapsed;
    }

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
        setUp();
        Graph<Integer> q = new Graph1L<>();
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5);
        /*
         * Call method under test
         */
        q.add(5);
        /*
         * Assert that values of variables match expectations
         */
        tearDown();
        System.out.println("testAddEmpty() took " + duration() + " sec(s).");
        assertEquals(qExpected, q.getRep());

    }

    @Test
    public void testConnectEmpty() {
        setUp();
        Graph<Integer> q = this.createVerticesFromArgs(5, 6);
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5, 6);

        this.connectVertices(5, 6);

        q.connect(5, 6);

        tearDown();
        assertEquals(qExpected, q.getRep());
    }
    
    @Test
    public void testAdjacency() {
        setUp();
        Graph<Integer> q = this.createVerticesFromArgs(5, 6);
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest(5, 6);

        this.connectVertices(5, 6);
        
        Set<Integer> v1 = qExpected.get(5);
        Set<Integer> v2 = qExpected.get(6);

        q.connect(5, 6);
        
        tearDown();
        assertTrue(v1.contains(6));
        assertTrue(v2.contains(5));
        assertTrue(q.isAdjacent(5, 6));
    }

    @Test
    public void testTemplate() {
        setUp();
        Graph<Integer> q = new Graph1L<>();
        Map<Integer, Set<Integer>> qExpected = this.createFromArgsTest();
        tearDown();
    }
}
