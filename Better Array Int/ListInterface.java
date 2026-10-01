
public interface ListInterface {
	
	/**
	 * The following method is used to add the specified element
	 * to the end of the list.
	 * @param element
	 */
	public void add(int element);
	
	/**
	 * The following method is used to add the specified element to
	 * the list at the specified index.
	 * 
	 * What if the index is invalid? What should we do in the case?
	 * @param element
	 * @param index
	 */
	public void add(int element, int index) throws IndexOutOfBoundsException; ;
	
	/**
	 * The following method returns true if the list is empty. Otherwise return false.
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * The following method returns the amount of the elements currently stored in the
	 * list.
	 * @return
	 */
	
	public int size();
	
	/**
	 * The following method removes at element at the specified index and returns the
	 * removed element.
	 * 
	 * What if the index is invalid? What should we do in the case?
	 * @param index
	 * @return
	 */
	public int remove(int index) throws IndexOutOfBoundsException;
	
	/**
	 * The following method removes everything from the list.
	 */
	public void removeAll();
	
	/**
	 * The following method used to return at element stored at the specified index.
	 * 
	 * What if the index is invalid? What should we do in the case?
	 * @param index
	 * @return
	 */
	public int get(int index) throws IndexOutOfBoundsException;
	
	/**
	 * The following methods replaces at element at the specified index with the 
	 * given element. The method returns the replaced element (old element).
	 * @param element
	 * @param index
	 * @return
	 */
	public int replace(int element, int index) throws IndexOutOfBoundsException;
	
	
	/**
	 * This returns the string representation of the list.
	 * @return
	 */
	public String toString();

}
