package range;

public class Range<T extends Comparable<T>> {
    private T start;
    private T end;

    private Range(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public T getStart() {
        return start;
    }
    public T getEnd() {
        return end;
    }

    public T getMin(T a, T b) {
        if(a.compareTo(b) <= 0) return a;
        else return b;
    }
    public T getMax(T a, T b) {
        if(a.compareTo(b) >= 0) return a;
        else return b;
    }

    public static <T extends Comparable<T>> Range<T> of(T start, T end) {

        // If start > end => swap (start, end)
        if(start.compareTo(end) > 0) {
            return of(end, start);
        }
        return new Range<T>(start, end);
    }

    public boolean contains(T value) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

    public boolean containsRange(Range<T> otherRange) {
        return contains(otherRange.getStart()) && contains(otherRange.getEnd());
    }

    public Range<T> merge(Range<T> otherRange) throws RangeException {
        if(contains(otherRange.getStart()) || contains(otherRange.getEnd())) {
            T newStart = getMin(start, otherRange.getStart());
            T newEnd = getMax(end, otherRange.getEnd());
            return new Range<T>(newStart, newEnd);
        }
        else {
            throw new RangeException("Ranges cannot be merged");
        }
    }

    public Range<T> intersection(Range<T> otherRange) throws RangeException {
        if(contains(otherRange.getStart()) || contains(otherRange.getEnd())) {
            T newStart = getMax(start, otherRange.getStart());
            T newEnd = getMin(end, otherRange.getEnd());
            return new Range<T>(newStart, newEnd);
        }
        else {
            throw new RangeException("Ranges cannot be merged");
        }
    }

    public T fit(T element) {
        if(contains(element)) return element;
        else if(start.compareTo(element) >= 0) return start;
        else return end;
    }

    public boolean equals(Range<T> otherRange) {
        return start.equals(otherRange.getStart()) && end.equals(otherRange.getEnd());
    }

    @Override
    public String toString() {
        return "[" + start.toString() + ", " + end.toString() + "]";
    }



}
