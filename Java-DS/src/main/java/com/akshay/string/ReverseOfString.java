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
	
	public static String reverseWithoutLoop(String value){
		
		if(value == null || value.isEmpty()){
			return null;
		}
		return  value.charAt(value.length()-1) +  reverse(value.substring(0, value.length()-1));
	}
	
	public static void main(String[] args) {
		String value="dsdgfg";
		String revValue=reverse(value);
		System.out.println(revValue);
		
		String revValue1=reverse(revValue);
		System.out.println(revValue1);
		
		System.out.println(value.equals(revValue1));
		
		revValue = reverseWithoutLoop(value);
		revValue1 = reverseWithoutLoop(revValue);
		
		System.out.println(revValue1);
		System.out.println(revValue);

		System.out.println(value.equals(revValue1));
		
	}
}
