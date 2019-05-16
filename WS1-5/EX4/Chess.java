import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Chess is a class containing an interactive chessboard taking user input in type String of length
 * 4
 *
 * @author Adam Robinson
 * @version 2017-11-26
 */

public class Chess {

  private String[][] chessBoard;

  public static final Pattern p = Pattern.compile("[a-h][1-8][a-h][1-8]|q");

  /**
   * This constructor initialises Chess object with a double array of of 8x8 with pieces in start
   * position
   */

  public Chess() {
    this.chessBoard = new String[8][8];

    chessBoard[0][0] = "rook    |";
    chessBoard[0][1] = "knight  |";
    chessBoard[0][2] = "bishop  |";
    chessBoard[0][3] = "queen   |";
    chessBoard[0][4] = "king    |";
    chessBoard[0][5] = "bishop  |";
    chessBoard[0][6] = "knight  |";
    chessBoard[0][7] = "rook    |";
    chessBoard[7][0] = "ROOK    |";
    chessBoard[7][1] = "KNIGHT  |";
    chessBoard[7][2] = "BISHOP  |";
    chessBoard[7][3] = "QUEEN   |";
    chessBoard[7][4] = "KING    |";
    chessBoard[7][5] = "BISHOP  |";
    chessBoard[7][6] = "KNIGHT  |";
    chessBoard[7][7] = "ROOK    |";

    for (int i = 0; i < chessBoard[1].length; i++) {
      chessBoard[1][i] = "pawn    |";
    }

    for (int j = 0; j < chessBoard[1].length; j++) {
      chessBoard[6][j] = "PAWN    |";
    }
  }

  /**
   * toString Method to print the state of the Chessboard
   *
   * @return the current state of the chessboard
   */

  public String toString() {
    String letters = "       a        b        c        d        e        f        g        h      ";
    String line = "  +--------+--------+--------+--------+--------+--------+--------+--------+";
    String board = letters + "\n" + line + "\n";
    int x = 8;

    for (int i = 0; i < chessBoard.length; i++) {
      board += x + " |";
      for (int j = 0; j < chessBoard[i].length; j++) {
        if (chessBoard[i][j] != null) {
          board += chessBoard[i][j];
        } else {
          board += "        |";
        }
        // end of line formatting
        if (j == 7) {
          board += " " + x + "\n" + line + "\n";
        }
      }
      x--;
    }
    board += letters + "\n";
    return board;
  }

  /**
   * Method to move chess pieces within the chessBoard array based on user string input of length 4
   *
   * @param playerMove String user input of length 4
   */

  public void play(String playerMove) {

    char pt1 = playerMove.charAt(0);
    char pt2 = playerMove.charAt(1);
    char pt3 = playerMove.charAt(2);
    char pt4 = playerMove.charAt(3);

    int ipt1 = (int) pt1 - 97;
    int ipt2 = 56 - (int) pt2;
    int ipt3 = (int) pt3 - 97;
    int ipt4 = 56 - (int) pt4;

    chessBoard[ipt4][ipt3] = chessBoard[ipt2][ipt1];
    chessBoard[ipt2][ipt1] = null;
  }

  /**
   * Method containing interactive features for the chess game
   */

  public static void interactive() {

    Chess letsPlayChess = new Chess();

    System.out.println(letsPlayChess);

    Scanner scan = new Scanner(System.in);
    String move = "Start";

    while (!move.equals("q")) {
      try {
        System.out.println("Example input [a1b1]" + "\nSelect Move: ");
        move = scan.next(p);
        if (move.equals("q")) {
          break;
        }
        letsPlayChess.play(move);
        System.out.println(letsPlayChess.toString());
      } catch (InputMismatchException exception) {
        System.out.println("Incorrect User Input.");
        scan = new Scanner(System.in);

      }
    }
  }

  public static void main(String[] args) {
    interactive();
  }
}