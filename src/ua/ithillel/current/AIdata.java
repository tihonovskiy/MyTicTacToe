package ua.ithillel.current;

import java.util.Random;

public class AIdata implements Data {
    private static final char AI_SYMBOL = 'O';
    private int fieldSize;

    private final Random random = new Random();

    public AIdata(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    @Override
    public MoveResult getData() {
        int vertical = random.nextInt(fieldSize);
        int horizontal = random.nextInt(fieldSize);
        return new MoveResult(AI_SYMBOL, new Coordinate(vertical, horizontal));
    }

}
