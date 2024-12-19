package additional;

import java.io.*;

public class WriteObject {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Bob", (byte) 1, 555, 30);
        Person person2 = new Person(2, "Mike", (byte) 1, 555, 25);

        Person[] people = {new Person(3, "Sam", (byte) 1, 555, 35), new Person(4, "Caty", (byte) 1, 555, 18)};

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.bin"))) {
//            FileOutputStream fos = new FileOutputStream("people.bin");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);

//            oos.writeInt(people.length);
//            for (Person person : people) {
//                oos.writeObject(person);
//            }

            oos.writeObject(people);

//            oos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
