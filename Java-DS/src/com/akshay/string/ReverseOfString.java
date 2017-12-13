package com.akshay.string;

public class ReverseOfString {

	public static String reverse(String value){
		
		char[] rev = value.toCharArray();
		int i=0,j=value.length()-1;
		while(j > i)
		{
			char temp=rev[i];
			rev[i]=rev[j];
			rev[j]=temp;
			i++;
			j--;
		}
		return String.valueOf(rev);
	}
	
	public static void main(String[] args) {
		String value="dsdgfg";
		String revValue=reverse(value);
		System.out.println(revValue);
		
		String revValue1=reverse(revValue);
		System.out.println(revValue1);
		
		System.out.println(value.equals(revValue1));
		
	}
}
