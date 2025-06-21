package chapter_One_Phone;

import java.util.Objects;

public class PhoneNumber {
	public String phoneNumber = "";

	PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumberCheck(phoneNumber);
	}

	public String phoneNumberCheck(String phoneNumber) {

		String returnString = phoneNumber.replaceAll("[^0-9]", "");

		return returnString;
	}

	@Override
	public String toString() {

		String returnString = "PhoneNumber { phoneNumber = \"" + phoneNumber + "\"}";

		return returnString;
	}

	//
	
	// @Override 
	// public boolean equals(Object o) { //같은 주소인지를 비교
	 
	//	 if(this == o ) { return true; }
	 
	//	 if(!(o instanceof PhoneNumber)) { return false; }
	 
	 
	//	 PhoneNumber other = (PhoneNumber) o;
	 
	//	 return this.phoneNumber.equals(other.phoneNumber); }
	 
	 //@Override 
	// public int hashCode() { //문자열이 서로 같다면은 문자열 자체의 해시값도 같으므로 //equals메서드 와 함께 완전하게 값은 값을 증명할 수 있다. //그것이 바로 hashCode()이다 return
	//	 phoneNumber.hashCode(); 
	// }
	 

	public static void main(String[] args) {
		PhoneNumber phoneNumber = new PhoneNumber("010 9391 7811");
		System.out.println(phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		return Objects.equals(phoneNumber, other.phoneNumber);
	}
}
