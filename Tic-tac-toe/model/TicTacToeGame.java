
package model;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    public void initializeGame() {
        // creating 2 Players
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        // initialize board
        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        Scanner inputScanner = new Scanner(System.in); // moved scanner outside loop

        while (noWinner) {

            // take out the player whose turn it is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            // print the board and get free spaces
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            // read the user input
            System.out.print("Player: " + playerTurn.name + " Enter row,column: ");
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            if (values.length != 2) {
                System.out.println("Invalid input format, try again");
                players.addFirst(playerTurn);
                continue;
            }

            int inputRow, inputColumn;
            try {
                inputRow = Integer.parseInt(values[0].trim());
                inputColumn = Integer.parseInt(values[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered, try again");
                players.addFirst(playerTurn);
                continue;
            }

            // place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if (!pieceAddedSuccessfully) {
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.playingPiece.pieceType);
            if (winner) {
                gameBoard.printBoard();
                return playerTurn.name;
            }
        }

        gameBoard.printBoard();
        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // check row
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        // check column
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        // check main diagonal
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][i] == null || gameBoard.board[i][i].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        // check anti-diagonal
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
