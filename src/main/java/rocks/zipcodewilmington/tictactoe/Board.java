package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private final Character[][] matrix;

    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    public Boolean isInFavorOfX() {
        return isDiagonalOf('X') || isHorizontalOf('X') || isVerticalOf('X');
    }

    public Boolean isInFavorOfO() {
        return isDiagonalOf('O') || isHorizontalOf('O') || isVerticalOf('O');
    }

    public Boolean isTie() {
        return (!(isInFavorOfO() || isInFavorOfX()));
    }

    public String getWinner() {
        String winner = "";
        if (isInFavorOfX()) {
            winner = "X";
        } else if (isInFavorOfO()) {
            winner = "O";
        }
        return winner;
    }

    public Boolean isHorizontalOf(Character player) {

        boolean isHorizontalFound = false;
       for (Character[] characters : matrix) {
           if (characters[0] == player && characters[1] == player && characters[2] == player) {
               isHorizontalFound = true;
              break;
            }
        }
        return isHorizontalFound;
    }

    public Boolean isVerticalOf(Character player) {

        boolean isVerticalFound = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i] == player && matrix[1][i] == player && matrix[2][i] == player) {
                isVerticalFound = true;
                break;
            }
        }
        return isVerticalFound;
    }

    public Boolean isDiagonalOf(Character player) {

        boolean isLeftDiagonalFound = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != player) {
                isLeftDiagonalFound = false;
                break;
            }
        }
        boolean isRightDiagonalFound = true;
        int maxIndex = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][maxIndex - i] != player) {
                isRightDiagonalFound = false;
                break;
            }
        }
        return isLeftDiagonalFound || isRightDiagonalFound;
    }

}


