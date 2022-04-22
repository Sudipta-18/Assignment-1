package applicationn;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class Balan
{
	Balan()
	{	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Account no:");
		int accno = sc.nextInt();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Pass@123");
			
			PreparedStatement prst = con.prepareStatement("select * from specs where Acc_no = (?)");
			prst.setInt(1, accno);
			ResultSet rs = prst.executeQuery();
//			PrintWriter out = response.getWriter();
			
			while(rs.next())
			{
				System.out.println("BALANCE: "+rs.getInt(5));
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

public class Jbalance 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Balan bl = new Balan();

	}

}
