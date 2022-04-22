package applicationn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class Loginuser
{
	Loginuser()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account number: ");
		int accno = sc.nextInt();
		
		System.out.println("Enter the Password: ");
		String pwd = sc.next();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Pass@123");
			
			PreparedStatement prst = con.prepareStatement("select * from specs where Acc_no = (?) and Password = (?)");
			prst.setInt(1, accno);
			prst.setString(2, pwd);
			ResultSet rs = prst.executeQuery();

			int flag = 0;
			while(rs.next())
			{
				if((accno == rs.getInt(1))&&(pwd.equals(rs.getString(6))))
				{
					flag = 1;
					System.out.println("Logged in");
//					break;
				}
			}
			
			if(flag == 0)
			{
				System.out.println("No such data found");
			}
			
			if(flag == 1)
			{
				System.out.println("1. Create details \n 2. Show balance \n 3. Transfer Amount \n");
				System.out.println("Select the option");
				int op = sc.nextInt();
				if(op == 1)
				{
					Cre c = new Cre();
				}
				else if(op == 2)
				{
					Balan bl = new Balan(); 
				}
				else if(op == 3)
				{
					Trans t = new Trans();
				}
			}
			
			sc.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class Registeruser
{
	Registeruser()
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
		
			con.close();
			System.out.println("Data added");
			
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}

	}
}

public class Jvalidation 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Select the choice: \n 1. Login \n 2. Register \n 3. Exit");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if(choice == 1)
		{
			Loginuser luser = new Loginuser();
		}
		else if(choice == 2)
		{
			Registeruser ruser = new Registeruser();
		}
		else if(choice == 3)
		{
			System.exit(0);
		}
		else
		{
			System.out.println("Enter a valid option!!");
		}
	}

}
