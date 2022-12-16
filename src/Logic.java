import java.util.Scanner;

public class Logic {
    Constants constants;
    Scanner sc;

    public Logic(Constants constants, Scanner sc) {
        this.constants = constants;
        this.sc = sc;
    }

    public int getHighTile(Tile[][] matrix) {
        int high = matrix[0][0].getValue();
        for (Tile[] tiles : matrix) {
            for (Tile tile : tiles) {
                if (tile.getValue() > high) {
                    high = tile.getValue();
                }
            }
        }
        return high;
    }
    public boolean checkIfMatrixFull(Tile[][] matrix){
        int count = 0;
        for (Tile[] tiles : matrix) {
            for (Tile tile : tiles) {
                if (tile.getValue() != 0) {
                    count++;
                }
            }
        }
        return count == constants.MATRIX_IS_FULL;
    }

    public char readInput() {
        return sc.next().charAt(0);
    }


}
