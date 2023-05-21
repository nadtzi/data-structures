package studenttree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * CMPS303 project - Spring 2018 
 * 
 * 	Saad Yousef Haik	201512094
 *  Hassan Abdulrahman Saadat	201608346
 *
 */
public class Menu {

	static TreeTable t;

	public Menu() {
		// TODO Auto-generated method stub

		load();
		//createSampleData();
		
		Scanner cin = new Scanner(System.in);
		while (true) {
			
			System.out.println("Coose any of the MenuItems:");
			System.out.println("=========================================");
			System.out.println("1: insert student record\n");
			System.out.println("2: find student by QUID\n");
			System.out.println("3: remove student by QUID\n");
			System.out.println("4: print all students added in a specific year\n");
			System.out.println("5: print all students\n");
			System.out.println("6: find students below given GPA\n");
			System.out.println("=========================================\n");
			System.out.print("Enter your choice: ");
			int choice = cin.nextInt();
			switch (choice) {
			case 1:
				System.out.print("enter student's name: ");
				cin.nextLine();		// prevents java from taking the "enter" button as an input.
				String name = cin.nextLine();
				System.out.println();
				System.out.print("enter student's address: ");
				String address = cin.nextLine();
				System.out.println();
				System.out.print("enter student's QUID: ");
				int id = cin.nextInt();
				System.out.println();
				System.out.print("enter student's GPA: ");
				double GPA = cin.nextDouble();
				System.out.println();
				t.insert(new Student(id, name, address, GPA));
				System.out.println();
				break;

			case 2:
				System.out.print("enter student's QUID: ");
				id = cin.nextInt();
				System.out.println();
				if (t.find(id) == null)
					System.out.println("this QUID " + id + " is invalid.");
				else
					System.out.println(t.find(id));
				System.out.println();
				break;

			case 3:
				System.out.print("enter the QUID of the student to be removed: ");
				id = cin.nextInt();
				System.out.println();
				if (t.remove(id))
					System.out.println("the student's record was successfully removed.");
				else
					System.out.println("this QUID " + id + " is invalid.");
				System.out.println();
				break;

			case 4:
				System.out.print("enter the year to display the records: ");
				int year = cin.nextInt();
				t.printStudent(year);
				System.out.println();
				break;
			case 5:
				t.printAll();
				System.out.println();
				break;
			case 6:
				System.out.print("enter GPA:");
				double gpa = cin.nextDouble();
				if (t.studentWithGPA(gpa).isEmpty())
					System.out.println("there are no students below this GPA: " + gpa + "\n");
				else
					for (Student student : t.belowGPA) {
						System.out.print(student.toString());
					}
				System.out.println();
				t.belowGPA.clear(); // belowGPA arraylist is static so needs to be cleared
				break;
			default:
				System.out.print("Invalid entry\n");
			} // end switch
		} // end while

	}

	static void save() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("yourFile.bin"));
			oos.writeObject(t);
			oos.close();
		} catch (Exception e) {
		}
	}

	public static void load() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("yourFile.bin"));
			t = (TreeTable) ois.readObject();
			ois.close();
		} catch (Exception e) {
		}
	}

}
