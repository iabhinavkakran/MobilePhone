package com.abhinav;
import java.util.*;
public class MobilePhone {
	private String phoneCode;
	private ArrayList<Contact> myContact;
	public MobilePhone(String phoneCode) {
		this.phoneCode=phoneCode;
		this.myContact = new ArrayList<Contact>();
	}
	
public boolean  addnewContact(Contact contact){
	if(findContact(contact.getName()) >=0)
	{
		System.out.println("Contact already Exist.");
		return false;
	}
	myContact.add(contact);
	return true;
}

public boolean updateContact(Contact oldContact ,  Contact newContact) {
	int foundPosition=findContact(oldContact);
	if(foundPosition < 0)
	{
		System.out.println(oldContact.getName() +" , was not found.");
		return false;
	}
	this.myContact.set(foundPosition,newContact);
	System.out.println(oldContact.getName() +" , was update by "+"\"" +newContact.getName()+"\".");
	return true;
}

private int findContact(Contact contact) {
	return this.myContact.indexOf(contact);
}
	
private int findContact(String contactName ) {
	for(int i=0;i<this.myContact.size();i++) {
		Contact contact=this.myContact.get(i);
		if(contact.getName().equals(contactName))
			return i;
	}
	return -1;
 
  }

public String queryContact(Contact contact) {
	if(findContact(contact)>=0)
	{
		return contact.getName();
	}
	return null;
}

public Contact queryContact(String name) {
	int position = findContact(name);
	if(position >= 0)
	{
		return this.myContact.get(position);
	}
	else 
		return null;
}


public boolean removeContact(Contact contact) {
	int foundPosition=findContact(contact);
	if(foundPosition < 0)
	{
		System.out.println(contact.getName() +" , was not found");
		return false;
	}
  this.myContact.remove(foundPosition);
  System.out.println(contact.getName() +" , was Removed");
  return true;
 }

public void printContacts() {
	System.out.println("Contact List:");
	for(int i=0;i<this.myContact.size();i++) {
		System.out.println((i+1) + ". "+" Name : "+
				this.myContact.get(i).getName() +
				" , Phone Number : "+ 
				this.myContact.get(i).getPhoneNumber());
         }

  }



}
