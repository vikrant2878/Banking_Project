package com.empolyee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Empolyee {
	 static int empolyee_id;
	 Scanner sc = new Scanner(System.in);
	public boolean getEmpolyeeLogin()     //Employee Login
	{
		
		System.out.println("Enter the Empolyename:");
		String name=sc.next();
		System.out.println("Enter the Password");
		String pass=sc.next();
		boolean status=false;
			try {
			
			Statement stmt = Database.createDbConnection().createStatement();	
			ResultSet rs = stmt.executeQuery("select * from empolyee");
			while(rs.next())
			{	if(rs.getString("name").equals("") || rs.getString("password").equals(""))
				{
					System.out.println("Input the dteails");
				}
				else if(rs.getString("name").equals(name)&&rs.getString("password").equals(pass))
				{
				    empolyee_id=rs.getInt("id");
					status =true;
					break;
				}
			
			}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
			
			
	}
	public  int approveAndRejetion()   //Approve or rejection the customer
	{
		int cId,no = 0;
		System.out.println("Enter the customer_id");
		int status=1;
		cId=sc.nextInt();
		try {
			
			java.sql.Statement stmt = Database.createDbConnection().createStatement();
			 no = stmt.executeUpdate("update customer  set status="+status+" where id ="+cId+"");

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return no;	
		
	}
	public  void viewCustomerForEmpolyee()     //View the customer regarding the employee
	{
		
			  try {	
						Statement stmt = Database.createDbConnection().createStatement();	
						ResultSet rs = stmt.executeQuery("select * from customer ");
							while(rs.next())
							{
								System.out.println("Accountholder Status"+rs.getInt("status"));
								System.out.println("Accountholder Id-"+rs.getInt("id"));
								System.out.println("Accountholder UserName-"+rs.getString("username"));
								System.out.println("Accountholder name : "+rs.getString("name"));
							    System.out.println("Accountholder addharnumber : "+rs.getString("aadharnumber"));
							    System.out.println("Accountholder balance:"+rs.getInt("amount"));
							    System.out.println("--------------------------------------------------------------------------------");

							}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}



}
