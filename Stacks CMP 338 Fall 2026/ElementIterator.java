import java.util.Iterator;
import java.util.Vector;

public class ElementIterator<E> implements
Iterator<E>{
	
	private Vector<E> elements;
	
	public ElementIterator(Vector<E> elements) {
		this.elements = elements;
	}

	@Override
	public boolean hasNext() {
		
		return !this.elements.isEmpty();
	}

	@Override
	public E next() {
		
		if(this.elements.isEmpty()) {
			return null;
		}
		
		E nextElement = elements.get(0);
		elements.remove(0);
		return nextElement ;
	}

}
