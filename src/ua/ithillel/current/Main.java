package ua.ithillel.current;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Want to play tic tac toe? (1 - yes / 0 - no): ");
        int start = scanner.nextInt();

        while (start == 1) {
            new TicTacToe(getSizeField(scanner)).start();
            System.out.print("Want to play again? (1 - yes / 0 - no): ");
            start = scanner.nextInt();
        }
    }


    private static int getSizeField(Scanner scanner) {
        int minField = 3;
        int maxFiled = 10;
        System.out.printf("Enter size field (%d - min / %d - max): ", minField, maxFiled);
        int size = scanner.nextInt();

        if(size < minField || size > maxFiled) {
            do {
                System.out.printf("Invalid value entered, please enter a number between %d and %d: ", minField, maxFiled);
                size = scanner.nextInt();
            } while (size < minField || size > maxFiled);
        }

        return size;
    }
}
