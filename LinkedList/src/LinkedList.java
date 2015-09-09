
public class LinkedList<V> {
    protected Node<V> head, tail;
    protected long size;

    // Empty list constructor first
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    } 
    
    // Method to add Nodes to the list. Storage space for the Node is already allocated in the calling method
    @SuppressWarnings("unchecked")
	public void addFirst(Node<V> Node) {
        // Set the tail only if this is the very first Node
        if (tail == null) {
            tail = Node;
        }
        
        Node.setNode((V) head); // Make next of the new Node refer to the head
        head = Node; // Give head a new value
 
        // change the size
        size++;
    } 
 
    // Add new Node after current Node, checking to see if we are at the tail
    public void addAfter(Node<V> currentNode, Node<V> newNode) {
        if (currentNode == tail)
            tail = newNode;
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
 
        // change the size
        size++;
    } 
 
    // Add new Node after the tail Node.
    public void addLast(Node<V> node) {
        node.setNext(null);
        tail.setNext(node);
        tail = node;
        size++;
    }
 
    // Methods to remove Nodes from the list. (Unfortunately, with a single linked list. there is no way to remove last. Need a previous reference to do that.
    public Node<V> removeFirst() {
        if (head == null)
            System.err.println("Error:  Attempt to remove from an empty list");
 
        // save the one to return
        Node<V> temp = head;
 
        // do reference manipulation
        head = head.getNext();
        temp.setNext(null);
        size--;
 
        return temp;
 
    } 
 
    // Remove the Node at the end of the list. tail refers to this Node, but since the list is single linked, there is no way to refer to the Node before the tail Node. Need to traverse the list.
    public Node<V> removeLast() {
        // Declare local variables/objects
        Node<V> nodeBefore;
        Node<V> nodeToRemove;
 
        // Make sure we have something to remove
        if (size == 0)
            System.err.println("Error:  Attempt to remove from an empty list");
 
        // Traverse through the list, getting a reference to the Node before the trailer. Since there is no previous reference.
        nodeBefore = getFirst();
 
        for (int count = 0; count < size - 2; count++)
            nodeBefore = nodeBefore.getNext();
 
        // Save the last Node
        nodeToRemove = tail;
 
        // Let's do the pointer manipulation
        nodeBefore.setNext(null);
        tail = nodeBefore;
        size--;
 
        return nodeToRemove;
    } 
 
    // Remove a known Node from the list. No need to search or return a value. This method makes use of a 'before' reference in order to allow list manipulation.
    public void remove(Node<V> NodeToRemove) {
        // Declare local variables/references
        Node<V> nodeBefore, currentNode;
 
        // Make sure there is something to remove
        if (size == 0)
            System.err.println("Error:  Attempt to remove fron an empty list");
 
        // Starting at the beginning check for removal
        currentNode = getFirst();
        if (currentNode == NodeToRemove)
            removeFirst();
        currentNode = getLast();
        if (currentNode == NodeToRemove)
            removeLast();
 
        // We've already check two Nodes, check the rest
        if (size - 2 > 0) {
            nodeBefore = getFirst();
            currentNode = getFirst().getNext();
            for (int count = 0; count < size - 2; count++) {
                if (currentNode == NodeToRemove) {
                    // remove current Node
                    nodeBefore.setNext(currentNode.getNext());
                    size--;
                    break;
                }
 
                // Change references
                nodeBefore = currentNode;
                currentNode = currentNode.getNext();
            } 
        } 
    }
 
    // The gets to return the head and/or tail Nodes and size of the list
    public Node<V> getFirst() {
        return head;
    }
 
    public Node<V> getLast() {
        return tail;
    }
 
    public long getSize() {
    	return size;
    }
}
