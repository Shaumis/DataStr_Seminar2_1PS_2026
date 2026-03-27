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
		} catch (OutOfMemoryError error) {
			return true;
		}
	}

	public void add(char element) throws Exception {
		if (isFull()) {
			throw new Exception("Saraksts ir pilnnns");
		}
		if (howManyElements == 0) {
			MyNode newNode = new MyNode(element);
			firstNode = newNode;
			lastNode = newNode;
			howManyElements++;
		} else {
			MyNode newNode = new MyNode(element);
			newNode.setPreviousNode(lastNode);
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
	}

	public void add(char element, int position) throws Exception {
		if (position < 0) {
			throw new Exception("Nevar būt mazāks par 0");
		}
		if (position > howManyElements) {
			throw new Exception("Too Big");
		}
		if(position == 0) {
			MyNode newNode = new MyNode(element);
			firstNode.setPreviousNode(newNode);
			newNode.setNextNode(newNode);
			howManyElements++;
		}else if(position == howManyElements) {
			add(element);
		}else {
		}
		MyNode currentNode = firstNode;
		for(int i = 1;i<=position ;i++);
		currentNode = currentNode.getNextNode();
		MyNode previousNode = currentNode;
		MyNode nextNode = currentNode.getNextNode();
		MyNode newNode= new MyNode(element);
		newNode.setPreviousNode(previousNode);
		previousNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nextNode.setPreviousNode(newNode);
		howManyElements++;
	}

	public void print() throws Exception {
		if (isEmpty()) {
			throw (new Exception("Sarakstu nevar izveidot"));
		}
		MyNode currentNode = firstNode;
		while (currentNode != null) {
			System.out.println(currentNode.getElement());
			currentNode = currentNode.getNextNode();
		}
		System.out.println();
	}
}