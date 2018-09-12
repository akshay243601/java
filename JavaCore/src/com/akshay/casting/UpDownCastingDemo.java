package com.akshay.casting;

import java.util.ArrayList;
import java.util.List;

public class UpDownCastingDemo {

	public static void AnimalThainer(Animal animal) {
		animal.move();

	}

	public static void main(String[] args) {

		
		
		Object ob = new Object();
		Float floater = new Float(3.14f);
		// floater = ob; // CT Error .
		
		ob = floater; //or ob = (Object)floater;
		
		System.out.println(ob);

		Animal animal = new Animal();
		animal.eat();
		// Dog dog = (Dog)animal; //Down Casting Error
		// dog.eat();

		UpDownCastingDemo.AnimalThainer(animal);

		Animal animal2 = new Dog();
		animal2.eat();
		Dog dog2 = (Dog) animal2;
		dog2.eat();
		animal2 = dog2;
		animal2.eat();

		UpDownCastingDemo.AnimalThainer(animal2);

		UpDownCastingDemo.AnimalThainer(dog2);

		Dog dog1 = new Dog();
		dog1.eat();
		Animal animal1 = (Animal) dog1; // upcasting
		animal1.eat();

		UpDownCastingDemo.AnimalThainer(dog1);
		UpDownCastingDemo.AnimalThainer(animal1);

	}

}
