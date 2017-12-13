package com.akshay.QuestionAsked;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextFileSearchWord 
{
	
	public static String readDataFromFile(String fileName)
	{
		BufferedReader reader = null;
		StringBuilder out = new StringBuilder();
		try {
		InputStream in = new FileInputStream(new File(fileName));
		reader = new BufferedReader(new InputStreamReader(in));
	    String line;
	    while ((line = reader.readLine()) != null) {
	        out.append(line);
	    }
	    reader.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toString();
	}
	
	public static List<String> GetWordStartWithVowel(String Data)
	{
		List<String> data = new ArrayList<String>();
		String[] words = Data.replaceAll("/\n/"," ").split(" ");
		String vowel = new String("AEIOUaeiou");
		for (String word : words) {
			
			if(word != "" && word != null && word.length()>0 && vowel.indexOf(word.charAt(0)) > -1)
			{
				data.add(word);
			}
		}
		return data;
	}
	
	
	public static void main(String args[])
	{
		String filePath = "C:\\Users\\akshaygu\\Desktop\\testFile.txt";
		List<String> data = GetWordStartWithVowel(readDataFromFile(filePath));
		for (String val : data) {
		System.out.println(val);
		}
		
	}

}
