package noticeBoard;

public class NoticeBoardPersistence {
	
	public static void placeNotice(NoticeBoard noticeBoard, Notice notice) {
		if(noticeBoard.getSize() == noticeBoard.MAX_SIZE) {
			noticeBoard.removeOldestNotice();
		}
		
		noticeBoard.addNotice(notice);
	}
	
}
