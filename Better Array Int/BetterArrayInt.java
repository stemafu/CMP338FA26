

/**
 * To be able to create this BetterArray (ArrayBasedList, ArrayList),
 * we need a data structure (storage container) that we can use for 
 * storing elements being added to the list. For the ArrayBasedList (BetterArray),
 * we are going to use an array as our storage container (underlying storage data 
 * structure). 
 * Recall that array have fixed size. So if we want our List to be dynamic (not fixed in
 * size), then every time the array is full during the addition of a new element, we need
 * to increase the size of the array. 
 * 
 * 
 * We also need a separate variable that will keep track of the amount of element
 * currently stored in the list.
 * 
 * Initially this variable is set to 0. Each time we add an element, we increase by 1, the 
 * value of the variable.
 * 
 * And each time, we remove an element we decrease by 1, the value of the variable.
 * 
 * This variable also acts as an index of the next location where we can append a
 * value.
 * 
 * 
 */
public class BetterArrayInt implements ListInterface{
	
	private final int ARRAYCAPACITY = 5;
	private int [] elements;
	private int count;
	
	public BetterArrayInt() {
		this.elements = new int[ARRAYCAPACITY];
		this.count = 0;
	}
	
	public BetterArrayInt(int capacity) {
		this.elements = new int[capacity];
		this.count = 0;
	}	
	

	@Override
	public void add(int element) {
		
		/*
		 * First, we have check to see if the array is full, and if the array is
		 * full, increase size.
		 */
		if(this.isArrayFull()) {
			this.resize();
		}
		
		this.elements[this.count] = element;
		this.count++;
		
	}

	@Override
	public void add(int element, int index) throws IndexOutOfBoundsException{


		if(index < 0 || index > this.count) {
			// We will fix this part later
			// We cannot add at an invalid index
			//System.out.println("You provided an invalid index");
			throw new IndexOutOfBoundsException("You provided an invalid index " + index);
		}else if (index == this.count){
			
			// This means we want to add at the end of the list
			// just call the add
			
			this.add(element);
		}else {
			
			if(this.isArrayFull()) {
				this.resize();
			}
			
			
			
			/*
			 * Solution 1
			 * Start of solution 1
			 * this.elements[this.count] = this.elements[index];
			 * this.elements[index] = element;
			 * this.count++;
			 * 
			 * End of solution 1
			*/
			
			/*
			 * Solution 2: requires shifting elements
			 * shift the values
			 */
			
			for(int i = this.count; i > index; i--) {
				this.elements[i] = this.elements[i - 1];
			}
			
			this.elements[index] = element;
			this.count++;
			
		}
		
	}

	@Override
	public boolean isEmpty() {
		 
		
		/*if(count == 0)
			return true;
		
		return false;*/
		
		return count == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int remove(int index) throws IndexOutOfBoundsException{
		
		if(index < 0 || index >= this.count) {
			//System.out.println("The index you provided is invalid");
			//return -1;
			throw new IndexOutOfBoundsException("The index " + index + "  you provided is invalid");
		}else {
			
			
			int removedElement = this.elements[index];
			
			if(this.count == 1) {
				this.removeAll();
			}else {
			
				//Shift values
				for(int i = index; i < this.count - 1; i++) {
					this.elements[i] = this.elements[i + 1];
				}
				
				this.count--;
				
			}
			return removedElement;
		}
	}

	@Override
	public void removeAll() {
		
		this.elements = new int[ARRAYCAPACITY];
		this.count = 0;
		
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException{
		
		/* We are assuming that the user will always provide a valid index
		*/
		if(index < 0 || index >= this.count) {
			//System.out.println("The index you provided is invalid");
			//return -1;
			throw new IndexOutOfBoundsException("The index " + index + " you provided is invalid");
		}
		
		
		return this.elements[index];
	}

	@Override
	public int replace(int element, int index) throws IndexOutOfBoundsException  {
	
		
		if(index < 0 || index >= this.count) {
			//System.out.println("The index you provided is invalid");
			//return -1;
			throw new IndexOutOfBoundsException("The index " + index + "  you provided is invalid");
		}else {
			
			int replacedElement = this.elements[index];
			this.elements[index] = element;
			return replacedElement;			
		}
		
		
	}
	
	private boolean isArrayFull() {
		return (this.count == elements.length);
	}
	
	private void resize() {
		// We are creating a bigger array
		int [] elementsCopy = new int[elements.length * 2];
		
		for(int i = 0; i < this.count; i++) {
			/*copy one value at a time from the old array into the 
			new array
			*/
			elementsCopy[i] = elements[i]; 
		}
		
		elements = elementsCopy;
	}

}
