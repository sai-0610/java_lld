public class Jump {
    private int start;
    private int end;

    public Jump(int start, int end) {
        if (start == end) throw new IllegalArgumentException("Jump must move between different positions");
        this.start = start;
        this.end = end;
    }

    public int getStart() { return start; }
    public int getEnd() { return end; }
}
