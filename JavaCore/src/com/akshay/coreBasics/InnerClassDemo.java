package com.akshay.coreBasics;

import com.akshay.coreBasics.OuterClass.InnerClass;

class OuterClass {

	int val=1;
	class InnerClass {
		//static int x = 0; // The field x cannot be declared static in a
							// non-static inner type, unless initialized with a
							// constant expression
		
		
	}
}

public class InnerClassDemo {

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		InnerClass ic = oc.new InnerClass();
	}

}
