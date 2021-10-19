package JavaExam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static JavaExam.Constant.VALID_INPUT;

public class Game {


    private Character[] board;
    private Boolean isXTurn;
    private Result winner;

    public Game() {
        Character[] board = new Character[9];
        Arrays.fill(board, ' ');
        this.board = board;
        this.isXTurn = true;

    }


    public void printBoard() {
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
    }

    public Result placeChoice(int i) {

        if (board[i] == ' ') {
            if (isXTurn) {
                board[i] = 'X';
            } else {
                board[i] = 'O';
            }
            isXTurn = !isXTurn;

            return checkWinner();
        } else {
            return Result.TAKEN;

        }


    }

    private Result checkWinner() {
        boolean isDraw = true;
        for (int index = 0; index < 9; index++) {
            StringBuilder lineResult = new StringBuilder();
            if (board[index] == ' ') {
                isDraw = false;
            }

            switch (index) {
                case 0 -> lineResult.append(board[0]).append(board[1]).append(board[2]);
                case 1 -> lineResult.append(board[3]).append(board[4]).append(board[5]);
                case 2 -> lineResult.append(board[6]).append(board[7]).append(board[8]);
                case 3 -> lineResult.append(board[0]).append(board[3]).append(board[6]);
                case 4 -> lineResult.append(board[1]).append(board[4]).append(board[7]);
                case 5 -> lineResult.append(board[2]).append(board[5]).append(board[8]);
                case 6 -> lineResult.append(board[0]).append(board[4]).append(board[8]);
                case 7 -> lineResult.append(board[2]).append(board[4]).append(board[6]);
            }
            //For X winner
            if (lineResult.toString().equals("XXX")) {
                return Result.X;
            }

            // For O winner
            else if (lineResult.toString().equals("OOO")) {
                return Result.O;
            }


        }
        if (isDraw) {
            return Result.DRAW;
        }
        return null;
    }

    private Result run(Scanner in) {
        while (winner == null || winner == Result.TAKEN) {


            Integer choice = getChoiceAndValid(in);
            winner = placeChoice(choice);

            if (winner == Result.TAKEN) {
                System.out.println("Slot has taken, Try again!");
            }
            printBoard();

            ;
        }
        return winner;
    }


    private Integer getChoiceAndValid(Scanner in) {
        if (isXTurn) {
            System.out.print("Please enter your choice player X: ");


        } else {
            System.out.print("Please enter your choice player O: ");

        }
        while (true) {
            String numInput = in.nextLine();
            if (Pattern.matches(VALID_INPUT, numInput))

                return Integer.parseInt(numInput) - 1;

            System.out.print("Invalid input, Please re-enter your choice: ");

        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UserName userName = new UserName();
        userName.inputName(in);
        boolean isTryAgain = true;


            Game game = new Game();
            Result winner = game.run(in);

            switch (winner) {
                case X -> {
                    System.out.println(userName.getXName() + " win!");
                }
                case O -> {
                    System.out.println(userName.getClass() + " win!");

                }
                case DRAW -> {
                    System.out.println("Draw!");

                }




        }


    }


}




