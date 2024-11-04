package hashtable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
//        try {
//            FileInputStream fis = new FileInputStream("people.bin");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//
//            Person person1 = (Person) ois.readObject();
//            Person person2 = (Person) ois.readObject();
//
//            System.out.println(person1);
//            System.out.println(person2);
//
//            ois.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.bin"))) {
            Person person1 = (Person) ois.readObject();

//            Person person2 = (Person) ois.readObject();
//            System.out.println(person1);
//            System.out.println(person2);
//            int personCount = ois.readInt();
//            Person[] people = new Person[personCount];
//            for (int i = 0; i < personCount; i++) {
//                Person person = (Person) ois.readObject();
//                people[i] = person;
//            }

            Person[] people = (Person[]) ois.readObject();


//            ois.close();
            System.out.println(Arrays.toString(people));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
