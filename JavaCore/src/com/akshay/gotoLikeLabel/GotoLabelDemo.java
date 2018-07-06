package com.akshay.gotoLikeLabel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java code to illustrate
//using label  and break
//instead of goto

//file name: Main.java
public class GotoLabelDemo {
	public static void main(String[] args) {
		
		// label for outer loop
		outer: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 4)
					break outer;
				System.out.println(" value of j = " + j);
			}
			
		} // end of outer loop
	} // end of main()
} // end of class Main
