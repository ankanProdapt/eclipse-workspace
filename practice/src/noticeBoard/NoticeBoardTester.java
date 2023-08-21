package noticeBoard;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class NoticeBoardTester {
	private NoticeBoard board;
	private Notice notice1;
	private Notice notice2;
	private Notice notice3;
	private Notice notice4;
	private Notice notice5;
	private Notice notice6;
	private Notice notice7;
	
	
	@BeforeEach
	public void setUp() {
		board = new NoticeBoard();
		notice1 = new Notice("Title 1", "Content 1", "9457884482");
		notice2 = new Notice("Title 2", "Content 2", "9832021020");
		notice3 = new Notice("Title 3", "Content 3", "1728317283");
		notice4 = new Notice("Title 4", "Content 4", "9457884482");
		notice5 = new Notice("Title 5", "Content 5", "9832021020");
		notice6 = new Notice("Title 6", "Content 6", "1728317283");
		notice7 = new Notice("Title 7", "Content 6", "1728317283");
	}
	
	@Test
	public void testGetSize() {
		assertEquals(0, board.getSize());
		board.addNotice(notice1);
		assertEquals(1, board.getSize());
		board.addNotice(notice2);
		assertEquals(2, board.getSize());
	}
	
	@Test
	public void testToBePlacedAt() {
		assertEquals(0, board.toBePlacedAt());
		board.addNotice(notice1);
		assertEquals(1, board.toBePlacedAt());
		board.addNotice(notice2);
		assertEquals(2, board.toBePlacedAt());
	}
	
	@Test
	public void testAddNotice() {
		board.addNotice(notice1);
		assertTrue(board.toString().contains(notice1.toString()));
		board.addNotice(notice2);
		assertTrue(board.toString().contains(notice2.toString()));
		
	}
	
	@Test
	public void testRemoveOldestNotice() {
		board = new NoticeBoard();
		board.addNotice(notice1);
		board.addNotice(notice2);
		board.addNotice(notice3);
		board.addNotice(notice4);
		board.addNotice(notice5);
		board.addNotice(notice6);
		board.removeOldestNotice();
		board.addNotice(notice7);
		assertFalse(board.toString().contains(notice1.toString()));
	}
	
	@Test
	public void testNoticeBoardPersistence() {
		NoticeBoardPersistence NBP = new NoticeBoardPersistence();
		NoticeBoardPersistence.placeNotice(board, notice1);
		NoticeBoardPersistence.placeNotice(board, notice2);
		NoticeBoardPersistence.placeNotice(board, notice3);
		NoticeBoardPersistence.placeNotice(board, notice4);
		NoticeBoardPersistence.placeNotice(board, notice5);
		NoticeBoardPersistence.placeNotice(board, notice6);
		NoticeBoardPersistence.placeNotice(board, notice7);
	}
}

