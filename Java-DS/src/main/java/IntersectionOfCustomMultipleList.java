
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Custom Classes
class Compaign {
	public int id;
	public String name;

	public Compaign(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "Id : " + this.id + " Name : " + this.name;
	}
}

// Custom Classes
class CompaignLine {
	public int clID;
	public String name;

	public CompaignLine(int clID, String name) {
		this.clID = clID;
		this.name = name;
	}

	public String toString() {
		return "clID : " + this.clID + " Name : " + this.name;
	}

}

public class IntersectionOfCustomMultipleList {

	/**** Using Map ******/
	// Using Java 1.6
	public static Collection<Object> getIntersectionUsingMap(List... lists) {
		Map<Object, Object> intersection = new HashMap<>();

		if (lists == null || (List[]) lists == null || lists.length < 1) {
			return new ArrayList<>(); // Empty List
		}

		for (Object obj : lists[0]) {
			intersection.put(getKey(obj), obj);
		}

		for (int i = 1; i < lists.length; i++) {
			if (lists[i] == null || intersection.size() == 0) {
				return new ArrayList<>(); // Empty List
			}
			Map<Object, Object> newIntersection = new HashMap<>();
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

	// Put Logic Here for Different type Of Custom Classes
	public static Object getKey(Object obj) {
		Object key = null;
		if (obj.getClass().equals(Compaign.class)) {
			Compaign compain = (Compaign) obj;
			key = compain.id;
		} else if (obj.getClass().equals(CompaignLine.class)) {
			CompaignLine compainLine = (CompaignLine) obj;
			key = compainLine.clID;
		} else if (obj.getClass().equals(String.class) || obj.getClass().equals(Integer.class)) {
			key = obj;
		}
		return key;
	}

	
	
	
	public static String getCommonList(List<String>... _val) {

		String commonString = _val[0].get(0);
		for (String string : _val[0]) {
			if (commonString.length() >= string.length()) {
				if (string.contains("*")) {
					if (string.lastIndexOf("*") == string.length() - 1) {
						if (!commonString.replace("*", "").contains(string.replace("*", ""))) {
							commonString = "";
						}
					}
				} else {
					if (commonString.replace("*", "").equals(string)) {
						commonString = string;
					} else {
						commonString = "";
					}
				}
			} else {
				if (commonString.contains("*")) {
					if (commonString.lastIndexOf("*") == commonString.length() - 1) {
						if (string.replace("*", "").contains(commonString.replace("*", ""))) {
							commonString = string;
						}
					}
				} else {
					if (!string.replace("*", "").contains(commonString)) {
						commonString = "";
					}
				}
			}
		}
		return commonString;
	}

	public static void main(String[] args) {
		/*
		 * // For Custom Objects
		 * 
		 * List<Compaign> list1 = new ArrayList<>(); list1.add(new Compaign(1,
		 * "A")); list1.add(new Compaign(2, "B")); // Common list1.add(new
		 * Compaign(3, "C")); list1.add(new Compaign(4, "D")); // Common
		 * list1.add(new Compaign(5, "E"));
		 * 
		 * List<Compaign> list2 = new ArrayList<>(); list2.add(new Compaign(2,
		 * "B")); // Common list2.add(new Compaign(3, "C")); list2.add(new
		 * Compaign(4, "D")); // Common
		 * 
		 * List<Compaign> list3 = new ArrayList<>(); list3.add(new Compaign(2,
		 * "B")); // Common list3.add(new Compaign(4, "D")); list3.add(new
		 * Compaign(6, "F")); // Common
		 * 
		 * System.out.println(getIntersectionUsingMap(list1, list2, list3));
		 * 
		 * // For String
		 * 
		 * List<String> list11 = new ArrayList<>(); list11.add("1");
		 * list11.add("2"); list11.add("3"); list11.add("4"); list11.add("5");
		 * list11.add("6");
		 * 
		 * List<String> list12 = new ArrayList<>(); list12.add("2");
		 * list12.add("4"); list12.add("6"); list12.add("8");
		 * 
		 * List<String> list13 = new ArrayList<>(); list13.add("2");
		 * list13.add("4"); list13.add("9"); list13.add("10");
		 * 
		 * System.out.println(getIntersectionUsingMap(list11, list12, list13));
		 */

		List<String> commonList = new ArrayList<>();
		commonList.add("adam a*");
		commonList.add("ad*");
		commonList.add("adam and eve*");
		commonList.add("adam a*");
		commonList.add("adam and evening*");
		commonList.add("adam and even");
		commonList.add("adam a*");

		System.out.println(getCommonList(commonList));

		commonList = new ArrayList<>();
		commonList.add("abcdef*");
		commonList.add("abc*");
		commonList.add("abcdeff*");

		System.out.println(getCommonList(commonList));

	}

}
