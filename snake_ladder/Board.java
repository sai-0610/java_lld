import java.util.List;

public class Board {
    private int size;
    private Cell[] cells;

    public Board(int size, List<Jump> jumps) {
        this.size = size;
        cells = new Cell[size + 1]; // index 0 unused
        for (int i = 0; i <= size; i++) cells[i] = new Cell();

        for (Jump jump : jumps) cells[jump.getStart()].setJump(jump);
    }

    public int getSize() { return size; }
    public Cell getCell(int pos) { return cells[pos]; }
}
