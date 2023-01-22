package marketQueues;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

public class MarketQueuesApp {
    public static CustomerQueue firstQueue;
    public static CustomerQueue secondQueue;
    public static CustomerQueue thirdQueue;

    public static CustomerQueue forthQueue;
    public static CustomerQueue fifthQueue;

    public static CustomerQueue[] customerQueueArray = new CustomerQueue[5];
    public static int elapsedTime;

    public static void main(String[] args) throws IOException {
        firstQueue = new CustomerQueue(10);
        secondQueue = new CustomerQueue(10);
        thirdQueue = new CustomerQueue(10);
        forthQueue = new CustomerQueue(10);
        fifthQueue = new CustomerQueue(10);

        customerQueueArray[0] = firstQueue;
        customerQueueArray[1] = secondQueue;
        customerQueueArray[2] = thirdQueue;
        customerQueueArray[3] = forthQueue;
        customerQueueArray[4] = fifthQueue;


        firstQueue.insert(new Customer(10));
//        firstQueue.insert(new Customer(6));
//        firstQueue.insert(new Customer(8));
//
        secondQueue.insert(new Customer(9));
//        secondQueue.insert(new Customer(2));
//        secondQueue.insert(new Customer(11));
//        secondQueue.insert(new Customer(1));
//
        thirdQueue.insert(new Customer(19));
//        thirdQueue.insert(new Customer(10));
//        thirdQueue.insert(new Customer(30));
//
        forthQueue.insert(new Customer(1));
//        forthQueue.insert(new Customer(10));
//        forthQueue.insert(new Customer(5));
//        forthQueue.insert(new Customer(20));
//        forthQueue.insert(new Customer(19));
//
        fifthQueue.insert(new Customer(2));
//        fifthQueue.insert(new Customer(9));
//        fifthQueue.insert(new Customer(10));
        System.out.println("Before sorting:");
        for (CustomerQueue queue : customerQueueArray) {
            queue.display();
        }
        System.out.println();
        CustomerQueue[] sortedQueueArray = sortQueuesByLength(customerQueueArray);
        System.out.println("After sorting:");
        for (CustomerQueue queue : sortedQueueArray) {
            queue.display();

        }
        System.out.println();

        init();
    }

    public static void displayAllQueues() {
        System.out.print("1: ");
        firstQueue.display();
        System.out.print("2: ");
        secondQueue.display();
        System.out.print("3: ");
        thirdQueue.display();
        System.out.print("4: ");
        forthQueue.display();
        System.out.print("5: ");
        fifthQueue.display();
    }

    public static void chooseQueue(Customer customer) {
        CustomerQueue chosenQueue = sortQueuesByLength(customerQueueArray)[0];

        chosenQueue.insert(customer);
    }

    public static CustomerQueue[] sortQueuesByLength(CustomerQueue[] array) {
        for (int i = 1; i < array.length; i++) {
            int j;
            CustomerQueue temp = array[i];
            for (j = i; j > 0; j--) {
                if (temp.getNItems() < array[j - 1].getNItems()) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = temp;
        }
        CustomerQueue[] checkedArray = checkIfQueuesAreSameByCustomersNumber(array);
        if (array.length == checkedArray.length && array[0].getNItems() != array[1].getNItems()) {
            return array;
        } else {
            CustomerQueue[] sortedArray = sortQueuesByProductsCount(checkedArray);
            return sortedArray;
        }
    }

    public static CustomerQueue[] sortQueuesByProductsCount(CustomerQueue[] array) {
        for (int i = 1; i < array.length; i++) {
            int j;
            CustomerQueue temp = array[i];
            for (j = i; j > 0; j--) {
                if (temp.isEmpty() || array[j - 1].isEmpty()) {
                    break;
                }
                else if (temp.peekRear().getGoodsCount() < array[j - 1].peekRear().getGoodsCount()) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = temp;
        }
        return array;
    }

    public static CustomerQueue[] checkIfQueuesAreSameByCustomersNumber(CustomerQueue[] array) {
        int length = 0;
        if (array[0].getNItems() != array[1].getNItems()) {
            return array;
        } else {
            length++;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].getNItems() == array[i + 1].getNItems()) {
                    length++;
                } else {
                    break;
                }
            }
        }
        CustomerQueue[] checkedArray = new CustomerQueue[length];
        for (int i = 0; i < length; i++) {
            checkedArray[i] = array[i];
        }
        return checkedArray;
    }

    public static void addNewCustomer() {
        Random random = new Random();
        int productsNumber = random.nextInt(30);

        Customer customer = new Customer(productsNumber);
        System.out.println(customer);
        chooseQueue(customer);
    }

    public static void deleteCustomer() {
        for (CustomerQueue queue : customerQueueArray) {
            if (queue.peekFront() == null) {
                continue;
            }
            else if (queue.peekFront().getGoodsCount() <= 0) {
                queue.remove();
                if (queue.peekFront() != null) {
                    queue.peekFront().setGoodsCount(queue.peekFront().getGoodsCount() - 2);
                }
            }
            else {
                queue.peekFront().setGoodsCount(queue.peekFront().getGoodsCount() - 2);
            }
        }
    }

    public static void init() throws IOException {
        while (true) {
            System.out.println("Enter 1 to increase spent time, 2 to add new customer, 3 to exit the application:");
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(streamReader);
            String enteredValue = reader.readLine();
            System.out.println(enteredValue);
            if (Objects.equals(enteredValue, "1")) {
                elapsedTime++;
                deleteCustomer();
            } else if (Objects.equals(enteredValue, "2")) {
                elapsedTime++;
                addNewCustomer();
                deleteCustomer();
            } else {
                break;
            }

            displayAllQueues();
        }
    }


}
