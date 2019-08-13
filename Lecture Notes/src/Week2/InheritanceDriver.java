package Week2;

import Week2.Animals.Animal;
import Week2.Animals.Cat;

public class InheritanceDriver {
    public static void main(String[] args) {
        Animal a = new Animal("Fred");
        System.out.println(a);

        Cat c = new Cat("Fluffy");
        System.out.println(c);
    }
}
