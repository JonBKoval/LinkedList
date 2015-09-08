
public class Node<Type> {
	private Type data;
	private Node<Type> nextNode;
	
	// Default Constructor
	public Node(){
		this(null, null);
	}

	// Constructor
	public Node(Type item, Node<Type> next) {
		this.data = item;
		this.nextNode = next;
	}
	
	public Type getNodeData() {
		return data;
	}
	
	public Node<Type> getNext() {
		return nextNode;
	}
	
	public void setNode(Type item) {
		this.data = item;
	}
	
	public void setNext(Node<Type> next) {
		this.nextNode = next;
	}
}
