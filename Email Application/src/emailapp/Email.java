package emailapp;
import java.io.*;
import java.util.Scanner;

public class Email {
	
	private String firstname;
	private String lastname;
	private String department;
	private int mailBoxCapacity= 500;
	private String password;
	private String alternateEmail;
	private String email;
	private int defaultPassLength = 10;
	private String companySuffix = "xyzcompany.com";
	
	//getter and setters
	public String getName()
	{
		return firstname+ lastname;		
	}
	public int getCapacity()
	{
		return mailBoxCapacity;		
	}
	public String getAlternateEmail()
	{
		return alternateEmail;		
	}
	public String getPassword()
	{
		return password;		
	}	
	public void setCapacity(int capacity)
	{
		mailBoxCapacity = capacity;		
	}
	public void setAltEmail(String altemail)
	{
		alternateEmail = altemail;		
	}
	public void setPassword(String pass)
	{
		password = pass;		
	}
	
	
	//constructor to receive first name n last name
	public Email( String firstname, String lastname)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		
		//ask for department from user to set the department
		this.department = setDepartment();
		
		//call randomPassword method to generate random password;
		this.password = randomPassword(defaultPassLength);
		System.out.println("Your temporary Password: "+ this.password);
		
		email = firstname.toLowerCase()+ "."+ lastname.toLowerCase()+"@"+ department.toLowerCase()+"."+ companySuffix;
		
		
	}	
	
	
	//ask for department
	
	private String setDepartment()
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("New Employee:"+ firstname+" \nDepartment Codes:\n1.Sales\n2.Development\n3.Accounting\nEnter your code:");
		int code = cin.nextInt();
		if( code == 1)
			return "Sales";
		else if(code == 2)
			return "Dev";
		else if(code == 3)
			return "Accounting";
		else
			return "";
		
	}
	
	private String randomPassword(int length)
	{
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$*%abcdefghijklmnopqustuvwxyz";
		char c[] = new char[length];
		for(int i=0; i< c.length; i++)
		{
			int ran = (int)(Math.random() * passwordSet.length());
			c[i] = passwordSet.charAt(ran);
			
		}
		
		return new String(c);		
	}
	
	public void showInfo()
	{
		System.out.println("Name :"+ firstname+" "+lastname);
		System.out.println("Email :"+ email);
		System.out.println("Mail Box Capacity"+ mailBoxCapacity+ "mb");
	}
	
}
