package Service;

import src.MyLinkedList;
import model.Student;

public class MainService {
//TODO no Sem1 paņemt studenta klasi un uztaisīt piemerus šeit arī ar stduentiem
	public static void main(String[] args) {
		MyLinkedList<Character> symbols = new MyLinkedList<Character>();
		try
		{
			symbols.add('B');
			symbols.add('A');
			symbols.add('C');
			symbols.add('G');
			symbols.print();//B A C G
			System.out.println("Pievienot elementu sākumā");
			symbols.add('Z',0);
			symbols.print();//Z B A C G
			System.out.println("Pieveinot elementu beigās");
			symbols.add('W',5);
			symbols.print();//Z B A C G W
			System.out.println("Pievienot elementu pa vidu - 2.pozīcijā");
			symbols.add('K', 2);
			symbols.print(); //Z B A K C G W
			
			System.out.println("Izdzēšam elementu no sākuma");
			symbols.remove(0);
			symbols.print();//B A K C G W
			
			System.out.println("Izdzēšam elementu no beigām");
			symbols.remove(5);
			symbols.print();//B A K C G
			
			System.out.println("Izdzēšam elementu no vidus - 3. pozīcijā");
			symbols.remove(3);
			symbols.print();//B A K G
			
			System.out.println("Izgūt elementu no 2 pozīcijas");
			System.out.println("2.pozīcijas element ir " + symbols.get(2));//A
			
			System.out.println("Atrast G elementa pozīciju");
			System.out.println(symbols.search('G'));//3
			
			System.out.println("Iztukšot sarakstu un pēc tam pievineo jaunu elementu");
			symbols.makeEmpty();
			symbols.add('Q');
			symbols.print();//Q

			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-----------------STUDENTI------------");
		MyLinkedList<Student> allStudents = new MyLinkedList<Student>();
			
		try
		{
			allStudents.add(new Student("Janis", "Berzins"));//Janis
			Student s1 = new Student("Baiba", "Jauka");
			allStudents.add(s1);//Janis Baiba
			allStudents.add(new Student("Peteris", "Nejaukais"), 0);//Peteris Janis Baiba
			allStudents.print();//Peteris Janis Baiba
			allStudents.remove(0);//Pēteris izdzest
			allStudents.print();//Janis Baiba
			allStudents.add(new Student("Kaspars", "Kalnins"));//Janis Baiba Kaspars
			allStudents.add(new Student("Liga", "Jautra"));//Janis Baiba Kaspars Liga
			System.out.println(allStudents.get(3));//Liga
			System.out.println(allStudents.search(s1));//Mekleju Baibu - 1
			allStudents.print();
			allStudents.makeEmpty();
			allStudents.add(new Student("Karina", "Skirmante"));
			allStudents.print();//Karina
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}