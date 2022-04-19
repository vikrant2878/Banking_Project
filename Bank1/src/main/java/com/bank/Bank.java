package com.bank;
import java.util.Scanner;

import com.customer.CustomerFunction;
import com.empolyee.Empolyee;

public class Bank {
	public static void main(String[] args) {
		CustomerFunction cf=new CustomerFunction();
		Empolyee e=new Empolyee();
		Scanner s=new Scanner(System.in);
		int choice;
		System.out.println(" -----------Welcome in the Vikrant Bank---------  ");
		System.out.println("1.Customer");
		System.out.println("2.Empolyee");
		System.out.println("3.Exit");
		choice=s.nextInt();
		s.nextLine();
		switch(choice)
		{
		case 1:
		outer:do{
			
			   
			   System.out.println("1.New Account");
			   System.out.println("2.Login");
			   System.out.println("3.Exit");
			   choice=s.nextInt();
				switch(choice)
				{
				case 1: if(cf.insertCustomer()!=0)
				{
					System.out.println("record Successfully");
				}else {
					System.out.println("Unsuccessful");
				}
					
				break;
				case 2:
					if(cf.getLogin()) {
						if(cf.customer_status==1)
						{
					while(true)
					{
					System.out.println("\n-------------------");
					System.out.println("W  E  L  C  O  M  E");
					System.out.println("-------------------\n");
					System.out.println("1. Deposit.");
					System.out.println("2. Withdraw.");
					System.out.println("3. User information.");
					System.out.println("4.Transfer Money");
					System.out.println("5. Log out.");
					System.out.print("\nEnter your choice : ");
					choice = s.nextInt();
					s.nextLine();
					switch(choice)
					{
					case 1: if(cf.depositMoney()!=0)
					{
						System.out.println("Money is depoist");
					}
					else
					{
						System.out.println("no");
					}
					break;
					case 2: System.out.println("Enter the Amount want to withdraw:");
					    	int withdrwAmount=s.nextInt();
					    	if(withdrwAmount<0)
					    	{
					    		System.out.println("Negative Amount");
					    	}
					    	else if(withdrwAmount==0 && withdrwAmount<500)
					    	{
					    		System.out.println("Amount is greater than the Zero and small than 500");
					    	}
					    	else
					    	{
					    		if(cf.withdrawAmount(withdrwAmount)!=0)
					    		{
					    			System.out.println("Amount is withdraw");
					    		}
					    		
					    	}
					    break;
					case 3: cf.getCustomer();
						break;
					case 4:  if(cf.transferDepositMoney()!=0) {
						System.out.println("Money is transfered");
					}
					else {
						System.out.println("Money is not transfered! Error");
					}
					
					case 5: continue outer;
					default:
						System.out.println("Wrong Choice");
						
					}

				   }
				}else {
					System.out.println("Approvel not done! Pleaase Contact with the bank");
				}
				}
				case 3:System.out.println(" Wrong password!!!!!   Thank you");
						System.exit(0);
				
		       default:
				       System.out.println("Wrong choice");
				
		        }
		 }while(true);
		case 2:
				 if(e.getEmpolyeeLogin())
				 {
					 while(true) {
					 System.out.println("\n-------------------");
						System.out.println("W  E  L  C  O  M  E");
						System.out.println("-------------------\n");
						System.out.println("1. Approve and Rejection");
						System.out.println("2.View.");
						System.out.println("3.Register for customer Account.");
						System.out.println("4. Log out.");
						choice = s.nextInt();
						s.nextLine();
						switch(choice)
						{
						case 1: e.viewCustomerForEmpolyee();
							
								if(e.approveAndRejetion()==1)
								{
									System.out.println("Approved");
								}
								else {
									System.out.println("Not Approved");
								}
							break;
						case 2:
								e.viewCustomerForEmpolyee();
								break;
						case 3: if(cf.insertCustomer()!=0)
						{
							System.out.println("record Successfully");
						}
						else {
							System.out.println("Unsuccessful");
						}
						break;
						case 4:System.out.println("Thank you");
						        System.exit(0);
						        break;
						default:
						    	System.out.println("Wrong Choice");
						}
				 }
				 }else {
					 System.out.println("Credential is wrong");
				 }
				 break;
		 default:
					System.out.println("Wrong Choice");
					
		
		}	
	}
}
