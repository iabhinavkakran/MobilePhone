package com.abhinav;
import java.util.*;

public class Main {
	public static Scanner scan =  new Scanner(System.in);
	public static MobilePhone mobilePhone = new MobilePhone("+91");
    public static void main(String[] args) {
    	
    	
    	boolean quit=false;
    	startPhone();
    	printAction();
    	while(!quit) {
    		System.out.println("\nEnter Action : (Press 0 to show available Action)");
    		int n=scan.nextInt();
    		scan.nextLine();//for input buffer
    		
    		
    		switch(n)
    		{
    		case 0 : 
    			     printAction();
    			     break;
    		
    		case 1 : 
    			     printContact();
    		         break;
    		         
    		case 2 : 
			         addNewContact();
		             break;
    		
    		case 3 : 
			         updateContact();
		             break;
		         
    		case 4 : 
			         removeContact();
		             break;
		         
    		case 5 : 
			         searchContact();
		             break;
    		
    		case 6 : 
    			     System.out.println("Shuting Down the Mobile Phone. ");
    		         quit=true;
    		         break;
    		         
    			
    		}
    	}
		
	}
    
    public static void printContact() {
    	mobilePhone.printContacts();
    }
    
    public static void addNewContact() {
    	System.out.println("Enter Name:");
    	String name = scan.nextLine();
    	System.out.println("Enter Phone Number:");
    	String phoneNumber = scan.nextLine();
    	Contact newContact = Contact.newContact(name, phoneNumber);
    	if(mobilePhone.addnewContact(newContact)) {
    		System.out.println("New Contact Added");
    	}
    	else {
    		System.out.println("Can not add "+ name +" already in Contact List.");
    	}

    }
    
    public static void updateContact() {
    	System.out.println("Enter Name:");
    	String name = scan.nextLine();
    	Contact existingContactRecord = mobilePhone.queryContact(name);
    	if(existingContactRecord==null) {
    		System.out.println("Contact Not Found");
    		return;
    	}
    	
    		System.out.println("Enter Name:");
        	String newName = scan.nextLine();
        	System.out.println("Enter Phone Number:");
        	String newPhoneNumber = scan.nextLine();
        	Contact newContact= Contact.newContact(newName, newPhoneNumber);
        	if(mobilePhone.updateContact(existingContactRecord, newContact))
        	{
        		System.out.println("Updated Successfully.");
        	}
        	else {
        		System.out.println("Error in Updation.");
        	}
    	
    }
      
    public static void removeContact() {
    	System.out.println("Enter Name:");
    	String name = scan.nextLine();
    	Contact existingContactRecord = mobilePhone.queryContact(name);
    	if(existingContactRecord==null) {
    		System.out.println("Contact Not Found");
    		return;
    	}
    	if(mobilePhone.removeContact(existingContactRecord))
    	{
    		System.out.println("Contact Successfully Removed.");
    	}
    	else {
    		System.out.println("Error in Removing Contact.");
    	}
    	
    }
    
    public static void searchContact() {
    	System.out.println("Enter Name:");
    	String name = scan.nextLine();
    	Contact existingContactRecord = mobilePhone.queryContact(name);
    	if(existingContactRecord==null) {
    		System.out.println("Contact Not Found");
    		return;
    	}
    	System.out.print("Name :"+existingContactRecord.getName()+
    			" , Phone:"+existingContactRecord.getPhoneNumber());
    }
  
    public static void startPhone() {
    	System.out.println("Starting Phone....");
    }
    public static void printAction() {
		System.out.println("Press 1 to Print Contact List. ");
		System.out.println("Press 2 to Add New Contact. ");
		System.out.println("Press 3 to Update Existing Contact. ");
		System.out.println("Press 4 to Remove Contact. ");
		System.out.println("Press 5 to Search Contact. ");
		System.out.println("Press 6 to Shutdown. ");
		System.out.println("Press 0 to see list of available Actions.");
    }

}
