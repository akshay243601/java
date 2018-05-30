package com.akshay.coreBasics;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class URLEncodingDecoding {

	public static void test(String url){
		try{
			java.net.URI uri = new java.net.URI(url);
		} catch (Exception e){
			try {
				java.net.URI uri = new java.net.URI(java.net.URLEncoder.encode(url, "UTF-8"));
				url = uri.toString();
			} catch (UnsupportedEncodingException e1) {
			} catch (URISyntaxException e1) {
				System.out.println(e1);		}
		}
		System.out.println("Encoded Value : - " + url);
		try {
			System.out.println("Decoded Value : - "  +   java.net.URLDecoder.decode(url, "UTF-8").toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static void main(String[] args) {
		test("turner.com/TBSE/viewingpolicy/webZipBlackout/v++++1");
		test("turner.com/TBSE/viewingpolicy/webZipBlackout/v 1");
		test("http://localhost:8280/altcontentsvc/esni2015/TWC/Rainbow_Content_Provider/turner.com/TBSE/policy/12 s");
		test("turner.com/audience/webZipBlackout/v   1");
		test("test/mediaMapping/fe+++ed");
	}
}
