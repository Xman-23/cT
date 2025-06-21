package chapter_One_Phone;

import java.util.*;

public class PhoneBook {

	private Set<Person> person = null;

	public PhoneBook() {
		person = new HashSet<Person>();
	}

	public void addPerson(Person person) {
		this.person.add(person);
	}

	public Person search(PhoneNumber phoneNumber) {


		for(Person p : person) {
			int i=0;
			
			if(p.phoneNumberList.contains(phoneNumber)) {
				System.out.println(i+"번째 인덱스의 Person 반환");
				return p;
			}
		}
		return null;
	}


	public String toString() {

		String returnString = "PhoneBook {"
								+ "person = "
								+  person
								+ "}";

		return returnString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person("서동혁");
		person.phoneNumberAdd(new PhoneNumber("010-1234-5678"));
		person.phoneNumberAdd(new PhoneNumber("010-2345-6789"));
		person.phoneNumberAdd(new PhoneNumber("010-1234-5678"));
		person.phoneNumberAdd(new PhoneNumber("010-2345-6789"));
		System.out.println(person.phoneNumberList);
		
		Person personTwo = new Person("서유리");
		personTwo.phoneNumberAdd(new PhoneNumber("010-4564-1239"));
		System.out.println(person.phoneNumberList);
		/*
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.addPerson(person);
		System.out.println(phoneBook.person);
		System.out.println(phoneBook.person.get(0).name);
		phoneBook.person.get(0).phoneNumberList.get(1 ).phoneNumber;
		*/
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.addPerson(person);
		phoneBook.addPerson(personTwo);
		System.out.println(phoneBook);
		Person p = phoneBook.search(new PhoneNumber("010-1234-5678"));
		Person p2 = phoneBook.search(new PhoneNumber("010-4564-1239"));
		String name = p.name;
		String nameTwo = p2.name;
		List<PhoneNumber> list = new ArrayList<PhoneNumber>(p.phoneNumberList);
		List<PhoneNumber> listTwo = new ArrayList<PhoneNumber>(p2.phoneNumberList);
		System.out.println("name = " + name + " , list =" + list);
		System.out.println("name = " + nameTwo + " , list =" + listTwo);
		
	}

}
