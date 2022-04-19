package com.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.empolyee.Database;

public class CustomerFunction {
	 int customer_id;
	 public int customer_status;
	 int amount;
	Customer c=new Customer();
	Scanner s = new Scanner(System.in);
	public  int insertCustomer() {    //Register the Customer
		
		int no=0;
		System.out.println("Enter the customer ID:");
		c.setId(s.nextInt());
		s.nextLine();
		System.out.println("Enter the customer  name");
		c.setFname(s.nextLine());
		System.out.println("Enter the addhar Number");
		c.setAddharNumber(s.nextInt());
		System.out.println("Enter the Amount");
		c.setAmount(s.nextInt());
		System.out.println("Set the Username");
		s.nextLine();
		c.setUserName(s.nextLine());
		System.out.println("Set the Password");
		c.setPass(s.nextInt());
		
		// ********JDBC Code Starts here***********

		try {
			
			Statement stmt = Database.createDbConnection().createStatement();
			 no = stmt.executeUpdate("insert into customer values(" + c.getId() + ",'" + c.getFname() + "' ,"+c.getAddharNumber()+",'"+c.getUserName()+"',"+c.getPass()+","+c.getAmount()+")");
			

		} // ********JDBC Code Ends here***********
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return no;
	}
	
	
		public  boolean getLogin()      //Login into the customer
	{
		System.out.println("Enter the Username:");
		c.setUserName(s.nextLine());
		System.out.println("Enter the Password");
		c.setPass(s.nextInt());
		boolean status=false;
			try {
			
			Statement stmt = Database.createDbConnection().createStatement();	
			ResultSet rs = stmt.executeQuery("select * from customer");
			while(rs.next())
			{	if(rs.getString("username").equals("") || rs.getString("password").equals(""))
				{
					System.out.println("Input the dteails");
				}
				else if(rs.getString("username").equals(c.getUserName())&&rs.getInt("password")==c.getPass())
				{
				    customer_id=rs.getInt("id");
				    customer_status=rs.getInt("status");
				    amount=rs.getInt("amount");
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
		
		public  void  getCustomer(){       //Details of the customer
			  try {	
						Statement stmt = Database.createDbConnection().createStatement();	
						ResultSet rs = stmt.executeQuery("select * from customer where id="+customer_id+"");
							while(rs.next())
							{
								System.out.println("Accountholder UserName-"+rs.getString("username"));
								System.out.println("Accountholder name : "+rs.getString("name"));
							    System.out.println("Accountholder addharnumber : "+rs.getString("aadharnumber"));
							    System.out.println("Accountholder balance:"+rs.getInt("amount"));

							}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}

		 public  int depositMoney() {
			int intialAmount=amount;
			int no=0;
			System.out.println("Enter the Money to deposit:");
			int deposit=s.nextInt();
			if(deposit<0)
			{
				System.out.println("Negative Money!");
			}
			else
			{
				deposit=intialAmount+deposit;
				try {
					
					java.sql.Statement stmt = Database.createDbConnection().createStatement();
					 no = stmt.executeUpdate("update customer  set amount="+deposit+" where id="+customer_id+"");

				} // ********JDBC Code Ends here***********
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			    
				return no;
				
			
		}
		public  int withdrawAmount(int withdrawAmount) {   //Withdraw the amount from the Customer
			int no=0;
			int newAmount=amount-withdrawAmount;
			if(amount<0 || withdrawAmount>amount)
			{
				System.out.println("Insufficant Balance");
			}
			
				
				try {
					
					java.sql.Statement stmt = Database.createDbConnection().createStatement();
					 no = stmt.executeUpdate("update customer  set amount="+newAmount+" where id="+customer_id+"");

				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			    
				return no;
		}
		
			public  void viewCustomer()     //View the Customer
		    {
			
				  try {	
							Statement stmt = Database.createDbConnection().createStatement();	
							ResultSet rs = stmt.executeQuery("select * from customer ");
								while(rs.next())
								{
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
		  
			public  int transferDepositMoney()
		    {
			int no=0;
			System.out.println("Enter the Customer id");
			int customerId = s.nextInt();
			System.out.println("Enter the Money to Transferd:");
			int deposit=s.nextInt();
			int balance = 0;
			int withdraw=deposit;
			if(deposit<0)
			{
				System.out.println("Negative Money!");
			}
			else
			{
				
				try {
					
					java.sql.Statement stmt = Database.createDbConnection().createStatement();
					ResultSet rs = stmt.executeQuery("select * from customer where id="+customerId+"");
					while(rs.next())
					{
						balance=rs.getInt("amount");
					}
					deposit+=balance;
					withdraw-=amount;
					 no = stmt.executeUpdate("update customer  set amount="+deposit+" where id="+customerId+"");
					 no = stmt.executeUpdate("update customer  set amount="+withdraw+" where id="+customer_id+"");
				} // ********JDBC Code Ends here***********
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			    
				return no;

		}



}
