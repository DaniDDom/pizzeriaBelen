package pizzeria.belen;

/**
 * This class represents the queue.
 *
 * @author Dani Dom
 *
 */
public class Queue<T> implements Actions<T> {

    /**
     * Queue.
     */
    private T[] ovenQueue;

    /**
     * Number of Elements
     */
    private int numElements = 0;

    /**
     * number of elements getter
     *
     * @return
     */
    public int getNumElements() {
        return numElements;
    }

    /**
     * Constructor
     */
    public Queue(int size) {
        ovenQueue = (T[]) new Object[size];
    }

    /**
     * Introduce an element, return whether is possible or not.
     *
     * @param elemento
     * @return
     */
    public boolean push(T elemento) {
        
        boolean inserted = false;

        if (this.getNumElements() < ovenQueue.length) {

            ovenQueue[this.getNumElements()] = elemento;
            this.numElements++;
            inserted = true;
        }

        return inserted;
    }

    /**
     * Next element to attend.
     *
     * @return
     */
    @Override
    public T pop() {
        T p1 = ovenQueue[0];
        for(int i=0; i < ovenQueue.length-1; i++) {
            ovenQueue[i] = ovenQueue[i+1];
        }
        this.numElements--;
        return p1;
    }

    /**
     * True if the queue is empty else false.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {

        if (this.getNumElements() == 0) {
            return true;
        }
        return false;
    }

}
