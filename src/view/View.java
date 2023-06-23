package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.Control;

public class View {
	
	public View() throws ClassNotFoundException, SQLException
	{
		menu();
	}
	Scanner sc=new Scanner(System.in);
	
	Control c= new Control();
	
	public void menu() throws ClassNotFoundException, SQLException
	{
		boolean loop=true;
		
		while(loop)
		{
		System.out.println("1.Insert");
		System.out.println("2.Show");
		System.out.println("3.Search");
		System.out.println("4.Delete");
		System.out.println("5.Update");
		System.out.println("0.Exit");
		
		System.out.print("Enter your choice : ");
		int ch=Integer.parseInt(sc.nextLine());
		
		switch(ch)
		{
		
		case 1:
			c.Insert();
			break;
			
		case 2:
			c.Show();
			break;
		case 3:
			c.Search();
			break;
		case 4:
			c.Delete();
			break;
		case 5:
			c.Update();
			break;
		case 0:
			loop=false;
			break;
		}
	}
}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
  new View();
	}

}
