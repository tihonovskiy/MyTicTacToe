package ua.ithillel.current;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Want to play tic tac toe? (1 - yes / 0 - no): ");
        int start = scanner.nextInt();
        char[][] field = new char[3][3];
        while (start == 1) {
            new TicTacToe().start();
            System.out.print("Want to play again? (1 - yes / 0 - no): ");
            start = scanner.nextInt();
        }
    }
}
