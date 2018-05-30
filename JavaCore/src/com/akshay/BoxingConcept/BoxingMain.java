package com.akshay.BoxingConcept;

class ParentClass {
	void show(int i) {
		System.out.println("Parent Class : show");
	}

	void showForTypePromotion(int i, float j) {
		System.out.println("Parent Class :: showForTypePromotion");
	}
}

class ChildClass extends ParentClass {
	void show(Long i) {
		System.out.println("ChildClass : show (Long i) ");
	}

	void show(float i) {
		System.out.println("ChildClass : show(float i)");
	}

	void showchkpromotion(float i) {
		System.out.println("Child Class : showchkpromotion(float i)" + i);
	}

	void show(Float i) {
		System.out.println("Child Class  :  show(Float i)");
	}

	void showForTypePromotion(float i, float j) {
		System.out.println("Child Class :: showForTypePromotion(float i, float j)");
	}

	void showForTypePromotion(float i, int j) {
		System.out.println("Child Class :: showForTypePromotion  2");
	}

	void showForTypePromotion(int i, float j) {
		System.out.println("Child Class :: showForTypePromotion  2");
	}
}

public class BoxingMain {
	// static BoxingMain(){} //constructor can not be static

	public static void main(String args[]) {

		System.out.println("sdfsdf");

		ParentClass obj = new ChildClass();
		obj.show(5);

		obj.showForTypePromotion(1, .5f);

		ChildClass obj1 = new ChildClass();
		obj1.show(5.5f);

		obj1.showchkpromotion(3);

		obj1.showForTypePromotion(1, .10f);

		obj1.showForTypePromotion(.1f, 2);

		// obj1.showForTypePromotion(1, 3); CT Error no exact match Because bot
		// are eligible for this call. SO ambiguity error

		int i = 5;

		Integer ii = i;

		System.out.println(i);
		System.out.println(ii);

		Integer j = new Integer(i);
		System.out.println(j);

		String s = "2";
		Integer oo = Integer.parseInt(s);

		String s11 = "A";
		String S12 = String.valueOf(s11);
		System.out.println(s11 == S12);

		String s13 = "A";
		String s131 = String.valueOf(s13);
		System.out.println(s13 == s131);
		System.out.println(String.valueOf(s13) == String.valueOf(s13));

		String s14 = new String("A");
		String s141 = String.valueOf("A");
		System.out.println(s14 == s141);
		System.out.println(s13 == s14);

		String s1111 = String.valueOf(s14);
		System.out.println(s14 == s1111);
		
		Integer y = 10;
		Integer x = 10;

		System.out.println(x == y);

		Integer x1 = Integer.valueOf(x);
		System.out.println("x == x1" + (x == x1));
		
		Integer z = 134;
		Integer z1 = 134;
		Integer z11 = Integer.valueOf(z1);
		

		System.out.println("z1 == z11" + (z1 == z11));
		
		System.out.println(z == z1);

	}

}
