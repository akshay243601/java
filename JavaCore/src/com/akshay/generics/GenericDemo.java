package com.akshay.generics;

public class GenericDemo {

	public static void main(String[] args) {
		GenericBox<Integer> integerBox = new GenericBox<Integer>(10);
		GenericBox<String> stringBox = new GenericBox<String>("String box ");
		GenericBox<Float> floatBox = new GenericBox<Float>(10.5f);

		System.out.println(integerBox.getBox());
		System.out.println(stringBox.getBox());
		System.out.println(floatBox.getBox());

		Long s = null;
		try {
			if (s != null && s > 0) {
				System.out.println("cs");
			} else {
				System.out.println("cs1");
			}
		} catch (Exception e) {

			System.out.println(e);
		}
	}

}
