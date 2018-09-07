package com.corejava.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TrueCaller {
	
	Map<Long, Person> trueCaller = new HashMap<>();
	
	public TrueCaller() {}

	public void addContact(Person person) {
		trueCaller.put(person.getPhoneNumber(), person);
	}
	
	public Person lookup(long phoneNumber) {
		return trueCaller.get(phoneNumber);
	}
	
	public void listAllContacts() {
		for(Map.Entry<Long, Person> entry: trueCaller.entrySet()) {
			System.out.println("Phone number: " + entry.getKey() + " => " + entry.getValue());
		}
	}

	public Person deleteContact(long phoneNumber) {
		return trueCaller.remove(phoneNumber);	
	}
	
	public static void main(String[] args) {
		TrueCaller tc = new TrueCaller();
		Person p1 = new Person("Robert", "Sedgewick", 9984567342L);
		Person p2 = new Person("Alfred", "Aho", 7045342889L);
		Person p3 = new Person("Donald", "Knuth", 8087654232L);
		
		// Add contacts
		tc.addContact(p1);
		tc.addContact(p2);
		tc.addContact(p3);
		
		// List all contacts
		System.out.println("Listing all the contacts...");
		tc.listAllContacts();
		System.out.println();
		
		// Lookup a phone number
		System.out.println(9984567342L + " phone number belongs to " + tc.lookup(9984567342L));
		System.out.println();

		// Delete a contact
		System.out.println("Deleting the contact with phone number 7045342889L" + tc.deleteContact(7045342889L));
		System.out.println();

		// List all contacts
		System.out.println("Listing all the contacts post deletion...");
		tc.listAllContacts();		
	}

}


// Observe how "equals()", "hashCode()", and "toString()" methods are implemented
class Person{
	private String firstName;
	private String lastName;
	
	private long phoneNumber;
	
	public Person(String firstName, String lastName, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	// Getters and Setters for various attributes
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object otherObject) {
		if(this == otherObject) return true;
		if(otherObject == null) return false;
		if(!(otherObject instanceof Person)) return false;
		Person other = (Person) otherObject;
		return this.phoneNumber == other.phoneNumber;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, phoneNumber);
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
	}	
	
}
