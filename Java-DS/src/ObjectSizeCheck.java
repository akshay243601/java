import java.lang.instrument.Instrumentation;

import com.akshay.tree.TreeNode;

public class ObjectSizeCheck {

	public static Instrumentation instrument;

	public static void premain(String args, Instrumentation inst) {
		instrument = inst;
	}

	public static long getobjectsize(Object obj) {
		return instrument.getObjectSize(obj);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tn = new TreeNode(12);
		ObjectSizeCheck.getobjectsize(tn);
	}

}
