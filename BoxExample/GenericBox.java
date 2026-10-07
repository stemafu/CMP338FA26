
public class GenericBox <T> {
	/*
	 * T is a parameter for this class. This is a placeholder for some
	 * data type that we will for any box of our interest.
	 * 
	 * By parameterizing this class, we are able to create a class that is capable
	 * of taking any data type instead of a specific data type.
	 */
	
	// Here is is a placeholder for some actual data type.
	private T data;
	
	public GenericBox(T data) {
		this.data = data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
}
