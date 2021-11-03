package ua.ithillel.current;

import java.util.Scanner;

public class PlayerData implements Data {

    private static final char PLAYER_SYMBOL = 'X';
    private int fieldSize;

    private final Scanner scanner = new Scanner(System.in);

    public PlayerData(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    @Override
    public MoveResult getData() {
        int vertical = chooseCoordinate('v');
        int horizontal = chooseCoordinate('h');
        return new MoveResult(PLAYER_SYMBOL, new Coordinate(vertical, horizontal));
    }

    private int chooseCoordinate(char coordinateSymbol) {
        int coordinate;

        do {
            System.out.printf("Please enter %s-coordinate [1-%d] ...%n", coordinateSymbol, fieldSize);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= fieldSize);

        return coordinate;
    }
}
