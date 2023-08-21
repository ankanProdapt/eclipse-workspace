package tuples;

public class Main {
	public static Pair<Integer> mod(int divident, int divisor) {
		return new Pair<Integer>(new Integer[]{divident / divisor, divident % divisor});
	}
	
	public static boolean isDivisor(Pair<Integer> pair) {
		return pair.first() % pair.second() == 0;
	}
	
	public static void main(String[] args) {
		Integer[] a = {1, 2, 3};
		Tuple<Integer> t = new Tuple<Integer>(a);
		System.out.println(t);
		
		Pair<Integer> p = new Pair<Integer>(new Integer[]{1, 2});
		System.out.println(p);
		
		p.flip();
		System.out.println(p);
		
		System.out.println(p.first());
		System.out.println(p.second());
		
		Pawn[] pawns = {new Pawn("black", 1, "a"), new Pawn("white", 2, "b")};
		Tuple<Piece> pieceTuple = new Tuple<>(pawns);
		
		System.out.println(pieceTuple);
	}
}
