package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

import model.Student;

public class Control {

	List<Student> c = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);

	static Connection Connect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/collection", uname = "root", pass = "abc123";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);

		return con;
	}

	int n = 0;

	public void Insert() throws ClassNotFoundException, SQLException {
		try
		{
		System.out.print("Enter the number of student : ");
		n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.print("Enter your Roll No :  ");
			int roll = Integer.parseInt(sc.nextLine());
			System.out.print("Enter your Name : ");
			String name = sc.nextLine();
			System.out.print("Enter your Address : ");
			String add = sc.nextLine();
			System.out.println(".......................................|");
			c.add(new Student(roll, name, add));

			Connection c = Control.Connect();
			Statement st = c.createStatement();

			st.executeUpdate("INSERT INTO c1 VALUES(" + roll + ",'" + name + "','" + add + "')");

		}
		}
		catch(Exception e)		
		{
			System.out.println(e);
		}

		}

	public void Show() throws SQLException, ClassNotFoundException {
		try{
		Iterator<Student> i = c.iterator();
		Connection c = Control.Connect();
		Statement s = c.createStatement();

		while (i.hasNext()) {
			Student st = i.next();
			System.out.println(st);
		}
		ResultSet rs = s.executeQuery("select * from c1");
		while (rs.next()) {
			System.out
					.println("Roll :" + rs.getInt(1) + ",  Name :" + rs.getString(2) + ", Address :" + rs.getString(3));
			System.out.println(".......................................|");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void Search() throws SQLException, ClassNotFoundException {
		try 
		{
		boolean found = false;

		System.out.print("Enter Roll No : ");
		int roll = Integer.parseInt(sc.nextLine());

		Iterator<Student> i = c.iterator();

		while (i.hasNext()) {
			Student st = i.next();

			if (st.getRoll() == roll) {
				System.out.println(st);
				System.out.println(".......................................|");
				found = true;
			}
		}

		Connection c4 = Control.Connect();
		Statement st4 = c4.createStatement();

		ResultSet rs = st4.executeQuery("Select* from c1 where roll=" + roll + "");
		// rs.absolute(0);
		while (rs.next()) {
			System.out
					.println("Roll : " + rs.getInt(1) + " ,Name :" + rs.getString(2) + ", Address:" + rs.getString(3));
			found = true;
		}
		if (!found) {
			System.out.println("Student not found ~ ");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void Delete() throws SQLException, ClassNotFoundException {
		
		try{
		boolean found = false;

		System.out.print("Enter Roll No : ");
		int roll = Integer.parseInt(sc.nextLine());

		Iterator<Student> i = c.iterator();

		while (i.hasNext()) {
			Student st = i.next();

			if (st.getRoll() == roll) {

				i.remove();
				System.out.println("DATA-DELETE");
				found = true;
			}
			
		}

		Connection c4 = Control.Connect();
		Statement st4 = c4.createStatement();

		int c = st4.executeUpdate("delete from c1 where roll=" + roll + "");
		if (c > 0) {
			System.out.println("delete date succsfully..");
		} else {
			System.out.println("your data not delete");
		}
		System.out.println("......................................................|");
	}
		
	catch(Exception e)
		{
		System.out.println(e);
		}
	}
	public void Update() throws SQLException, ClassNotFoundException {
		try{
		System.out.println("Enter the roll no");
		int roll = Integer.parseInt(sc.nextLine());

		Connection con = Control.Connect();
		Statement st = con.createStatement();
	
		System.out.println("1.Name");
		System.out.println("2.Address");

		System.out.println("Enter your choice : ");
		int ch = Integer.parseInt(sc.nextLine());

		switch (ch) {
		case 1:
			ResultSet rs=st.executeQuery("select * from c1 where roll="+roll+"");
			while(rs.next())
			{
				
				System.out.println("Old Name : "+rs.getString(2));
			}
			
			System.out.println("Enter new name : ");
			String n = sc.nextLine();

			int c = st.executeUpdate("update c1 set name='" + n + "'where roll=" + roll + "");
			if (c > 0) {
				System.out.println("Update Name");
				System.out.println("......................................................|");
			}
			break;
		case 2:
			ResultSet rs1=st.executeQuery("select * from c1 where roll="+roll+"");
			while(rs1.next())
			{
				
				System.out.println("Old Address : "+rs1.getString(3));
			}
			
			System.out.println("Enter new Address : ");
			String a = sc.nextLine();

			int b = st.executeUpdate("update c1 set address='" + a + "'where roll=" + roll + "");
			if (b > 0) {
				System.out.println("Update Address");
				System.out.println("......................................................|");
			}
			break;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
