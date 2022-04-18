import java.util.Iterator;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;

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
    private Map<Object, Set<Object>> rep;

    /**
     * Empty constructor new representation.
     */
    private void createNewRep() {
        this.rep = new Map1L<>();
    }

    /**
     * Empty constructor.
     */
    public Graph1L() {
        this.createNewRep();
    }

    @Override
    public void connect(T vertexOne, T vertexTwo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void disconnect(T vertexOne, T vertexTwo) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isAdjacent(T vertexOne, T vertexTwo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void add(T vertex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(T vertexOne, T vertexTwo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(Set<T> vertices, T vertex) {
        // TODO Auto-generated method stub

    }

    @Override
    public T remove(T vertex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T vertex) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

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

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
