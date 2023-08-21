package odometer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OdometerTest {
	private Odometer o;
	private int SIZE;
	
	@BeforeEach
	void setUp() {
		SIZE = 5;
		o = new Odometer(SIZE);
	}
	
	
	@Test
	void testGetSize() {
		assertEquals(SIZE, o.getSize());
	}
	
	@Test
	void testGetReading() {
		assertEquals(12345, o.getReading());
	}
	
	@Test
	void testGetMaxReading() {
		assertEquals(56789, Odometer.getMaxReading(SIZE));
		assertEquals(0, Odometer.getMaxReading(0));
	}
	
	@Test
	void testGetMinReading() {
		assertEquals(12345, Odometer.getMinReading(SIZE));
		assertEquals(0, Odometer.getMinReading(0));
	}
	
	@Test
	void testIncrementReading() {
		o.incrementReading();
		assertEquals(12346, o.getReading());
		o.setReading(56789);
		o.incrementReading();
		assertEquals(12345, o.getReading());
		o.setReading(36789);
		o.incrementReading();
		assertEquals(45678, o.getReading());
	}
	
	@Test
	void testDecrementReading() {
		o.decrementReading();
		assertEquals(56789, o.getReading());
		o.decrementReading();
		assertEquals(46789, o.getReading());
	}
	
	@Test
	void testToString() {
		assertEquals("12345", o.toString());
	}
	
	@Test
	void testInvalidCase() {
		new Odometer(10);
		new Odometer(0);
	}
}