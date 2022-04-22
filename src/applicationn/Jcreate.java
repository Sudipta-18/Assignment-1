package applicationn;

import java.sql.*;
import java.util.Scanner;

class Cre
{
	Cre()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Pass@123");
			
			PreparedStatement prst = con.prepareStatement("insert into specs values(?,?,?,?,?,?)");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the Account no:");
			int accno = sc.nextInt();
			
			System.out.println("Enter the Name:");
			String name = sc.next();
			
			System.out.println("Enter the IFSC code:");
			String ifsc = sc.next();
			
			System.out.println("Enter the Mobile no:");
			int mno = sc.nextInt();
			
			System.out.println("Enter the Balance:");
			int bal = sc.nextInt();
			
			System.out.println("Enter the Password:");
			String pwd = sc.next();
			
			sc.close();
			
			prst.setInt(1, accno);
			prst.setString(2, name);
			prst.setString(3, ifsc);
			prst.setInt(4, mno);
			prst.setInt(5, bal);
			prst.setString(6, pwd);
			prst.execute();
//			
			con.close();
			System.out.println("Data added");
			
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
	}
}

public class Jcreate 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Cre c = new Cre();
	}

}
