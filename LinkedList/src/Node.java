
public class Node<V> {
	private V data;
	private Node<V> nextNode;
	
	// Default Constructor
	public Node(){
		this(null, null);
	}

	// Constructor
	public Node(V item, Node<V> next) {
		this.data = item;
		this.nextNode = next;
	}
	
	public V getNodeData() {
		return data;
	}
	
	public Node<V> getNext() {
		return nextNode;
	}
	
	public void setNode(V item) {
		this.data = item;
	}
	
	public void setNext(Node<V> next) {
		this.nextNode = next;
	}
}
