import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
    private Stopwatch1 timer = new Stopwatch1();

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
    private Map<Object, Set<Object>> createFromArgsTest(Integer... args) {
        Map<Object, Set<Object>> g = new HashMap<>();
        for (Integer x : args) {
            assert !g.containsKey(
                    x) : "Violation of: every entry in args is unique";
            g.put(x, Collections.emptySet());
        }
        return g;
    }

    /**
     *
     */
    @Test
    public void testAddEmpty() {
        /*
         * Set up variables
         */
        this.timer.start();
        Graph<Integer> q = new Graph1L<>();
        Map<Object, Set<Object>> qExpected = this.createFromArgsTest(5);
        /*
         * Call method under test
         */
        q.add(5);
        /*
         * Assert that values of variables match expectations
         */
        this.timer.stop();
        double elapsed = this.timer.elapsed() / 1000.00;
        System.out.println("testAddEmpty() took " + elapsed + " sec(s).");
        System.out.println(qExpected.toString());
        assertEquals(qExpected, q.getRep());

    }

}
