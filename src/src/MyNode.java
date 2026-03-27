package src;

public class MyNode<Ttype> {
	private Ttype element;
	private MyNode nextNode = null;
	private MyNode previousNode = null;
	
	public Ttype getElement() {
		return element;
	}
	public MyNode getNextNode() {
		return nextNode;
	}
	public MyNode getPreviousNode() {
		return previousNode;
	}
	public void setElement(Ttype element) {
		if(element != null)
		{
			this.element = element;
		}
		else
		{
			this.element = (Ttype) new Object();
		}
	}
	public void setNextNode(MyNode nextNode) {
		this.nextNode = nextNode;
	}
	public void setPreviousNode(MyNode previousNode) {
		this.previousNode = previousNode;
	}
	public MyNode(Ttype element) {
		setElement(element);
	}
	
	public String toString() {
		return "" + element;
	}
	
}