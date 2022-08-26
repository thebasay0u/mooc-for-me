
public class Main {

    public static void main(String[] args) {
        // you can test how your classes work here
        // ! Part 2
        // Dog dog = new Dog();
        // dog.bark();
        // dog.eat();

        // Dog fido = new Dog("Fido");
        // fido.bark();
        // ! Part 3

        // Cat cat = new Cat();
        // cat.purr();
        // cat.eat();

        // Cat garfield = new Cat("Garfield");
        // garfield.purr();
        // ! Part 4
        NoiseCapable dog = new Dog();
        dog.makeNoise();

        NoiseCapable cat = new Cat("Garfield");
        cat.makeNoise();
        Cat c = (Cat) cat;
        c.purr();

    }

}
