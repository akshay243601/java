import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*class CompaignLine {
	public int id;
	public String name;

	public CompaignLine(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "Id : " + this.id + " Name : " + this.name;
	}

}*/

public class IntersectionDemo {

	public static List getIntersection1(List... obj) {

		if (obj == null || (List[]) obj == null || obj.length < 2) {
			return null;
		}
		List[] list = (List[]) obj;
		if (list != null && list.length > 1) {
			List result = new ArrayList<>();
			result.addAll((List<Compaign>) list[0]);
			for (int i = 1; i < list.length; i++) {

				// Compaign Line
				if ((List<Compaign>) list[i] != null) {

					List<Compaign> l1 = (List<Compaign>) result;
					List<Compaign> l2 = (List<Compaign>) list[i];

					result = l1.stream()
							.filter(x -> l2.stream().map(y -> y.id).collect(Collectors.toList()).contains(x.id))
							.collect(Collectors.toList());
				}
				// Compaign Line
				else if ((List<CompaignLine>) list[i] != null) {

					List<CompaignLine> l1 = (List<CompaignLine>) result;
					List<CompaignLine> l2 = (List<CompaignLine>) list[i];

					l1 = l1.stream()
							.filter(x -> l2.stream().map(y -> y.clID).collect(Collectors.toList()).contains(x.clID))
							.collect(Collectors.toList());

				}
				// String or integer
				else {
					result = (List) result.parallelStream().filter(list[i]::contains).collect(Collectors.toList());
				}
			}

			return result;
		}

		return null;
	}

	public static Object getIntersection(Object obj1, Object obj2) {

		if (obj1 == null || obj2 == null || obj1.getClass() != obj2.getClass()) {
			return null;
		}

		if (obj1 instanceof List && obj2 instanceof List) {

			List list1 = null;
			List list2 = null;
			// String Type List
			if ((List<String>) obj1 != null && (List<String>) obj2 != null) {
				list1 = (List<String>) obj1;
				list2 = (List<String>) obj2;
			} else if ((List<Integer>) obj1 != null && (List<Integer>) obj2 != null) {
				list1 = (List<Integer>) obj1;
				list2 = (List<Integer>) obj2;
			}
			return list1.parallelStream().filter(list2::contains).collect(Collectors.toList());
		}

		return null;
	}

	/* This will retunr the column values only but not the custom object */

	// Intersection of multiple list
	public static List getIntersectionOfMultipleListCustomObject(List... obj) {

		if (obj == null && (List[]) obj != null && ((List[]) obj).length < 2) {
			return null;
		}

		List commons = new ArrayList();

		commons.addAll(getList(obj[0]));

		for (int i = 1; i < obj.length; i++) {
			commons.retainAll(getList(obj[i]));
		}
		return commons;
	}

	public static List getList(List list) {

		if (list != null && list.size() > 0) {
			List result = new ArrayList<>();

			// Compaign
			if ((List<Compaign>) list != null) {
				return ((List<Compaign>) list).parallelStream().map(x -> x.name).collect(Collectors.toList());
			}
			// Compaign Line
			else if ((List<CompaignLine>) list != null) {
				return ((List<CompaignLine>) list).parallelStream().map(x -> x.clID).collect(Collectors.toList());
			}
			// String or integer
			else {
				return list;
			}

		}
		return null;
	}

	public static void main(String[] args) {
		List<String> list11 = new ArrayList<>();
		list11.add("1");
		list11.add("2");
		list11.add("3");
		list11.add("4");
		list11.add("5");
		list11.add("6");

		List<String> list12 = new ArrayList<>();
		list12.add("2");
		list12.add("4");
		list12.add("6");
		list12.add("8");

		List<String> list13 = new ArrayList<>();
		list13.add("2");
		list13.add("4");
		list13.add("9");
		list13.add("10");
		// System.out.println(getIntersection1(list11, list12, list13));

		List<Compaign> l1 = new ArrayList<>();
		List<Compaign> l2 = new ArrayList<>();

		l1 = l1.stream().filter(str1 -> l2.stream().map(x -> x.id).collect(Collectors.toSet()).contains(str1))
				.collect(Collectors.toList());

		/*
		 * System.out.println(getIntersectionOfMultipleListCustomObject(list11,
		 * list12, list13));
		 * 
		 * List<Integer> list3 = new ArrayList<>(); list3.add(1); list3.add(2);
		 * list3.add(3); list3.add(4); list3.add(5); list3.add(6);
		 * 
		 * List<Integer> list4 = new ArrayList<>(); list4.add(2); list4.add(4);
		 * list4.add(6); list4.add(8);
		 * 
		 * List<Integer> list5 = new ArrayList<>(); list5.add(2); list5.add(6);
		 * list5.add(9); list5.add(10);
		 * 
		 * 
		 * System.out.println(getIntersection(list3, list4));
		 * System.out.println(getIntersection(list4, list3));
		 * 
		 * System.out.println(getIntersectionOfMultipleList(list4, list4, list3,
		 * list5));
		 */

		List<Compaign> list1 = new ArrayList<>();
		list1.add(new Compaign(1, "A"));
		list1.add(new Compaign(2, "B"));
		list1.add(new Compaign(3, "C"));
		list1.add(new Compaign(4, "D"));
		list1.add(new Compaign(5, "E"));

		List<Compaign> list2 = new ArrayList<>();
		list2.add(new Compaign(2, "B"));
		list2.add(new Compaign(3, "C"));
		list2.add(new Compaign(4, "D"));

		List<Compaign> list3 = new ArrayList<>();
		list3.add(new Compaign(2, "B"));
		list3.add(new Compaign(4, "D"));
		list3.add(new Compaign(6, "F"));

		List<Compaign> result = (List<Compaign>) getIntersection1(list1, list2, list3);
		for (Compaign object : result) {
			System.out.println(object.toString());
		}
	}

}
