package range;

public class Tester {
    public static void main(String[] args){
        Range<Integer> intRange = Range.of(10, 30);

        System.out.println(intRange);

        System.out.println(intRange.contains(0));
        System.out.println(intRange.contains(10));
        System.out.println(intRange.contains(20));
        System.out.println(intRange.contains(30));
        System.out.println(intRange.contains(40));

        Range<Integer> newIntRange = Range.of(0, 5);
        System.out.println(newIntRange);
        try {
            System.out.println(intRange.merge(newIntRange));
            System.out.println(intRange.intersection(newIntRange));
        } catch (RangeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        newIntRange = Range.of(25, 50);
        System.out.println(newIntRange);
        try {
            System.out.println(intRange.merge(newIntRange));
            System.out.println(intRange.intersection(newIntRange));
        } catch (RangeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        newIntRange = Range.of(15, 20);
        System.out.println(intRange.containsRange(newIntRange));

        System.out.println(intRange);
        System.out.println(intRange.fit(20));
        System.out.println(intRange.fit(0));
        System.out.println(intRange.fit(100));
    }
}
