package additional;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -7646411528224515984L;

    private int id;
    private String name;
    private byte byte_;
    private long long_;
    private int age;

    public Person(int id, String name, byte byte_, long long_, int age) {
        this.id = id;
        this.name = name;
        this.byte_ = byte_;
        this.long_ = long_;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public byte getByte_() {
        return byte_;
    }

    public long getLong_() {
        return long_;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", byte_=" + byte_ +
                ", long_=" + long_ +
                ", age=" + age +
                '}';
    }
}
