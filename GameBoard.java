import jdk.jshell.execution.Util;

import java.util.Scanner;

public class GameBoard {
    private Player game[][];
    private int currentPlayer = 0;

    GameBoard(){
        game = new Player[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3 ; j++){
                game[i][j] = new Player();
            }
        }

    public void startGame() {
        boolean gameStatus = true;
        while (gameStatus) {
            CollectChoiceForPlayer();
            gameStatus = CheckGameStatus();
            if (gameStatus)
                return;
            boolean draw = false;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (game[i][j].getChoice() == '-') {
                        draw = true;
                        break;
                    }
            if (!draw)
                return;
        }
    }

    private boolean CheckGameStatus() {
        for (int i = 0; i < 3; i++) {
            if (game[i][0].equals(game[i][1]) && game[i][0].equals(game[i][2]))
                return true;
        }
        for (int i = 0; i < 3; i++) {
            if (game[0][i].equals(game[1][i]) && game[0][i].equals(game[2][i]))
                return true;
        }
        if (game[0][0].equals(game[1][1]) && game[0][0].equals(game[2][2]))
            return true;
        if (game[0][2].equals(game[1][1]) && game[0][2].equals(game[2][0]))
            return true;
        return false;

    }

    private void CollectChoiceForPlayer() {
        System.out.println("Player " + (currentPlayer + 1) + "Please pick your new game board location");
        int x = 0;
        int y = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Please enter the x value: ");
            Scanner input = new Scanner(System.in);
            x = input.nextInt();
            while (x < 0 || x > 2) {
                System.out.println("Incorrect choice please pick a value 0, 1, 2");
                x = input.nextInt();
            }

            y = input.nextInt();
            while (y < 0 || y > 2) {
                System.out.println("Incorrect choice please pick a value 0, 1, 2");
                y = input.nextInt();
            }
            if (game[x][y].getChoice() != '-') {
                System.out.println("Incorrect location. Please try again");
            } else {
                validChoice = true;
            }
        }
    }

}