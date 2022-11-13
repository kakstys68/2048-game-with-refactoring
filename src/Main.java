import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input;

        System.out.println("""
                Welcome to 2048!
                Start game - s
                Quit - q""");

        input = sc.next().charAt(0);
        if (input == 's'){
            Board board = new Board();
            int gameScore;
            while(input!='q'){
                board.printBoard();
                input = sc.next().charAt(0);
                switch (input) {
                    case 'w' -> board.moveUp(board);
                    case 'a' -> board.moveLeft(board);
                    case 's' -> board.moveDown(board);
                    case 'd' -> board.moveRight(board);
                    case 'q' -> System.out.println("Quiting application");
                    default -> System.out.println("Incorrect input. Try again");
                }
                gameScore = board.getHighTile();
                if(gameScore == 2048){
                    board.printBoard();
                    System.out.println("Congratulations! You won 2048!");
                    input = 'q';
                }

            }
        }
        else System.out.println("Unrecognized input.");
    }
}