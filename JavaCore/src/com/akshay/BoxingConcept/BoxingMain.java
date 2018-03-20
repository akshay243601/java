package com.akshay.BoxingConcept;

class ParentClass
{
	void show(int i)
	{
		System.out.println("Parent Class : show");
	}
	
	void showForTypePromotion(int i, float j)
	{
		System.out.println("Parent Class :: showForTypePromotion");
	}
}

class ChildClass extends ParentClass
{
	void show(Long i)
	{
		System.out.println("ChildClass : show (Long i) ");
	}
	
	void show(float i)
	{
		System.out.println("ChildClass : show(float i)");
	}
	
	void showchkpromotion(float i)
	{
		System.out.println("Child Class : showchkpromotion(float i)" + i);
	}
	
	
	void show(Float i)
	{
		System.out.println("Child Class  :  show(Float i)");
	}
	
	void showForTypePromotion(float i, float j)
	{
		System.out.println("Child Class :: showForTypePromotion(float i, float j)");
	}
	
	void showForTypePromotion(float i, int j)
	{
		System.out.println("Child Class :: showForTypePromotion  2");
	}
	
	void showForTypePromotion(int i, float j)
	{
		System.out.println("Child Class :: showForTypePromotion  2");
	}
}


public class BoxingMain 
{
	//static BoxingMain(){}  //constructor can not be static
	
	public static void main(String args[]) 
	{
		
		ParentClass obj = new ChildClass();
		obj.show(5);
		
		
		obj.showForTypePromotion(1, .5f);
		
		ChildClass obj1 = new ChildClass();
		obj1.show(5.5f);

		obj1.showchkpromotion(3);
		
		obj1.showForTypePromotion(1, .10f);
		
		obj1.showForTypePromotion(.1f, 2);
		
	//	obj1.showForTypePromotion(1, 3);   CT Error no exact match Because bot are eligible for this call. SO ambiguity error

		
		int i = 5;
		
		Integer ii = i;
		
		System.out.println(i);
		System.out.println(ii);
		
		
		Integer j = new Integer(i);
		System.out.println(j);
		
		
		String s = "2";
		Integer oo = Integer.parseInt(s);
		
		
	}

}
