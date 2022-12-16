import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsBoardFullTest {

    @Test
    void emptyMatrixShouldReturnFalse() {
        Constants constants = new Constants();
        Logic logic = new Logic(constants);
        Tile[][] testMatrix = new Tile[4][4];
        for(int i=0; i< testMatrix.length; i++){
            for(int j=0; j< testMatrix.length; j++){
                testMatrix[i][j] = new Tile(false);
            }
        }
        assertFalse(logic.checkIfMatrixFull(testMatrix));
    }
    @Test
    void fullMatrixShouldReturnTrue() {
        Constants constants = new Constants();
        Logic logic = new Logic(constants);
        Tile[][] testMatrix = new Tile[4][4];
        for(int i=0; i< testMatrix.length; i++){
            for(int j=0; j< testMatrix.length; j++){
                testMatrix[i][j] = new Tile(constants.TILE_START_VALUE_2);
            }
        }
        assertTrue(logic.checkIfMatrixFull(testMatrix));
    }
}