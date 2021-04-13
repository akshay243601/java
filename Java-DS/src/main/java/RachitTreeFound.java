import java.util.HashMap;

class Tree {
	int parentId;
	String data;
	int id;

}

public class RachitTreeFound {

	public static String prepareTree(Tree[] trees) {

		HashMap<Integer, Tree> hashMap = new HashMap<>();

		HashMap<Integer, String> hashMapString = new HashMap<>();
		hashMapString.put(0, "");
		for (Tree tree : trees) {
			hashMap.put(tree.id, tree);
			hashMapString.put(tree.id, "");
		}

		String result = "";
		for (Tree tree : trees) {

			if (tree.parentId == 0) {
				
				String oldParent = hashMapString.get(tree.parentId);
				String old = hashMapString.get(tree.id);
				String li = "<li>" + tree.data + "</li>";
				if (oldParent.endsWith("</ul>")) {
					int index = oldParent.lastIndexOf("</ul>");
					oldParent = oldParent.substring(0, index);
					oldParent = oldParent + li + old + "</ul>";
				} else {
					oldParent = "<ul>" + li + old + "</ul>";
				}
				hashMapString.put(tree.parentId, oldParent);

				
//				String old = hashMapString.get(tree.id);
	//			result = result + "<ul>" + "<li>" + tree.data + old + "</li>" + "</ul>";
		//		hashMapString.put(0, result);
			} else {
				String oldParent = hashMapString.get(tree.parentId);
				String old = hashMapString.get(tree.id);
				String li = "<li>" + tree.data + "</li>";
				if (oldParent.endsWith("</ul>")) {
					int index = oldParent.lastIndexOf("</ul>");
					oldParent = oldParent.substring(0, index);
					oldParent = oldParent + li + old + "</ul>";
				} else {
					oldParent = "<ul>" + li + old + "</ul>";
				}
				hashMapString.put(tree.parentId, oldParent);
			}
		}
		return hashMapString.get(0);
	}

	public static void main(String args[]) {
		Tree obj[] = new Tree[6];

		obj[0] = new Tree();
		obj[0].id = 4;
		obj[0].parentId = 3;
		obj[0].data = "4";

		obj[1] = new Tree();
		obj[1].id = 5;
		obj[1].parentId = 3;
		obj[1].data = "5";

		obj[2] = new Tree();
		obj[2].id = 8;
		obj[2].parentId = 7;
		obj[2].data = "8";

		
		obj[3] = new Tree();
		obj[3].id = 6;
		obj[3].parentId = 4;
		obj[3].data = "6";

		obj[4] = new Tree();
		obj[4].id = 7;
		obj[4].parentId = 5;
		obj[4].data = "7";

		obj[5] = new Tree();
		obj[5].id = 3;
		obj[5].parentId = 0;
		obj[5].data = "3";


		System.out.println(RachitTreeFound.prepareTree(obj));

	}
}
