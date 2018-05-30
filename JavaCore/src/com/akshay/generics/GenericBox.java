package com.akshay.generics;

//We can use any character instead of T as well, Or we can use multiple character with comma separated like public class GenericBox<T, X, Y, Z>
public class GenericBox<T> {

	T t;
	public GenericBox(T t) {
		this.t = t;
	}
	
	public T getBox(){
		return t;
	}

}
