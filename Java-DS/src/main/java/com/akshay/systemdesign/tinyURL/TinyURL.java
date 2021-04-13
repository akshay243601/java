package com.akshay.systemdesign.tinyURL;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TinyURL {

	static String chracterSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	static int base = 62;
	static AtomicInteger counter = new AtomicInteger(10);
	static Map<Long, String> store = new HashMap<>();

	
	//Generate TINY URL FROM BIG URL
	public static String getTinyURL(String url) {
		long number = getNumber();
		String tinyURL = getBase62EncodedString(number);
		
		//Save number and URL in a Key So that we can  further use this number to retrive actual URL.
		store.put(number, url);
		return tinyURL;
	}
	
	//It will return a number that we will save for a URL and Based on this number we can generate Tiny URL. 
	public static long getNumber() {
		int count = counter.incrementAndGet();
		
		// We add here count to just to distinguish different user who try to access same url at the same time. 
		//If two user try to access same URL then they will generate different number as we increrase a Counter.
		long number = Long.valueOf(count + System.currentTimeMillis());
		return number;
	}

	
	//It will return a Tiny URL based on the Number which was generated earlier
	public static String getBase62EncodedString(long number) {
		StringBuilder sb = new StringBuilder();
		
		while (number > 0) {
			int temp = (int) (number % base);
			sb.append(chracterSet.charAt(temp));
			number = number / base;
		}
		
		return sb.toString();
	}


	/********  START Convert TinyURL back to ACTUAL URL  ***********/
	
	
	// convert Tiny URL back to Actual URL
	public static String convertTinyURLToActualURL(String tinyURL) {

		//Get number from tiny URL
		long number = getBase10TinyURLNumber(tinyURL);
		
		//Get actual URL from map based on the number.
		return store.get(number);
	}

	//Convert tiny URL back to base 10 Number
	public static long getBase10TinyURLNumber(String tinyURL) {
		char[] chars = tinyURL.toCharArray();
		long nBase10 = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			int index = chracterSet.indexOf(chars[i]);
			nBase10 += index * (long)Math.pow(base, i);
		}
		return nBase10;
	}

	/********  end Convert TinyURL back to ACTUAL URL  ***********/

	
	public static void main(String[] args) {
		
		String url = "https://mailer.timesjobs.com/mailers/mailersnew.html?companyName=ace_11sept17";
		
		String tinyURL = getTinyURL(url);
		System.out.println(tinyURL);
		
		String revertedURL = convertTinyURLToActualURL(tinyURL);
		System.out.println(revertedURL);
		
		System.out.println("URL and Reverted URL : " + url.equals(revertedURL));
		
	}
}
