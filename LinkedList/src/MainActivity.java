
public class MainActivity {
	public static void main(String[] args){
		LinkedList<String> list = new LinkedList<>();
		
		Node<String> tempNode = new Node<>();
		Node<String> tempNode2 = new Node<>();
		
		tempNode.setNode("15");
		list.addFirst(tempNode);
		
		tempNode.setNext(tempNode2);
		list.addAfter(tempNode, tempNode2);
		
		tempNode.setNode("16");
		list.addLast(tempNode);
		
		tempNode.setNode("17");
		list.addLast(tempNode);
		
		tempNode.setNode("18");
		list.addLast(tempNode);
		
		System.out.println(list.size);
	}
}
