package studenttree;

import java.io.Serializable;
import java.util.ArrayList;

public class TreeTable implements Serializable {

	Tree[] table = new Tree[20];
	static ArrayList<Student> belowGPA = new ArrayList<>();

	public TreeTable() {
		for (int i = 0; i < 20; i++) {// initializes trees to the array
			table[i] = new Tree();
		}
	}

	//assumes the id consists of 9 numbers
	public int hashFunction(int year) {
		return year % 20;
	}
	
	//checks if the id and gpa are within the range
	//checks if the name and the address are not empty or spaces (using stringIsEmpty(String ) done at the end of the class)
	//if all good then calls the tree's "insert" function
	public void insert(Student s) {

			if (s.getId()<200000000 || s.getId() > 201915999) {
				System.out.println("this id : " + s.getId() + " is not valid ");
				return;
			}
			else if (stringIsEmpty(s.getName())) {
				System.out.println("you did not enter a name ");
				return;
			}
			else if (stringIsEmpty(s.getAddress())) {
				System.out.println("you did not enter an address ");
				return;
			}
			else if (s.getGPA() < 0 || s.getGPA() > 4) {
				System.out.println("this GPA : " + s.getGPA() + " is invalid ");
			System.out.println("Student record was not added\n");
			return;
			}
		
		table[hashFunction(s.getYear())].insert(s.getId(), s);
		
	}
	
	//checks if the id is within the range
	//if yes then checks the if the record of that year is not empty
	//if both true then calls the tree's "find" function
	public Student find(int id) {
		if (200000000 > id || id > 201915999)
			return null;
		if (!table[hashFunction(id / 100000)].isEmpty())
			return table[hashFunction(id / 100000)].find(id).getStudent();
		return null;
	}

	//checks if the record of the recieved year is not empty
	//if yes then calls the tree's "delete(int )" function
	public boolean remove(int id) {
		if (!table[hashFunction(id / 100000)].isEmpty())
			return table[hashFunction(id / 100000)].delete(id);
		return false;
	}
	

	//checks if the recieved year is within the range
	//if yes then checks if the record of that year is not empty
	//if both good then calls the tree's "inOrder(Node )" function
	public void printStudent(int year) {
		if (2000 > year || year > 2019) {
			System.out.println("this year : " + year + " is invalid ");
			return;
		}
		if (table[hashFunction(year)].isEmpty()) {
			System.out.println("No Student record available for " + year);
			return;
		}
		table[hashFunction(year)].inOrder(table[hashFunction(year)].getRoot());
	}
	

	//for each index between 0 and 19 checks if the record is empty 
	//if so then continues to the next iteration
	//else prints the record of that year using preOrder approach 
	public void printAll() {
		for (int i = 0; i < 20; i++) {
			if (table[i].isEmpty()) {
				System.out.println("No Student record available for " + (i + 2000));
				System.out.println("========================================================================");
				continue;
			}
			table[i].preOrder(table[i].getRoot());
			System.out.println("========================================================================");
		}
		System.out.println();
	}

	//for each tree calls inOrderSearchBelowGPA function
	//and returns the static belowGPA arraylist of students
	public ArrayList<Student> studentWithGPA(Double GPA) {

		for (int i = 0; i < 20; i++) {
			table[i].inOrderSearchBelowGPA(table[i].getRoot(), GPA);
		}
		return belowGPA;
	}

	//checks if the recieved string is empty or contains only spaces
	//if yes then returns true
	//otherwise returns false
	public boolean stringIsEmpty(String s) {
		if (s.isEmpty())
			return true;
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != ' ')
				return false;
		}
		return true;
	}
}