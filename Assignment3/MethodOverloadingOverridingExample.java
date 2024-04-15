import java.util.Scanner;

// Animal class
class Animal {
    // Method to make sound
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Dog class inheriting from Animal
class Dog extends Animal {
    // Overriding makeSound() method from Animal class
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    // Overloading makeSound() method
    public void makeSound(String barkType) {
        System.out.println("Dog barks: " + barkType);
    }
}

public class MethodOverloadingOverridingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating Animal object
        Animal animal = new Animal();

        // Creating Dog object
        Dog dog = new Dog();

        // Demonstrate method overriding
        System.out.println("Demonstrating method overriding:");
        animal.makeSound(); // Calls Animal's makeSound()
        dog.makeSound();    // Calls Dog's makeSound() due to overriding

        // Demonstrate method overloading
        System.out.println("\nDemonstrating method overloading:");
        System.out.print("Enter bark type for dog: ");
        String barkType = scanner.nextLine();
        dog.makeSound(barkType); // Calls Dog's overloaded makeSound()

        scanner.close();
    }
}
