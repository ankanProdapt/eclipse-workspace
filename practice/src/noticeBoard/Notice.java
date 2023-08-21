package noticeBoard;

public class Notice {
	private String title;
	private String content;
	private String contact;
	
	public Notice(String title, String content, String contact) {
		this.title = title;
		this.content = content;
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return String.format("Title: %s\nContent: %s\nContact: %s\n\n", title, content, contact);
	}
}
