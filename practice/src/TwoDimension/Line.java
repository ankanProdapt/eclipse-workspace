package TwoDimension;

public class Line {
	private double m, c;
	
	Line(double newM, double newC){
		m = newM;
		c = newC;
	}
	
	
	public boolean isParallelTo(Line line) {
		return m == line.m;
	}
	
	
	public double distanceFrom(Point p) {
		double distance = Math.abs(m * p.getX() - p.getY() + c) / Math.sqrt(m * m + 1);
		return distance;
	}
	
	
	
	public Point intersection(Line line) {
		if(this.isParallelTo(line)) {
			System.out.println("Lines are parallel");
			return null;
		}
		
		double x = (-line.c + c) / (-m + line.m);
		double y = (line.m * c - m * line.c) / (-m + line.m);
		
		return new Point(x, y);
	}
	
	
	@Override
	public String toString() {
		return String.format("y = %.2fx + %.2f", m, c);
	}
	
}
