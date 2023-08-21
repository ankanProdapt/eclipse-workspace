package noticeBoard;

public class Contact {
	public String name;
	public String phone;
	
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return String.format("{Contact: %s (%s)}", phone, name); 
	}
}
