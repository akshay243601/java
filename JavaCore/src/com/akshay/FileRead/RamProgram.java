package com.akshay.FileRead;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RamProgram 
{
	
	public static List<String> getscreenshot(String dirName) 
	{
		
		List<String> files = new ArrayList<String>();
		try
		{
			//check directory exist or not if not then  create it 
			File dir = new File(dirName);
			if(!dir.isDirectory())
			{
				dir.mkdir();
			}
			
			System.out.println(dir.getAbsolutePath());
			
            File[] f = dir.listFiles();
			
            if(f != null && f.length  > 0)
            {
            	for(int i = 0 ; i < f.length ; i++)
            	{
            		files.add(f[i].getName());
            	}
            }
        }
		catch(Exception e)
		{
			System.out.println(e);
		}
		return files;
	}
	
	
	public static void main(String args[])
	{
		System.out.println(getscreenshot("D:/Project Documents/SI_QA"));
	}

}


