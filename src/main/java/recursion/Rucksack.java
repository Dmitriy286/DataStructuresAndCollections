package recursion;

public class Rucksack {

    private static int[] itemsWeights = {11, 8, 7, 6, 5};
    private static int requiredWeight = 20;

    public static void main(String[] args) {

        knapsack(requiredWeight, 0);
    }

    private static boolean knapsack(int sumWeight, int index) {

        if (index >= itemsWeights.length) {
            return false;
        }

        int currentElementWeight = itemsWeights[index];

        if (currentElementWeight < sumWeight && index == itemsWeights.length - 1) {
            System.out.println("Goal = " + sumWeight + ", " + currentElementWeight + " Less. No more items");

            return false;
        } else if (currentElementWeight < sumWeight) {

            System.out.println("Goal = " + sumWeight + ", " + currentElementWeight + " Less");

            boolean knapsack = knapsack(sumWeight - currentElementWeight, index + 1);

            if (knapsack) {
                return true;
            } else {
                return knapsack(sumWeight, index + 1);
            }

        } else if (currentElementWeight > sumWeight && index == itemsWeights.length - 1) {

            System.out.println("Goal = " + sumWeight + ", " + currentElementWeight + " More. No more items");

            return false;
        } else if (currentElementWeight > sumWeight) {

            System.out.println("Goal = " + sumWeight + ", " + currentElementWeight + " More");

            return knapsack(sumWeight, ++index);
        } else {

            System.out.println("Goal = " + sumWeight + ", " + currentElementWeight + " equals. Success!");

            return true;
        }
    }
}
