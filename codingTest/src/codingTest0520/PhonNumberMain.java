package codingTest0520;

public class PhonNumberMain {
	public static void main(String[] args) {
		PhoneNumber phoneNumber = new PhoneNumber("010 9391 7811");
		System.out.println(phoneNumber);
	}
}

class PhoneNumber {
	public String phoneNumber = "";

	PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumberCheck(phoneNumber); 
	}

	public String phoneNumberCheck(String phoneNumber) {

		String returnString  = phoneNumber.replaceAll("[^0-9]", "");

		return returnString;
	}

	@Override
	public String toString() {

		String returnString = "PhoneNumber { phoneNumber = \"" 
								+ phoneNumber +"\"}";

		return returnString;
	}

}
