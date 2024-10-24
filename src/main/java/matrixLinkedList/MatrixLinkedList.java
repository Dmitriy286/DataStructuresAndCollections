package matrixLinkedList;

import java.util.Objects;

public class MatrixLinkedList {

    private int width;
    private int height;
    private int size;

    private MatrixNode head;
    private MatrixNode tail;


    public MatrixLinkedList(int width, int height) {
        this.width = width;
        this.height = height;

        this.size = 0;

        createMatrix();
    }

    private void createMatrix() {
        for (int i = 0; i < width * height; i++) {
            insertLast("[]");
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return size == (width * height);
    }

    public void display() {
        int rowQuantity = getRowQuantity();

        MatrixNode currentHead = head;

        for (int i = 0; i < rowQuantity; i++) {
            MatrixNode current = currentHead;

            for (int j = 0; j < width; j++) {
                if (Objects.nonNull(current)) {
                    System.out.printf("%4s\t", current.getValue());

                    current = current.getNextRight();
                } else {
                    break;
                }
            }

            System.out.println();

            currentHead = currentHead.getNextDown();
        }
    }

    public void insertFirst(String value) {
        if (isFull()) {
            System.out.println("Matrix is full");
            return;
        }

        MatrixNode newNode = new MatrixNode(value);

        if (isEmpty()) {
            tail = newNode;
        } else if (size < width) {
            newNode.setNextRight(head);
        } else {
            MatrixNode lastInRow = getLastInRow(1);

            newNode.setNextRight(head);
            newNode.setNextDown(lastInRow);
        }

        head = newNode;
        size++;
    }

    public void insertLast(String value) {
        if (isFull()) {
            System.out.println("Matrix is full");
            return;
        }

        MatrixNode newNode = new MatrixNode(value);

        if (isEmpty()) {
            head = newNode;
        } else {

            int currentRow = size / width + 1;
            int index = size % width;

            if (currentRow == 1) {
                tail.setNextRight(newNode);
            } else if (currentRow > 1 && index == 0) {
                tail.setNextRight(newNode);
                MatrixNode firstInPreviousRow = getFirstInRow(currentRow - 1);
                firstInPreviousRow.setNextDown(newNode);
            } else if (currentRow > 1 && index > 0) {
                MatrixNode currentInPreviousRow = getCurrentInPreviousRow(currentRow - 1);
                currentInPreviousRow.setNextDown(newNode);
                tail.setNextRight(newNode);
            }
        }

        tail = newNode;
        size++;
    }

    public void insert(String value, int row, int column) {

        if (Boolean.FALSE.equals(checkIndexes(row, column))) {
            return;
        }

        MatrixNode node = head;

        for (int i = 1; i < row; i++) {
            node = node.getNextDown();
        }

        for (int i = 1; i < column; i++) {
            node = node.getNextRight();
        }

        node.setValue(value);
    }

    private Boolean checkIndexes(int row, int column) {
        if (row > height) {
            System.out.println("Above row bound");

            return false;
        } else if (column > width) {
            System.out.println("Above column bound");

            return false;
        }

        return true;
    }

    private MatrixNode getCurrentInPreviousRow(int row) {
        MatrixNode firstInPreviousRow = getFirstInRow(row);

        MatrixNode currentInPreviousRow = firstInPreviousRow;

        int positionInRow = (size % width);

        for (int i = 0; i < positionInRow; i++) {
            if (Objects.nonNull(currentInPreviousRow.getNextRight())) {
                currentInPreviousRow = currentInPreviousRow.getNextRight();
            } else {
                break;
            }
        }

        return currentInPreviousRow;
    }

    private int getRowQuantity() {
        int rowQuantity = (int) Math.ceil((double) size / width);

        System.out.println("rowQuantity: " + rowQuantity);

        return rowQuantity;
    }

    private MatrixNode getLastInRow(int row) {
        MatrixNode startNode = head;

        for (int i = 1; i < row; i++) {
            startNode = startNode.getNextDown();
        }

        MatrixNode lastInRow = startNode;

        for (int i = 1; i < width; i++) {
            lastInRow = lastInRow.getNextRight();
        }

        return lastInRow;
    }


    private MatrixNode getFirstInRow(int row) {
        if (isEmpty()) {
            System.out.println("Matrix is full");
            return null;
        }

        MatrixNode startNode = head;

        MatrixNode firstInRow = startNode;

        for (int i = 1; i < row; i++) {
            firstInRow = firstInRow.getNextDown();
        }

        return firstInRow;
    }
}
