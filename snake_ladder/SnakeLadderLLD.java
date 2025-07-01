import java.util.*;

public class SnakeLadderLLD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size (e.g., 100): ");
        int boardSize = sc.nextInt();

        System.out.print("Enter number of jumps (snakes + ladders combined): ");
        int numJumps = sc.nextInt();
        List<Jump> jumps = new ArrayList<>();
        for (int i = 1; i <= numJumps; i++) {
            System.out.print("Enter jump " + i + " start position: ");
            int start = sc.nextInt();
            System.out.print("Enter jump " + i + " end position: ");
            int end = sc.nextInt();
            jumps.add(new Jump(start, end));
        }

        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter player " + i + " name: ");
            String name = sc.nextLine();
            players.add(new Player(name));
        }

        Board board = new Board(boardSize, jumps);
        Dice dice = new Dice(6);
        Game game = new Game(board, dice, players);

        System.out.println("\n--- Game Starts ---");
        game.start();
    }
}
