import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static int player;
    private static boolean playing;
    private static int move;
    private static int[] madeMoves;
    private static Scanner scanner;
    private static Random random;

    public static void main(String[] args){
        String[][] gameBoard =
           {{" ", "|", " ", "|", " "},
            {"-", "+", "-", "+", "-"},
            {" ", "|", " ", "|", " "},
            {"-", "+", "-", "+", "-"},
            {" ", "|", " ", "|", " "}};
        createGame(gameBoard);


        player = 1;
        playing = true;
        madeMoves = new int[10];
        scanner = new Scanner(System.in);
        random = new Random();

        //player is an int, when player is odd, that means a person is playing
        //there is a maximum of 9 moves, thus player < 10

        while(player < 10) {
            if(player % 2 == 0){
                move = random.nextInt(9)+1;
                checkMove(madeMoves,move);
                madeMoves[player] = move;
                System.out.println("The Computer made a move at " + move);
                makeMove(gameBoard, move, player);
                player++;
            }else {
                System.out.println("Please make a move (1-9): ");
                move = scanner.nextInt();
                checkMove(madeMoves, move);
                madeMoves[player] = move;
                System.out.println("The human made a move at " + move);
                makeMove(gameBoard, move, player);
                checkWin(gameBoard);
                player++;
            }
            createGame(gameBoard);
        }


    }

    public static void createGame(String[][] gameBoard){
        for(String[] row : gameBoard){
            for(String letter : row){
                System.out.print(letter);
            }
            System.out.println();
        }
    }

    public static void makeMove(String[][] gameBoard, int move, int player){
        String playerMove = "";
        if(player % 2 == 1){
            playerMove = "X";
        }else
            playerMove = "O";
        switch(move){
            case 1:
                gameBoard[0][0] = playerMove;
                break;
            case 2:
                gameBoard[0][2] = playerMove;
                break;
            case 3:
                gameBoard[0][4] = playerMove;
                break;
            case 4:
                gameBoard[2][0] = playerMove;
                break;
            case 5:
                gameBoard[2][2] = playerMove;
                break;
            case 6:
                gameBoard[2][4] = playerMove;
                break;
            case 7:
                gameBoard[4][0] = playerMove;
                break;
            case 8:
                gameBoard[4][2] = playerMove;
                break;
            case 9:
                gameBoard[4][4] = playerMove;
                break;
            default:
                break;
        }

    }
    public static void checkMove(int[] madeMoves, int madeMove){

        for(int moved: madeMoves){
            if(madeMove == moved){
                if(player % 2 == 1) {
                    System.out.println("Choose a different move: ");
                    move = scanner.nextInt();
                    checkMove(madeMoves, move);
                    break;
                }else{
                    move = random.nextInt(9)+1;
                    checkMove(madeMoves, move);
                    break;
                }
            }
        }
    }

    public static void checkWin(String[][] gameBoard){
        String name = " ";
        if(player % 2 == 1){
            name = "Player";
        }else
            name = "Computer";

        //check for win in rows
        for(String[] row : gameBoard){
            int count = 0;
            for(String word: row){
                if(word.equals("X")||word.equals("O")){
                    count++;
                }
            }
            if(count == 3){
                System.out.println("The "+ name + " wins!");
                player = 10;
                break;
            }
        }

        //check for win in columns and diagonals
        for(int i = 0; i < 5; i+=2) {
            int count = 0;
            for (int j = 0; j < 5; j += 2) {
                String word = gameBoard[j][i];
                if (word.equals("X") || word.equals("O")) {
                    count++;
                }
            }
            if (count == 3) {
                System.out.println("The " + name + " wins!");
                player = 10;
                break;
            }
        }
    }

}
