package graphs.knightMove;


public class Graph {

    private int maxKnights;
    private Knight[] knightList;
    private int cellNumber;
    private StackX stack;
    int[][] arrayMoves;

    private int initVertex = 0;

    public Graph(int cellNumber) {

        this.maxKnights = cellNumber * cellNumber;

        this.cellNumber = cellNumber;

        knightList = new Knight[maxKnights];

        stack = new StackX(maxKnights);

        arrayMoves = new int[][]{
                {-1, -2},
                {-2, -1},
                {1, -2},
                {2, -1},

                {2, 1},
                {1, 2},
                {-2, 1},
                {-1, 2},
        };
    }

    public void printChessBoard() {
        System.out.println("===============================");

        for (int i = 0; i < maxKnights; i++) {
            if (i % cellNumber == 0) {
                System.out.println();
            }

            char sign = knightList[i] == null ? 0 : knightList[i].label;

            System.out.print(sign + " ");
        }

        System.out.println();
        System.out.println("===============================");
    }

    public void dfs() {

        Knight firstKnight = new Knight('X');
        knightList[initVertex] = firstKnight;
        knightList[initVertex].wasVisited = true;

        printChessBoard();

        stack.push(initVertex);

        for (int i = 0; i < 8; i++) {
            searchPath(1, i);

        }
    }

    private boolean checkIfMoveIsValid(int nextColumn, int nextRow, int nextArrayIndex) {

        if (nextColumn < 1 || nextColumn > cellNumber || nextRow < 1 || nextRow > cellNumber) {
            return false;
        }

        if (nextArrayIndex > maxKnights) {
            return false;
        }

        if (knightList[nextArrayIndex] != null) {
            return false;
        }

        return true;
    }

    private void searchPath(int currentIndex, int move) {

        int nextColumn = getNextColumn(currentIndex, move);

        int nextRow = getNextRow(currentIndex, move);

        int nextArrayIndex = getNextArrayIndex(nextRow, nextColumn);

        boolean isValidMove = checkIfMoveIsValid(nextColumn, nextRow, nextArrayIndex);

        if (!isValidMove) {
            return;
        }

        if (stack.isFull()) {
            System.out.println("Win!");
            return;
        }

        if (nextArrayIndex == -1) {
            int pop = stack.pop();

            knightList[pop].wasVisited = false;
            knightList[pop] = null;
            knightList[stack.peek()].label = 'Y';

        } else {
            knightList[nextArrayIndex] = new Knight('X');
            knightList[nextArrayIndex].wasVisited = true;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            printChessBoard();

            knightList[stack.peek()].label = 'X';

            stack.push(nextArrayIndex);
        }

        for (int i = 0; i < 8; i++) {
            searchPath(nextArrayIndex + 1, i);

            printChessBoard();
        }

        int pop = stack.pop();

        knightList[pop].wasVisited = false;
        knightList[pop] = null;
        knightList[stack.peek()].label = 'Y';
    }

    private int getNextColumn(int currentIndex, int move) {

        int currentColumn = currentIndex % cellNumber;

        if (currentColumn == 0) {
            currentColumn = 5;
        }

        return currentColumn + arrayMoves[move][0];
    }

    private int getNextRow(int currentIndex, int move) {

        int currentRow = currentIndex / cellNumber + 1;

        if (currentIndex % 5 == 0) {
            currentRow = currentRow - 1;
        }

        return currentRow + arrayMoves[move][1];
    }

    private int getNextArrayIndex(int nextRow, int nextColumn) {

        // (5 * row) - (5 - column)
        return (cellNumber * nextRow) - (cellNumber - nextColumn) - 1;
    }
}
