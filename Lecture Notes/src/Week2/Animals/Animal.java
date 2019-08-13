package Week2.Animals;

public class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String speak() {
        return "";
    }

    @Override
    public String toString() {
        return "I am an animal called " + name;
    }
}
