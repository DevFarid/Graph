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
     * Empty constructor new representation.
     */
    private void createNewRep() {
        this.rep = new Map1L<>();
    }

    /**
     * Creating a new representation while noting what string of T is during
     * run-time.
     *
     * @param object
     */
    private void createNewRep(T object) {
        this.rep = new Map1L<>();
        this.classType = object.getClass();
    }

    /**
     * Empty constructor.
     */
    public Graph1L() {
        this.createNewRep();
    }

    /**
     * Constructor with the explicit type stated.
     *
     * @param object
     *            arbitrary object passed in that will not be used, only to note
     *            what string of T is during run-time.
     */
    public Graph1L(T object) {
        this.createNewRep(object);
    }
}
