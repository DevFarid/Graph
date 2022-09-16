package GraphImp;

import GraphInterface.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author Farid2k & R.E.M.O
 *
 * @param <T>
 */
public class Graph1L<T> extends GraphSecondary<T> {
    /**
     *
     */
    private java.util.Map<T, Set<T>> rep;

    /**
     * Empty constructor new representation.
     */
    private void createNewRep() {
        this.rep = new HashMap<>();
    }

    /**
     * Empty constructor.
     */
    public Graph1L() {
        this.createNewRep();
    }

    @Override
    public void connect(T vertexOne, T vertexTwo) {
        assert (this.contains(
                vertexOne)) : "Violation of: vertexOne is not in this";
        assert (this.contains(
                vertexTwo)) : "Violation of: vertexTwo is not in this";

        Set<T> values;

        for (Map.Entry<T, Set<T>> mapEntry : this.rep.entrySet()) {
            if (mapEntry.getKey().equals(vertexOne)) {
                values = mapEntry.getValue();
                values.add(vertexTwo);
                mapEntry.setValue(values);
            }
            if (mapEntry.getKey().equals(vertexTwo)) {
                values = mapEntry.getValue();
                values.add(vertexOne);
                mapEntry.setValue(values);
            }
        }

    }

    @Override
    public void disconnect(T vertexOne, T vertexTwo) {
        assert (this
                .contains(vertexOne)) : "Violation of: vertexOne is in this";
        assert (this
                .contains(vertexOne)) : "Violation of: vertexTwo is in this";
        assert (this.isAdjacent(vertexOne,
                vertexTwo)) : "Violation of: vertexOne is adjacent to vertexTwo";

        this.rep.get(vertexOne).remove(vertexTwo);
        this.rep.get(vertexTwo).remove(vertexOne);

    }

    @Override
    public boolean isAdjacent(T vertexOne, T vertexTwo) {
        assert (this.contains(
                vertexOne)) : "Violation of: vertexOne is not in this";
        assert (this.contains(
                vertexTwo)) : "Violation of: vertexTwo is not in this";

        Set<T> v1 = this.rep.get(vertexOne);
        Set<T> v2 = this.rep.get(vertexTwo);

        return v1.contains(vertexTwo) && v2.contains(vertexOne);
    }

    @Override
    public void add(T vertex) {
        assert (!this.contains(vertex)) : "Violation of: vertex is not in this";

        java.util.Set<T> degreeSet = new HashSet<>();
        this.rep.put(vertex, degreeSet);

    }

    @Override
    public void add(T vertexOne, T vertexTwo) {
        assert (!this.contains(
                vertexOne)) : "Violation of: vertexOne is not in this";
        assert (!this.contains(
                vertexTwo)) : "Violation of: vertexTwo is not in this";

        java.util.Set<T> v1 = new HashSet<>();
        java.util.Set<T> v2 = new HashSet<>();

        this.rep.put(vertexOne, v1);
        this.rep.put(vertexTwo, v2);

        this.connect(vertexOne, vertexTwo);

    }

    @Override
    public void add(Set<T> vertices, T vertex) {
        assert (!this.contains(vertex)) : "Violation of: vertex is not in this";
        for (T v : vertices) {
            if (!this.contains(v)) {
                throw new AssertionError(
                        "Violation of: vertex in Set<T> is in this.");
            }
        }

        java.util.Set<T> vSet = new HashSet<>();
        this.rep.put(vertex, vSet);

        for (T v : vertices) {
            this.connect(vertex, v);
        }

    }

    @Override
    public boolean remove(T vertex) {
        assert (this.contains(vertex)) : "Violation of: vertex is in this";
        boolean operation = false;

        Set<T> valSet = this.rep.remove(vertex);
        for (T v : valSet) {
            Set<T> innerValSet = this.rep.get(v);
            if (innerValSet.contains(vertex)) {
                operation = innerValSet.remove(vertex);
            }
        }

        return operation;
    }

    @Override
    public int length() {
        return this.rep.size();
    }

    @Override
    public boolean contains(T vertex) {
        assert (vertex != null) : "Violation of: vertex is not null";
        return this.rep.containsKey(vertex);
    }

    public String toString() {
        String toString = "";
        for (Map.Entry<T, Set<T>> node : this.rep.entrySet()) {
            toString += "Node: " + node.getKey().toString() + " | " + node.getValue().toString();
        }
        return toString;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public Graph<T> newInstance() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void transferFrom(Graph<T> source) {
        // TODO Auto-generated method stub

    }

    /**
     * For testing purposes only. Remove later.
     *
     * @return this internal representation.
     */
    @Override
    public java.util.Map<T, Set<T>> getRep() {
        return this.rep;
    }

    @Override
    public Iterator<T> iterator() {
        return new Graph1LIterator();
    }

    /**
     * Implementation of {@code Iterator} interface for {@code Set1L}.
     */
    private final class Graph1LIterator implements Iterator<T> {

        /**
         * Representation iterator.
         */
        private final Iterator<T> iterator;

        /**
         * No-argument constructor.
         */
        private Graph1LIterator() {
            this.iterator = Graph1L.this.rep.keySet().iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public T next() {
            assert this.hasNext() : "Violation of: ~this.unseen /= <>";
            if (!this.hasNext()) {
                /*
                 * Exception is supposed to be thrown in this case, but with
                 * assertion-checking enabled it cannot happen because of assert
                 * above.
                 */
                throw new NoSuchElementException();
            }
            return this.iterator.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove operation not supported");
        }

    }
}
