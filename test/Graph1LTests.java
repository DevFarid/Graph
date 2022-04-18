import static org.junit.Assert.assertEquals;

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
            g.add(x);
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
        Graph<Integer> q = this.createVerticesFromArgs();
        Graph<Integer> qExpected = this.createVerticesFromArgs(5);
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
        assertEquals(qExpected, q);
    }

}
