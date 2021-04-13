
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfCustomMultipleList_OLD {

	// Using Java 1.8
	public static List getIntersection(List... obj) {

		if (obj == null || (List[]) obj == null || obj.length < 1) {
			return null;
		}

		List[] list = (List[]) obj;

		if (list != null) {

			Class classType = null;
			if (list[0].size() > 0 || list[0].get(0) != null) {
				classType = list[0].get(0).getClass();
			}
			// If a list is empty then return null/empty list
			else {
				return null;
			}

			List result = new ArrayList<>();
			result.addAll(list[0]);
			for (int i = 1; i < list.length; i++) {

				// If any list is empty then return null/empty list
				if (list[i] == null || list[i].size() == 0) {
					return null;
				}

				// Compaign
				if (Compaign.class.equals(classType)) {
					List<Compaign> l1 = (List<Compaign>) result;
					List<Compaign> l2 = (List<Compaign>) list[i];

					result = l1.stream().filter(x -> x != null && l2.parallelStream().filter(y -> y != null)
							.map(y -> y.id).collect(Collectors.toList()).contains(x.id)).collect(Collectors.toList());
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

	// Using Java 1.6
	public static Set getIntersection1(List... lists) {
		Set<Object> intersection = new HashSet<>(lists[0]);

		for (int i = 1; i < lists.length; i++) {

			Set<Object> newIntersection = new HashSet<>();

			for (Object obj : lists[i]) {
				if (intersection.contains(obj)) {
					newIntersection.add(obj);
				}
			}
			intersection = newIntersection;
		}

		return intersection;
	}

	// Intersection of multiple list
	public static List getIntersectionOfMultipleListCustomObject(List... obj) {

		if (obj == null && (List[]) obj != null && ((List[]) obj).length < 2) {
			return null;
		}

		List commons = new ArrayList();

		commons.addAll(obj[0]);

		for (int i = 1; i < obj.length; i++) {
			commons.retainAll(obj[i]);
		}
		return commons;
	}

	// Using Java 1.6
	public static Collection<Object> getIntersectionUsingMap(List... lists) {
		Map<Object, Object> intersection = new HashMap<>();

		if (lists == null || (List[]) lists == null || lists.length < 1) {
			return null;
		}

		for (Object obj : lists[0]) {
			intersection.put(getKey(obj), obj);
		}

		for (int i = 1; i < lists.length; i++) {

			Map<Object, Object> newIntersection = new HashMap<>();
			if (lists[i] == null || intersection.size() == 0) {
				return null;
			}
			for (Object obj : lists[i]) {
				if (obj != null) {
					Object key = getKey(obj);
					if (intersection.containsKey(key)) {
						newIntersection.put(key, obj);
					}
				}
			}
			intersection = newIntersection;
		}

		return intersection.values();
	}

	public static Object getKey(Object obj) {
		Object key = null;
		if (obj.getClass().equals(Compaign.class)) {
			Compaign compain = (Compaign) obj;
			key = compain.id;
		} else if (obj.getClass().equals(CompaignLine.class)) {
			CompaignLine compainLine = (CompaignLine) obj;
			key = compainLine.clID;
		} else if (obj.getClass().equals(String.class)) {
			key = obj;
		}
		return key;
	}

	public static void main(String[] args) {

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

		// Using Java 8
		// System.out.println(getIntersection(list1, list2, list3));

		// Using Java 6
		// System.out.println(getIntersection1(list1, list2, list3));

		// Using Retain All
		// System.out.println(getIntersectionOfMultipleListCustomObject(list1,
		// list2, list3));

		System.out.println(getIntersectionUsingMap(list1, list2, list3));

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

		// Using Java 8
		// System.out.println(getIntersection(list11, list12, list13));

		// Using Java 6
		// System.out.println(getIntersection1(list11, list12, list13));

		// Using Retain All
		// System.out.println(getIntersectionOfMultipleListCustomObject(list11,
		// list12, list13));

		System.out.println(getIntersectionUsingMap(list11, list12, null, list13));

	}

}
