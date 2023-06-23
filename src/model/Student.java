package model;

public class Student {
	
	private int roll;
	private String name;
	private String add;
	
	
	
	public Student(int roll, String name, String add) 
	{
		this.roll = roll;
		this.name = name;
		this.add = add;
	}



	public int getRoll() {
		return roll;
	}



	public void setRoll(int roll) {
		this.roll = roll;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAdd() {
		return add;
	}



	public void setAdd(String add) {
		this.add = add;
	}
	
	public String toString()
	{
		return roll+", "+name+", "+add;
	}

}
