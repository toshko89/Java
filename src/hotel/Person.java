package hotel;

public class Person {
    String name;
    int id;
    int age;
    String hometown = "n/a";

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Person ").append(this.name)
                .append(": ").append(this.id).append(", Age: ").append(this.age).append(", Hometown: ")
                .append(this.hometown).append(System.lineSeparator());
        return stringBuilder.toString().trim();
    }
}
