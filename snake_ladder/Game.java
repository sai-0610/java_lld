import java.util.Queue;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Dice dice;
    private Queue<Player> players;

    public Game(Board board, Dice dice, java.util.List<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>(players);
    }

    public void start() {
        while (true) {
            Player current = players.poll();
            int roll = dice.roll();
            System.out.println(current.getName() + " rolled a " + roll);

            int nextPos = current.getPosition() + roll;
            if (nextPos > board.getSize()) nextPos = current.getPosition(); // stay if overshoot

            if (nextPos == board.getSize()) {
                System.out.println(current.getName() + " wins!");
                break;
            }

            Cell cell = board.getCell(nextPos);
            if (cell.getJump() != null) {
                int jumpEnd = cell.getJump().getEnd();
                String jumpType = (jumpEnd > nextPos) ? "ladder" : "snake";
                System.out.println(current.getName() + " took a " + jumpType + " from " + nextPos + " to " + jumpEnd);
                nextPos = jumpEnd;
            }

            current.setPosition(nextPos);
            System.out.println(current.getName() + " is now at position " + nextPos);
            players.offer(current);
        }
    }
}
