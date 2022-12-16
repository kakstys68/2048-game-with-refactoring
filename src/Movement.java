public class Movement {
    Board board;
    Renderer renderer;
    public Movement(Board board, Renderer renderer) {
        this.board = board;
        this.renderer = renderer;
    }

    public Movement() {
    }

    public void moveUp(Board board){
        int border;
        for(int i = 0; i < board.getMatrix().length; i++) {
            border = 0;
            for (int j = 0; j < board.getMatrix().length; j++) {
                if(board.getMatrix()[j][i].getValue() != 0){
                    verticalMove(j, i, "up", border);
                }
            }
        }
        board.addTile();
    }
    public void moveDown(Board board){
        int border;
        for(int i = 0; i < board.getMatrix().length; i++){
            border = board.getMatrix().length - 1;
            for(int j = board.getMatrix().length - 1; j>=0; j--) {
                if ( board.getMatrix()[j][i].getValue() != 0 ) {
                    if ( border >= j ) {
                        verticalMove(j, i, "down", border);
                    }
                }
            }
        }
        board.addTile();
    }
    public void verticalMove(int row, int col, String direction, int border){
        Tile currTile = board.getMatrix()[border][col];
        Tile testTile = board.getMatrix()[row][col];
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
        for ( int i = 0; i < board.getMatrix().length; i++ ) {
            border = 0;
            for ( int j = 0; j < board.getMatrix().length; j++ ) {
                if ( board.getMatrix()[i][j].getValue() != 0 ) {
                    horizontalMove( i, j, "left", border );
                }
            }
        }
        board.addTile();
    }
    public void moveRight(Board board){
        int border;
        for (int i = 0; i < board.getMatrix().length; i++) {
            border = (board.getMatrix().length - 1);
            for (int j = (board.getMatrix().length - 1 ); j >= 0; j--) {
                if (board.getMatrix()[i][j].getValue() != 0) {
                    if (border >= j) {
                        horizontalMove(i, j, "right", border);
                    }
                }
            }
        }
        board.addTile();
    }
    public void horizontalMove(int row, int col, String direction, int border){
        Tile currTile = board.getMatrix()[row][border];
        Tile testTile = board.getMatrix()[row][col];
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

    public void move(char input) {
        switch (input) {
            case 'w' -> moveUp(board);
            case 'a' -> moveLeft(board);
            case 's' -> moveDown(board);
            case 'd' -> moveRight(board);
            case 'q' -> renderer.quitting();
            default -> renderer.badInput();
        }
    }
}
