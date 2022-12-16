import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class IsTileAddedTest {

    @Test
    void addTile() {
        Constants constants = new Constants();
        Logic logic = new Logic(constants);
        Renderer renderer = new Renderer();
        Board board = Board.getInstance(constants, logic, renderer);

    }
}