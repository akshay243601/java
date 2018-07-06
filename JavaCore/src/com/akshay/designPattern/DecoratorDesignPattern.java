package com.akshay.designPattern;

interface Car {
	void assemble();
}

class BasicCarDecorator implements Car {
	@Override
	public void assemble() {
		System.out.print(" Basic Car ");
	}
}

class CarDecorator implements Car {

	Car car;

	public CarDecorator(Car car) {
		this.car = car;
	}

	@Override
	public void assemble() {
		this.car.assemble();
	}
}

class SprortsDecorator extends CarDecorator {

	Car car;

	public SprortsDecorator(Car car) {
		super(car);
		this.car = car;
	}

	public void assemble() {
		super.assemble();
		System.out.print(" ,Sports Car feature ");
	}

}

class LuxuryDecorator extends CarDecorator {

	Car car;

	public LuxuryDecorator(Car car) {
		super(car);
		this.car = car;
	}

	public void assemble() {
		super.assemble();
		System.out.print(" ,Luxury Car feature ");
	}

}

// 1) Decorator design pattern is helpful in providing runtime modification
// abilities and hence more flexible. Its easy to maintain and extend when the
// number of choices are more.

// 2) The disadvantage of decorator design pattern is that it uses a lot of
// similar kind of objects (decorators).

// 3) Decorator pattern is used a lot in Java IO classes, such as FileReader,
// BufferedReader etc.*/

public class DecoratorDesignPattern {

	public static void main(String[] args) {
		Car sportCar = new SprortsDecorator(new BasicCarDecorator());
		sportCar.assemble();
		
		System.out.println();
		
		Car cars = new LuxuryDecorator(new SprortsDecorator(new CarDecorator(new BasicCarDecorator())));
		cars.assemble();
		
		System.out.println();
		
		Car scars = new SprortsDecorator(new LuxuryDecorator(new CarDecorator(new BasicCarDecorator())));
		scars.assemble();

		
	}

}
