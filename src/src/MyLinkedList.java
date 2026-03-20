package src;

public class MyLinkedList {
	private MyNode firstNode = null;
	private MyNode lastNode = null;
	private int howManyElements = 0;

	public int getHowManyElements() {
		return howManyElements;
	}
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	public boolean isFull() {
		try {
		new MyNode('a');
		return false;
	}
	catch(OutOfMemoryError error) {
		return true;
	}
}
	public void add(char element) throws Exception {
		if(isFull()) {
			throw new Exception("Saraksts ir pilnnns");
		}
		if(howManyElements == 0) {
			MyNode newNode = new MyNode(element);
			firstNode = newNode;
			lastNode = newNode;
			howManyElements++;
		}
		else
		{
			MyNode newNode = new MyNode(element);
			newNode.setPreviousNode(lastNode);
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
	}
	public void print() throws Exception{
		if(isEmpty()) {
			throw(new Exception("Sarakstu nevar izveidot"));
		}
		MyNode currentNode = firstNode;
		while(currentNode!=null) {
			System.out.println(currentNode.getElement());
			currentNode = currentNode.getNextNode();
		}
		System.out.println();
	}
}