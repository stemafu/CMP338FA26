


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
public class BetterArray<I extends Comparable<? super I>> implements ListInterface<I>{
	
	private final int ARRAYCAPACITY = 5;
	private Object [] elements;
	private int count;
	
	public BetterArray() {
		this.elements = new Object[ARRAYCAPACITY];
		this.count = 0;
	}
	
	public BetterArray(int capacity) {
		this.elements = new Object[capacity];
		this.count = 0;
	}	
	

	@Override
	public void add(I element) {
		
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
	public void add(I element, int index) throws IndexOutOfBoundsException{


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
	public I remove(int index) throws IndexOutOfBoundsException{
		
		if(index < 0 || index >= this.count) {
			//System.out.println("The index you provided is invalid");
			//return -1;
			throw new IndexOutOfBoundsException("The index " + index + "  you provided is invalid");
		}else {
			
			
			I removedElement = (I)this.elements[index];
			
			
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
		
		this.elements = new Object[ARRAYCAPACITY];
		this.count = 0;
		
	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException{
		
		/* We are assuming that the user will always provide a valid index
		*/
		if(index < 0 || index >= this.count) {
			//System.out.println("The index you provided is invalid");
			//return -1;
			throw new IndexOutOfBoundsException("The index " + index + " you provided is invalid");
		}
		
		
		return (I)this.elements[index];
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException  {
	
		
		if(index < 0 || index >= this.count) {
			//System.out.println("The index you provided is invalid");
			//return -1;
			throw new IndexOutOfBoundsException("The index " + index + "  you provided is invalid");
		}else {
			
			I replacedElement = (I)this.elements[index];
			this.elements[index] = element;
			return replacedElement;			
		}
		
		
	}
	
	private boolean isArrayFull() {
		return (this.count == elements.length);
	}
	
	private void resize() {
		// We are creating a bigger array
		Object [] elementsCopy = new Object[elements.length * 2];
		
		for(int i = 0; i < this.count; i++) {
			/*copy one value at a time from the old array into the 
			new array
			*/
			elementsCopy[i] = elements[i]; 
		}
		
		elements = elementsCopy;
	}

	@Override
	public ListInterface<I> copy() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addSorted(I element) {
		// TODO Auto-generated method stub
		
	}


}
