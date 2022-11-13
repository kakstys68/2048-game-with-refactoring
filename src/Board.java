import java.util.Arrays;
import java.util.Random;

public class Board {
    private Tile[][] matrix;
    Random rand = new Random();


    public Board() {
        matrix = new Tile[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                matrix[i][j] = new Tile(false);
            }
        }
        addTile();
        addTile();
    }

    public void printBoard(){
        System.out.println("                                                        ");
        System.out.println("                                                        ");
        System.out.println("                Use wasd to play. q - quit");
        System.out.println("                                                        ");
        System.out.println("                                                        ");
        System.out.println("              " + matrix[0][0] + "    |       " + matrix[0][1] + "      |       " + matrix[0][2] + "      |     " + matrix[0][3]);
        System.out.println("            -------------------------------------------------------------");
        System.out.println("              " + matrix[1][0] + "    |       " + matrix[1][1] + "      |       " + matrix[1][2] + "      |     " + matrix[1][3]);
        System.out.println("            -------------------------------------------------------------");
        System.out.println("              " + matrix[2][0] + "    |       " + matrix[2][1] + "      |       " + matrix[2][2] + "      |     " + matrix[2][3]);
        System.out.println("            -------------------------------------------------------------");
        System.out.println("              " + matrix[3][0] + "    |       " + matrix[3][1] + "      |       " + matrix[3][2] + "      |     " + matrix[3][3]);
    }
    public void addTile(){
        int x = rand.nextInt(4);
        int y = rand.nextInt(4);

        if(!matrix[x][y].isUsed()){
            Tile tile = new Tile(2);
            matrix[x][y] = tile;
            tile.setUsed(true);
        }
        else {
            addTile();
        }

    }

    public int getHighTile()
    {
        int high = matrix[0][0].getValue();
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                if ( matrix[i][j].getValue() > high ) {
                    high = matrix[i][j].getValue();
                }
            }
        }
        return high;
    }

    public void moveUp(Board board){
        int border;
        for(int i = 0; i < matrix.length; i++) {
            border = 0;
            for (int j = 0; j < 4; j++) {
                if(matrix[j][i].getValue() != 0){
                    if(border <= j){
                        verticalMove(j, i, "up", border);
                    }
                }
            }
        }
        addTile();

    }
    public void moveDown(Board board){
        int border;
        for(int i = 0; i < matrix.length; i++){
            border = matrix.length - 1;
            for(int j = matrix.length - 1; j>=0; j--) {
                if ( matrix[j][i].getValue() != 0 ) {
                    if ( border >= j ) {
                        verticalMove(j, i, "down", border);
                    }
                }
            }
        }
        addTile();

    }
    public void verticalMove(int row, int col, String direction, int border){
        Tile currTile = matrix[border][col];
        Tile testTile = matrix[row][col];
        if(currTile.getValue() == 0 || currTile.getValue() == testTile.getValue()){
            if (row > border || ( direction.equals( "down" ) && ( row < border ) ) ) {
                int score = currTile.getValue() + testTile.getValue();

                currTile.setValue(score);
                currTile.setUsed(true);
                testTile.setValue( 0 );
                testTile.setUsed(false);
            }
        }
        else{
            if (direction.equals("down")) {
                border--;
            }
            else {
                border++;
            }
            verticalMove(row, col, direction, border);
        }
    }

    public void moveLeft(Board board){
        int border;
        for ( int i = 0; i < matrix.length; i++ ) {
            border = 0;
            for ( int j = 0; j < matrix.length; j++ ) {
                if ( matrix[i][j].getValue() != 0 ) {
                    if ( border <= j ) {
                        horizontalMove( i, j, "left", border );
                    }
                }
            }
        }
        addTile();
    }
    public void moveRight(Board board){
        int border;
        for (int i = 0; i < matrix.length; i++) {
            border = (matrix.length - 1);
            for (int j = (matrix.length - 1 ); j >= 0; j--) {
                if (matrix[i][j].getValue() != 0) {
                    if (border >= j) {
                        horizontalMove(i, j, "right", border);
                    }
                }
            }
        }
        addTile();
    }
    public void horizontalMove(int row, int col, String direction, int border){
        Tile currTile = matrix[row][border];
        Tile testTile = matrix[row][col];
        if (currTile.getValue() == 0 || currTile.getValue() == testTile.getValue()) {
            if (col > border || (direction.equals("right") && (col < border))) {
                int score = currTile.getValue() + testTile.getValue();

                currTile.setValue(score);
                currTile.setUsed(true);
                testTile.setValue(0);
                testTile.setUsed(false);
            }
        }
        else {
            if (direction.equals( "right" )) {
                border--;
            }
            else {
                border++;
            }
            horizontalMove(row, col, direction, border);
        }
    }


}
