package noticeBoard;

public class Main {
	public static void main(String[] args) throws Exception{
		NoticeBoard noticeBoard;
		try {
			noticeBoard = NoticeBoardPersistence.load();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			NoticeBoardPersistence.updateLog("Something Went Wrong!!", null);
			noticeBoard = new NoticeBoard();
			e.printStackTrace();
		}
		
		Notice n1 = new Notice("N1", "KHSKD", "dnow", "194848");
		Notice n2 = new Notice("N2", "KHSKD", "dnow", "194848");
		Notice n3 = new Notice("N3", "KHSKD", "dnow", "194848");
		Notice n4 = new Notice("N4", "KHSKD", "dnow", "194848");
		Notice n5 = new Notice("N5", "KHSKD", "dnow", "194848");
		Notice n6 = new Notice("N6", "KHSKD", "dnow", "194848");
		Notice n7 = new Notice("N7", "KHSKD", "dnow", "194848");
		
		try {
			noticeBoard.addNotice(n1);
			noticeBoard.addNotice(n2);
			noticeBoard.addNotice(n3);
			noticeBoard.addNotice(n4);
			noticeBoard.addNotice(n5);
			noticeBoard.addNotice(n6);
			noticeBoard.addNotice(n7);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			NoticeBoardPersistence.updateLog("Something Went Wrong!!", null);
			noticeBoard = new NoticeBoard();
			e.printStackTrace();
		}
	}
}
