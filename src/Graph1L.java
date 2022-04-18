import components.map.Map;
import components.map.Map1L;
import components.set.Set;

/**
 *
 * @author Farid2k & R.E.M.O
 *
 * @param <T>
 */
public class Graph1L<T> {
    /**
     *
     */
    private Map<Object, Set<Object>> rep;
    /**
     *
     */
    private Object classType;

    /**
     *
     * @param type
     */
    private void createNewRep() {
        this.rep = new Map1L<>();
    }

    /**
     *
     * @param object
     */
    private void createNewRep(T object) {
        this.rep = new Map1L<>();
        this.classType = object.getClass();
    }

    /**
     *
     */
    public Graph1L() {
        this.createNewRep();
    }

    /**
     * @param object
     */
    public Graph1L(T object) {
        this.createNewRep(object);
    }
}
