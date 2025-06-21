package chapter_One_Phone;

import java.util.*;

public class Person { 

	public String name = ""; //나의 전화번호부 이므로 내 이름 
	public Set<PhoneNumber> phoneNumberList = null; // 

	Person(String name) {
		this.name = name;
		phoneNumberList = new HashSet<PhoneNumber>();
	}

	public void phoneNumberAdd(PhoneNumber phoneNumber) {

		this.phoneNumberList.add(phoneNumber);

	}

	public void phoneNumberAdd(String phoneNumber) {

		this.phoneNumberList.add(new PhoneNumber(phoneNumber));
		
	}

	public String toString() {

		String returnString = "Person {" 
								+ "name = \"" + name +"\""
								+ ", phoneNumberList = " + phoneNumberList
								+ "}";

		return returnString;
	}
	public boolean hasPhoneNumber(PhoneNumber number) {
		return phoneNumberList.contains(number);
	}



	public static void main(String[] args) {
		Person person = new Person("서동혁");
		person.phoneNumberAdd(new PhoneNumber("01054577811"));
		//person.phoneNumberAdd(new PhoneNumber("010-1111-1111"));
		//person.phoneNumberAdd("010-2222-2222");
		System.out.println(person);
		
		//System.out.println(person.phoneNumberList.size());
		/*
		for(int i=0; i<person.phoneNumberList.size(); i++) {
			String string = person.phoneNumberList.get(i);
		}
		*/
		PhoneNumber phoneNumber = new PhoneNumber("01054577811");
		System.out.println(person.hasPhoneNumber(phoneNumber));
		System.out.println(new PhoneNumber("01054577811").hashCode());
	}
	//alt+Shift+s + H equals,hashCode()

}
