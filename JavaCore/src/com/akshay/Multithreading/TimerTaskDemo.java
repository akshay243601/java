package com.akshay.Multithreading;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class TimerTaskDemo extends TimerTask{

	public static void main(String[] args) {
		System.out.println("main is calling...");

		TimerTask timerTask = new TimerTaskDemo();
		Timer timer = new Timer();
		System.out.println(new Date());
		timer.scheduleAtFixedRate(timerTask, 0, 2000);
		System.out.println("main is calling...");
		 
	}
	

	@Override
	public void run() {
		try{
			doTaskComplete();
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	private void doTaskComplete(){
		System.out.println(new Date());
		System.out.println("doTaskComplete is calling...");
		try{
			//Thread.sleep(1000);
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
