package com.akshay.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyLambda {

	public static void main(String args[]) {

		System.out.println("Lambda Expression");

		PrintLambda myPrintLambda = (name) -> System.out.println(name);
		PrintLambda myPrintLambda1 = name -> System.out.println(name);
		PrintLambda myPrintLambda2 = (name) -> {
			System.out.println(name);
		};

		myPrintLambda.printName("Akshay");
		myPrintLambda1.printName("Akshay-1");
		myPrintLambda2.printName("Akshay-2");

		AddLambda myAddLambda = (a, b) -> {
			System.out.println("a :- " + a);
			System.out.println("b :- " + b);
			return a + b;
		};
		System.out.println(myAddLambda.add(2, 3));

		myAddLambda.log();
		AddLambda.staticMethodInInterface();
		System.out.println(myAddLambda);
		System.out.println(myPrintLambda);
		System.out.println(myPrintLambda1);
		System.out.println(myPrintLambda2);

		PrintLambdaWithSamElseBadName lambda1 = (name) -> name.equalsIgnoreCase("SAM") ? "HELLO " + name
				: "BAD " + name;
		List<String> list = new ArrayList<>();
		list.add("SAM");
		list.add("AKSHAY1");
		list.add("SAM");
		list.add("AKSHAY2");
		list.add("SAM");
		list.add("AKSHAY3");
		list.add("SAM");
		list.add("SAM4");
		list.parallelStream().forEach(x -> System.out.println(lambda1.getName(x)));

	}

}

@FunctionalInterface
interface AddLambda {
	int add(int a, int b);

	default void log() {
		System.out.println("log");
	}

	public static void staticMethodInInterface() {
		System.out.println("staticMethodInInterface");
	}
}

@FunctionalInterface
interface PrintLambda {
	void printName(String name);
}

@FunctionalInterface
interface PrintLambdaWithSamElseBadName {
	String getName(String name);
}