package Service;

import src.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList symbols = new MyLinkedList();
		try
		{
		symbols.add('l');
		symbols.add('a');
		symbols.add('d');
		symbols.print();
		symbols.add('Z',0);
		symbols.print();
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}

	}
}
