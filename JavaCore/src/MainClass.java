import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

class Employee1 implements Comparator<Employee1> {

	private String name;

	public Employee1(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public Employee1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Employee1 o1, Employee1 o2) {

		if (o1 == null ) {
			return -1;
		}

		if (o1.getName() == null || o2.getName() == null) {
			return -1;
		}

		return o1.getName().compareTo(o2.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class MainClass {

	public static void main(String[] args) {

		List<Employee1> empl = new LinkedList<Employee1>();
		try {
			for (int i = 0; i < 10000; i++) {
				empl.add(new Employee1("1" + i));
				empl.add(null);
				empl.add(new Employee1("2" + i));
				empl.add(new Employee1("123" + i));
				empl.add(null);
				empl.add(null);
				empl.add(new Employee1("1"));
			}
			java.util.Collections.sort(empl, new Employee1());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
