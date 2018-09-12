/*
 * Observer pattern is used when there is one-to-many relationship between objects 
 * such as if one object is modified, 
 * its depenedent objects are to be notified automatically. 
 * Observer pattern falls under behavioral pattern category.
 */

package com.akshay.designPattern;

import java.util.ArrayList;
import java.util.List;

class Subject {
	private int state;
	List<Observer> observers = new ArrayList<Observer>();

	public void attached(Observer observer) {
		this.observers.add(observer);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyUpdateToAllObserver();
	}

	private void notifyUpdateToAllObserver() {
		for (Observer obs : observers) {
			obs.update();
		}
	}

}

abstract class Observer {
	protected Subject subject;

	public abstract void update();
}

class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attached(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
	}

}

class HexObserver extends Observer {
	public HexObserver(Subject subject) {
		this.subject = subject;
		this.subject.attached(this);
	}

	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toHexString(subject.getState()));
	}

}

class OctObserver extends Observer {
	public OctObserver(Subject subject) {
		this.subject = subject;
		this.subject.attached(this);
	}

	@Override
	public void update() {
		System.out.println("Oct String: " + Integer.toOctalString(subject.getState()));
	}

}

public class ObserverPatternDemo {

	public static void main(String[] args) {
		Subject sc = new Subject();
		new BinaryObserver(sc);
		new HexObserver(sc);
		new OctObserver(sc);

		System.out.println("First state change: 15");
		sc.setState(15);
		System.out.println("Second state change: 10");
		sc.setState(10);

	}

}
