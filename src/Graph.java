import java.util.Set;

/**
 * Implementation of Graph.
 *
 * @author Farid2k & R.E.M.O.
 *
 * @param <T>
 */
public interface Graph<T> extends GraphKernel<T> {

    /**
     * Creates an edges between two vertices. Connects {@code vertexOne} to
     * {@code vertexTwo}
     *
     * @param vertexOne
     *            the vertex that will be adjacent to {@code vertexTwo}.
     * @param vertexTwo
     *            the other vertex that will be adjacent to {@code vertexOne}.
     * @requires {@code vertexOne} is in entries(this) AND {@code vertexTwo} is
     *           in entries(this) AND {@code vertexOne} is not null AND
     *           {@code vertexTwo} is not null.
     * @ensures {@code vertexOne} is adjacent to {@code vertexTwo}.
     */
    void connect(T vertexOne, T vertexTwo);

    /**
     * Removes an existing edge that is established between two vertices.
     *
     * @param vertexOne
     *            the vertex adjacent to {@code vertexTwo}.
     * @param vertexTwo
     *            the other vertex adjacent with {@code vertexOne}.
     * @requires {@code vertexOne} is in entries(this) AND {@code vertexTwo} is
     *           in entries(this) AND {@code vertexOne} is adjacent to
     *           {@code vertexTwo}.
     * @ensures {@code vertexOne} is not adjacent to {@code vertexTwo}.
     */
    void disconnect(T vertexOne, T vertexTwo);

    /**
     *
     * @param vertexOne
     *            the first vertex passed.
     * @param vertexTwo
     *            the second vertex passed.
     * @return isConnected = [returns true if {@code vertexOne} is adjacent to
     *         {@code vertexTwo}.
     */
    boolean isAdjacent(T vertexOne, T vertexTwo);

    /**
     *
     * @return internal representation of class extending this.
     */
    java.util.Map<T, Set<T>> getRep();

}
