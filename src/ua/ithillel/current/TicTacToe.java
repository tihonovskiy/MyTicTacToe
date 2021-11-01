package ua.ithillel.current;

public class TicTacToe {
    private static final char EMPTY_SYMBOL = '-';

    private final char[][] field = {
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
    };

    public void start() {
        Data playerMoveAction = new PlayerData();
        Data aiMoveAction = new AIdata();

        for (int i = 0; i < field.length * field[0].length; i++) {
            drawField();

            doMove(playerMoveAction);
            if(checkWin()) {
                System.out.println("You Win!!!");
                drawField();
                break;
            }
            doMove(aiMoveAction);
            if(checkWin()) {
                System.out.println("You Lose!!!");
                drawField();
                break;
            }

            if (checkDraw()) {
                System.out.println("It is draw!!!");
                drawField();
                break;
            }
        }

    }

    private boolean checkWin() {
        if(checkWinnerHorizontal() || checkWinnerVertical() || checkWinnerDiagonals()) {
            return true;
        }
        return false;
    }

    private boolean checkWinnerHorizontal() {
        for (int i = 0; i < field.length; i++) {
            boolean result = true;
            for (int j = 1; j < field.length; j++) {
                if(field[i][j] != field[i][0] || field[i][0] == '-') {
                    result = false;
                }
            }

            if (result)
                return true;
        }
        return false;
    }

    private boolean checkWinnerVertical() {
        for (int i = 0; i < field.length; i++) {
            boolean result = true;
            for (int j = 1; j < field.length; j++) {
                if (field[j][i] != field[0][i] || field[0][i] == '-') {
                    result = false;
                }
            }

            if (result)
                return true;
        }
        return false;
    }

    private boolean checkWinnerDiagonals() {
        boolean result = true;
        for (int i = 1; i < field.length; i++) {
            if (field[i][i] != field[0][0] || field[0][0] == '-') {
                result = false;
            }
        }

        if (result) {
            return true;
        }
        result = true;
        for (int i = 1; i < field.length; i++)
            if ((field[field.length - i - 1][i] != field[field.length - 1][0]) || field[field.length - 1][0] == '-') {
                result = false;
            }
        return result;
    }

    private boolean checkDraw() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void doMove(Data coordinateFinder) {
        MoveResult moveResult;
        Coordinate coordinate;

        do {
            moveResult = coordinateFinder.getData();
            coordinate = moveResult.getCoordinate();
        } while (field[coordinate.getVertical()][coordinate.getHorizontal()] != EMPTY_SYMBOL);

        field[coordinate.getVertical()][coordinate.getHorizontal()] = moveResult.getSymbol();
    }

    private void drawField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
