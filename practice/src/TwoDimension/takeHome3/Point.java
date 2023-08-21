package TwoDimension;

public class Point {
	private double x, y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	
	
	public double distanceFrom(Point p) {
		return Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
	}
	
	
	@Override
	public String toString() {
		return String.format("(%.2f, %.2f)", x, y);
	}
}