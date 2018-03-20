package StrongSoftWeakPhantomReference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class Employee{
	public int id;
	public String name;
}

public class StrongSoftWeakPhantomReferenceDemo {

	public static void strongReferenceDemo()
	{
		Employee emp = new Employee();   //Strong reference
		emp.id=1;
		emp.name="Akshay";
		
		System.out.println(emp);		
		emp = null;   //it will be marked for Garbage collection
		System.out.println(emp);
		
	}
	
	public static void weakReferenceDemo()
	{
		Employee emp = new Employee();   //Strong reference
		emp.id=1;
		emp.name="Akshay";
		
		System.out.println("Emp address initially. : " + emp);

		WeakReference<Employee> weakRef = new WeakReference<Employee>(emp);
		
		emp = null;
		
		emp = weakRef.get();
		
		System.out.println("Emp after getting it from weak ref. : " + emp);   // its address will be same as it was in started
		
		emp = null;    //Because of this and system.gc() now it will get one weakRef. and it will cleaned
		
		System.gc();
		
		emp = weakRef.get();
		
		System.out.println("After GC run : Emp after getting it from weak ref. : " + emp);   //it will pring null {diff. in soft and weak}
		
	}

	
	public static void softReferenceDemo()
	{
		Employee emp = new Employee();   //Strong reference
		emp.id=1;
		emp.name="Akshay";
		
		System.out.println("Emp address initially. : " + emp);

		SoftReference<Employee> softRef = new SoftReference<Employee>(emp);
		
		emp = null; 
		
		emp = softRef.get();
		
		System.out.println("Emp after getting it from soft ref. : " + emp);   // its address will be same as it was in started
		
		emp = null; 
		
		System.gc();

		emp = softRef.get();

		System.out.println("After GC run : Emp after getting it from soft ref. : " + emp);   //it will print emp value
	}

	public static void phantomReferenceDemo()
	{
		Employee emp = new Employee();   //Strong reference
		emp.id=1;
		emp.name="Akshay";
		
		System.out.println("Emp address initially. : " + emp);
		
		ReferenceQueue<Employee> refQueue = new ReferenceQueue<Employee>();
		
		PhantomReference<Employee> phantomRef = new PhantomReference<Employee>(emp, refQueue);
		
		emp = null; 
		
		emp = phantomRef.get();
		
		System.out.println("Emp after getting it from phantom ref. : " + emp);   // its address will be same as it was in started
		
		emp = null; 
		
		System.gc();

		emp = phantomRef.get();

		System.out.println("After GC run : Emp after getting it from phantom ref. : " + emp);   //it will print emp value
	}

	
	public static void main(String[] args) {
		
		strongReferenceDemo();
		
		weakReferenceDemo();
		
		softReferenceDemo();
		
		phantomReferenceDemo();
	}

}
