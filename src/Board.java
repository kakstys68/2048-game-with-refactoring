
import java.util.Random;

public class Board {
    Constants constants;
    Logic logic;
    Renderer renderer;

    private final Tile[][] matrix;
    Random rand = new Random();
    private static Board instance;


    private Board(Constants constants, Logic logic, Renderer renderer) {
        this.constants = constants;
        this.logic = logic;
        this.renderer = renderer;
        matrix = new Tile[4][4];
        createEmptyBoard();
        addTile();
        addTile();
    }
    public void createEmptyBoard(){
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix.length; j++){
                matrix[i][j] = new Tile(false);
            }
        }
    }
    public static Board getInstance(Constants constants, Logic logic, Renderer renderer){
        if(instance==null){
            instance = new Board(constants, logic, renderer);
        }
        return instance;
    }

    public Tile[][] getMatrix() {
        return matrix;
    }
    public void addTile(){
        int x = rand.nextInt(matrix.length);
        int y = rand.nextInt(matrix.length);

        int[] tileValue = {constants.TILE_START_VALUE_2, constants.TILE_START_VALUE_4};
        int index = rand.nextInt(tileValue.length);

        if(!matrix[x][y].isUsed()){
            Tile tile = new Tile(tileValue[index]);
            matrix[x][y] = tile;
            tile.setUsed(true);
        }
        else {
            addTile();
        }
        if(logic.checkIfMatrixFull(matrix)){
            renderer.printBoard(matrix);
            System.out.println("No more possible moves! Game Over");
            System.exit(0);
        }

    }
}
