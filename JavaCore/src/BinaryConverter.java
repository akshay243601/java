public class BinaryConverter {

	public static void main(String args[]) {
		try {
			
			String s = null;
			
			System.out.println((s==null));

			System.out.println(String.valueOf(s)==null);
			
		//	System.out.println(isURL("asdc/sdsf123ada232AAAAzzz111aaZZWWW"));
		} catch (Exception e) {
		}
	}
	
	
	 public static boolean isURL(String url)
	  {
	    if (url == null) {
	      return false;
	    }
	    String urlPattern = "[0-9a-zA-Z/_-]*";
	    return url.matches(urlPattern);
	  }
}
