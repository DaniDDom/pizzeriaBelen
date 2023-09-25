package pizzeria.belen;

public interface Actions<T> {

	
	/**
	 * Insert an element, if the operation is successful return true, else false.
	 * @param elemento
	 * @return
	 */
	public boolean push(T elemento);

	/**
	 * Next element to attend.
	 * @return
	 */
	public T pop();

	/**
	 * True if the queue is empty else false.
	 * @return
	 */
	public boolean isEmpty();
        
        /**
         * Get number of Elemnts
         * @return 
         */
        public int getNumElements();


}
