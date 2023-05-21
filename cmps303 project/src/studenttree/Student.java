package studenttree;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private String address;
	private double GPA;
	private int year;

	public Student(int id, String name, String address, double gPA) {
		this.id = id;
		this.name = name;
		this.address = address;
		GPA = gPA;
	}

	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getGPA() {
		return GPA;
	}
	
	public int getYear() {
		return this.year = id/100000;
	}


	public  int getYear(int id) {
		return this.year = id/100000;
	}

	@Override
	public String toString() {
		return String.format("ID: %-10d|Name: %s |GPA: %.2f |Address: %s\n",
				id, name, GPA, address);
	}

}
