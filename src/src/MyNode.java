package src;

public class MyNode {
	private char element;
	private MyNode nextNode = null;
	private MyNode previousNode = null;

	public char getElement() {
		return element;
	}

	public void setElement(char element) {
		this.element = element;
	}

	public MyNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(MyNode nextNode) {
		this.nextNode = nextNode;
	}

	public MyNode getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(MyNode previousNode) {
		this.previousNode = previousNode;
	}
	public MyNode(char element) {
		setElement(element);
	}
	public String toString() {
		return "" + element;
	}

}
