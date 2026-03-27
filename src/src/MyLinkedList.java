package src;

public class MyLinkedList<Ttype> {

	private MyNode firstNode = null;// get un set netaisam, jo lieottajam nedodam iespēju tikt pie pašiem blokiem
	private MyNode lastNode = null;// get un set netaisam, jo lieottajam nedodam iespēju tikt pie pašiem blokiem
	private int howManyElements = 0;// set funkciju netaisam, jo neļaujam lietotjam pašam mainīt, cik daudz ir
									// elementu

	public int getHowManyElements() {
		return howManyElements;
	}

	// nedefinēšu bezargumenta konstruktoru, oj izmantošanu Object mantoto

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

	public void add(Ttype element) throws Exception {
		if (isFull()) {
			throw new Exception("Saraksts ir pilns un nevar pievienot elementu");
		}

		if(element == null) {
			throw new Exception("Ievades elements nevar būt null");
		}
		
		
		// tiks pievienots pirmais elements un tam izveidots piramis bloks
		if (isEmpty()) {
			MyNode newNode = new MyNode(element);
			firstNode = newNode;
			lastNode = newNode;
			howManyElements++;
		}
		// ja tiek pievienots otrais, tresais... elements
		// TODO ja vēlas, tad var aoptimizet kodu, jo ir rindas, kuras sakrīt abos
		// gadījumos
		else {
			MyNode newNode = new MyNode(element);
			newNode.setPreviousNode(lastNode);
			lastNode.setNextNode(newNode);
			lastNode = newNode;
			howManyElements++;

		}

	}

	public void add(Ttype element, int position) throws Exception {
		if(element == null) {
			throw new Exception("Ievades elements nevar būt null");
		}
		
		if (isFull()) {
			throw new Exception("Saraksts ir pilns un nevar pievienot elementu");
		}
		
		if (position < 0) {
			throw new Exception("Pozicīja nevar būt mazakā par 0");
		}

		if (position > howManyElements) {
			throw new Exception("Pozīcija ir lielāka kā atļautā");
		}

		// 1. ievietot sakumā kā nulto elementu
		if (position == 0) {
			MyNode newNode = new MyNode(element);
			firstNode.setPreviousNode(newNode);
			newNode.setNextNode(firstNode);
			firstNode = newNode;
			howManyElements++;
		}

		// 2. piekabināt beigās kā pēdejo elementu
		else if (position == howManyElements) {
			add(element);

		}
		// 3. iespraucināt elementu pa vidu
		else {
			MyNode currentNode = firstNode;// TODO noskaidrot, kurā pozicjā - tuvaak sākumam vai beigām ir jaievieto
											// bloks
			for (int i = 1; i < position; i++) {
				currentNode = currentNode.getNextNode();
			}

			MyNode previousNode = currentNode;
			MyNode nextNode = currentNode.getNextNode();

			MyNode newNode = new MyNode(element);

			newNode.setPreviousNode(previousNode);
			previousNode.setNextNode(newNode);

			newNode.setNextNode(nextNode);
			nextNode.setPreviousNode(newNode);

			howManyElements++;

		}

	}

	public void print() throws Exception {
		if (isEmpty()) {
			throw (new Exception("Saraksts ir tukšs un to nevar izprintēt"));
		}

		MyNode currentNode = firstNode;
		while (currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNextNode();
		}
		System.out.println();

	}

	public void remove(int position) throws Exception {
		if (isEmpty()) {
			throw (new Exception("Saraksts ir tukšs, tāpēc nevar izdzēst elementus"));
		}

		if (position < 0) {
			throw (new Exception("Nevar izdzēst elementu, jo pozīcija ir negatīva"));
		}

		if (position >= howManyElements) {
			throw (new Exception("Nevar izdzēst elementu, jo pozīcija ir lielāks ka elementu skaits"));
		}

		// Pirmā bloka dzēšana
		if (position == 0) {
			MyNode newFirstNode = firstNode.getNextNode();
			newFirstNode.setPreviousNode(null);
			firstNode = newFirstNode;
			howManyElements--;
		}
		// dzēšam pēdējo bloku
		else if (position == howManyElements - 1) {
			MyNode newLastNode = lastNode.getPreviousNode();
			newLastNode.setNextNode(null);
			lastNode = newLastNode;
			howManyElements--;
		}
		// dzēsam bloku pa vidu
		else {
			MyNode currentNode = firstNode;
			for (int i = 1; i < position; i++) {
				currentNode = currentNode.getNextNode();
			}

			MyNode newLeftNode = currentNode;
			MyNode newRightNode = currentNode.getNextNode().getNextNode();

			newLeftNode.setNextNode(newRightNode);
			newRightNode.setPreviousNode(newLeftNode);

			howManyElements--;

		}

	}
	
	public Ttype get(int position) throws Exception{
		if (isEmpty()) {
			throw (new Exception("Saraksts ir tukšs, tāpēc nevar izgūt elementus"));
		}

		if (position < 0) {
			throw (new Exception("Nevar izgūt elementu, jo pozīcija ir negatīva"));
		}

		if (position >= howManyElements) {
			throw (new Exception("Nevar izgūt elementu, jo pozīcija ir lielāka kā elementu skaits"));
		}
		
		MyNode currentNode = firstNode;
		for(int i = 1; i <= position; i++) {
			currentNode = currentNode.getNextNode();
		}
		
		return (Ttype) currentNode.getElement();
		
	}
	
	
	//TODO mājās partaisīt funkciju, lai var atrast elmentu vairākas vietas un visas pozīcijas atgriež
	public int search(Ttype element) throws Exception{
		if(element == null) {
			throw new Exception("Ievades elements nevar būt null");
		}
		
		if (isEmpty()) {
			throw (new Exception("Saraksts ir tukšs, tāpēc nevar meklēt elementus"));
		}
		
			
		int foundPosition = 0;
		MyNode currentNode = firstNode;
		while(currentNode!=null) {
			if(currentNode.getElement().equals(element)) {
				return foundPosition;
			}
			foundPosition++;
			currentNode = currentNode.getNextNode();
		}
		
		throw new Exception("Meklētais elements neeksistē sarakstā");
		
	}
	
	
	public void makeEmpty() {
		firstNode = null;
		lastNode = null;
		howManyElements = 0;
		System.gc();
	}

}