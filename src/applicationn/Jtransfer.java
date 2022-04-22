package applicationn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class Trans
{
	Trans()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Sender account no:");
		int sacc = sc.nextInt();
		
		System.out.println("Enter the Receiver account no:");
		int racc = sc.nextInt();
		
		System.out.println("Enter the amount to transfer");
		int amnt = sc.nextInt();
		

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Pass@123");
			
			PreparedStatement prst = con.prepareStatement("update specs set balance=balance-(?) where Acc_no=(?)");
			
			prst.setInt(1, amnt);
			prst.setInt(2, sacc);
			prst.executeUpdate();
			
			PreparedStatement prst1 = con.prepareStatement("update specs set balance=balance+(?) where Acc_no=(?)");
			
			prst1.setInt(1, amnt);
			prst1.setInt(2, racc);
			prst1.executeUpdate();
			
			sc.close();
			con.close();
			
			System.out.println("Amount transferred");
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}

	}
	
}

public class Jtransfer 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Trans t = new Trans();
	}

}
