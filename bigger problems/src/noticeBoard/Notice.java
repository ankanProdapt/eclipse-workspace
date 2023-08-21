package noticeBoard;

import java.time.LocalDateTime;


public class Notice {
	private String title;
	private String content;
	private Contact contact;
	private LocalDateTime creationTime;
	
	public Notice(String title, String content, String name, String phone) {
		this.title = title;
		this.content = content;
		this.contact = new Contact(name, phone);
		this.creationTime = LocalDateTime.now();
	}
	
	public Notice(String title, String content, String name, String phone, String timeText) {
		this.title = title;
		this.content = content;
		this.contact = new Contact(name, phone);
		this.creationTime = LocalDateTime.parse(timeText);
	}
	
	
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getContact() {
		return contact.toString();
	}
	
	public String text() {
		return title + "###" + content + "###" + contact.name + "###" + contact.phone + "###" + creationTime.toString(); 
	}
	
	
	@Override
	public String toString() {
		String noticeText = "Title: " + title + "\n" +
							"Content: " + content + "\n" +
							contact + "\n";
		
		return noticeText;
	}
	
	
}
