package noticeBoard;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoard {
	private List<Notice> notices;
	private int CAPACITY = 6;
	
	public NoticeBoard() {
		this.notices = new ArrayList<Notice>();
	}
	
	public NoticeBoard(List<Notice> notices) {
		this.notices = notices;
	}
	
	public List<Notice> getNotices() {
		return notices;
	}
	
	public void removeOldest() {
		Notice oldestNotice = notices.get(0);
		for(Notice notice: notices) {
			if(oldestNotice.getCreationTime().isAfter(notice.getCreationTime())) {
				oldestNotice = notice;
			}
		}
		
		notices.remove(oldestNotice);
	}
	
	public void addNotice(Notice notice) throws Exception{
		if(notices.size() == CAPACITY) {
			removeOldest();
			NoticeBoardPersistence.updateLog("Replaced oldest notice with: ", notice);
		}
		else {
			NoticeBoardPersistence.updateLog("Added: ", notice);
		}
		notices.add(notice);
		NoticeBoardPersistence.updateBoard(this);
	}
	
	@Override
	public String toString() {
		String board = "NOTICE BOARD: \n\n";
		for(Notice notice: notices) {
			board += notice.toString() + "\n";
		}
		return board;
	}
	
}
