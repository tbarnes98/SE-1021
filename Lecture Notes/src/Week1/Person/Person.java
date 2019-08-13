package Week1.Person;

public class Person {
    //Instance variables should be private
    private String name;
    private int age;
    private String gender;

    //Default no parameter constructor is given if no constructor is described

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //Getters are not required
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
