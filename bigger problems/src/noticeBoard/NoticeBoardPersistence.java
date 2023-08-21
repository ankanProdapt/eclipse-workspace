package noticeBoard;


import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class NoticeBoardPersistence {
	private static String FILE_NAME = "noticeBoard.txt";
	private static String LOG_FILE = "logFile.log";
	
	public static NoticeBoard load() throws Exception{
		List<String> textNotices = Files.readAllLines(Paths.get(FILE_NAME));
		List<Notice> notices = new ArrayList<>();
		
		for(String textNotice: textNotices) {
			String[] args = textNotice.split("###");
			notices.add(new Notice(args[0], args[1], args[2], args[3], args[4]));
		}
		
		
		
		return new NoticeBoard(notices);
	}
	
	public static void updateBoard(NoticeBoard noticeBoard) throws Exception {
		List<String> textNotices = new ArrayList<String>();
		
		for(Notice notice: noticeBoard.getNotices()) {
			textNotices.add(notice.text());
		}
		
		Path file = Paths.get(FILE_NAME);
		Files.write(file, textNotices);
	}
	
	public static void updateLog(String message, Notice notice) throws Exception{
		List<String> logTexts = Files.readAllLines(Paths.get(LOG_FILE));
		logTexts.add(LocalDateTime.now().toString());
		logTexts.add(message + notice.text() + "\n");
		
		Path file = Paths.get(LOG_FILE);
		Files.write(file, logTexts);
	}
}
