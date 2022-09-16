package GraphInterface;

import GraphStandard.Standard;

/**
 * A graph, G = (V, E), is a finite set of vertices, V, and a finite set of
 * edges, E, where each edge (u, v) connects two vertices, u and v.
 *
 * @author Farid2k & R.E.M.O.
 *
 * @param <T>
 */
public interface GraphKernel<T> extends Standard<Graph<T>>, Iterable<T> {

    /**
     * Adds an isolated vertex to entries(this).
     *
     *
     * @param vertex
     * @requires {@code vertex} is not in entries(this).
     * @ensures this = #this * {@code vertex}
     */
    void add(T vertex);

    /**
     * Adds a vertex with the ability to add a relation with another vertex.
     *
     * @param vertexOne
     *            the vertex that is getting a relation.
     * @param vertexTwo
     *            the vertex being added with a relation to another vertex.
     * @requires {@code vertexOne} is in entries(this) and {@code vertexTwo} is
     *           not in entries(this).
     * @ensures this = #this * {@code vertex} AND {@code vertexOne} is adjacent
     *          to {@code vertexTwo}
     */
    void add(T vertexOne, T vertexTwo);

    /**
     * Adds a single vertex but with the ability to create multiple relations
     * with other vertices.
     *
     * @param vertices
     *            the multiple vertices that will have a relation with the
     *            incoming vertex.
     * @param vertex
     *            the vertex being added with multi-relations.
     * @requires entries({@code vertices} is in entries(this)
     * @ensures {@code vertex} is adjacent to entries({@code vertices})
     */
    void add(java.util.Set<T> vertices, T vertex);

    /**
     * Removes a vertex from the graph.
     *
     * @param vertex
     *            the vertex that will be removed.
     * @requires {@code vertex} is in entries(this)
     * @ensures this = #this \ {@code vertex}
     * @return the vertex removed.
     */
    boolean remove(T vertex);

    /**
     * Returns the total n amount of vertices that exist in this.
     *
     * @return the amount of vertices in this.
     * @ensures length = |this|
     */
    int length();

    /**
     * Checks to see if a vertex already exists.
     *
     * @param vertex
     *            the vertex being checked for.
     * @return contains = [returns true if {@code vertex} is in @entries(this)]
     */
    boolean contains(T vertex);
}
