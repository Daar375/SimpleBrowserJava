import java.util.Hashtable;

public class Cache {
	private static Cache cache;
	private static Hashtable<String, String> Data = new Hashtable();

	private Cache() {
	}

	public static void addData(String key, String data) {
		Data.put(key, data);
	}

	public static String getData(String key) {
		return Data.get(key);
	}

	public static boolean containsData(String key) {
		return Data.containsKey(key);
	}
	   public static Cache getInstance() {
		      if(cache == null) {
		    	  cache = new Cache();
		      }
		      return cache;
		   }
	   
	 public static int lenght(){
		 return Data.size();
		 
	 }
	 public static void print(){
		 System.out.println(Data.toString());
	 }
}
