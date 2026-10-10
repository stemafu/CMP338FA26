
public class NodeDriver {

	public static void main(String[] args) {
		
		
		Node<Integer> node1 = new Node<Integer>(90);
		
		Node<Integer> node2 = new Node<Integer>(40);
		
		Node<String> node3 = new Node<String>("LC");
		
		System.out.println(node1.getData());
		
		node1.setNext(node2);

	}

}
