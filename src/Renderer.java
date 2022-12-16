public class Renderer {
    public void printBoard(Tile[][] matrix){
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

    public void gameStart() {
        System.out.println("""
                Welcome to 2048!
                Start game - s
                Quit - q""");
    }
    public void badInput(){
        System.out.println("Incorrect input. Try again");
    }
    public void quitting(){
        System.out.println("Quiting application");
    }
    public void winner(){
        System.out.println("Congratulations! You won 2048!");
    }
}
