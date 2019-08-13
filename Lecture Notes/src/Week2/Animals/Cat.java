package Week2.Animals;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return "meow!";
    }

    @Override
    public String toString() {
        return "I am a cat and my name is " + name;
    }
}
