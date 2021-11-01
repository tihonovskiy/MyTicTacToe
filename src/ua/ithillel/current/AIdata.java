package ua.ithillel.current;

import java.util.Random;

public class AIdata implements Data {

    private static final char AI_SYMBOL = 'O';

    private final Random random = new Random();

    @Override
    public MoveResult getData() {
        int vertical = random.nextInt(3);
        int horizontal = random.nextInt(3);
        return new MoveResult(AI_SYMBOL, new Coordinate(vertical, horizontal));
    }

}
