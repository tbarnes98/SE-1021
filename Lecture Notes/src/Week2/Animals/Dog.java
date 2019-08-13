package Week2.Animals;

public class Dog extends Animal{
    public Dog (String name) {
        super(name);
    }

    @Override
    public String speak() {
        return "woof!";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
