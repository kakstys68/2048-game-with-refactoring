import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Constants constants = new Constants();
        Renderer renderer = new Renderer();
        Logic logic = new Logic(constants, sc);
        Controll controll = new Controll();
        Board board = Board.getInstance(constants, logic, renderer);
        Movement movement = new Movement(board, renderer);
        renderer.gameStart();
        char input = logic.readInput();
        if (input == 's'){
            while(input!='q'){
                renderer.printBoard(board.getMatrix());
                input = logic.readInput();
                controll.setCommand(new SetMovement(movement, input));
                controll.input();
                if(logic.getHighTile(board.getMatrix()) == constants.WINNING_SCORE){
                    renderer.printBoard(board.getMatrix());
                    renderer.winner();
                    input = 'q';
                }
            }
        }
        else renderer.badInput();
    }
}