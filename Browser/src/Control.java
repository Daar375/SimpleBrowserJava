import java.util.Vector;

public class Control {

	private Vector<SearchResult> Result = new Vector();

	private Cache cache =Cache.getInstance();
	public void Search(String text) {
		Result.removeAllElements();
		String word = "";
		int Numletter = 0;
		text+=" ";
		while (Numletter != text.length() ) {
			long startTime = System.currentTimeMillis();

			if (text.charAt(Numletter) != " ".charAt(0)) {
				word += text.charAt(Numletter);

			}
			else if (cache.containsData(word)){
				
				SearchResult searching = new SearchResult();
				searching.setHTML(cache.getData(word));
				searching.setWord(word);
				long stopTime = System.currentTimeMillis();
				long Time = stopTime - startTime;
				searching.setTime(Time);
				Result.add(searching);
				word="";

			}
			
			else if (!word.isEmpty()) {

				SearchResult searching = new SearchResult();
				searching.setWord(word);
				searching.start();
				Result.add(searching);
				word="";
			}
			Numletter++;

		}
	}

	public Vector<SearchResult> getResult() {
		return Result;
	}

	public void setResult(Vector<SearchResult> result) {
		Result = result;
	}
        public static void main(String args[]) {
        	Control control = new Control();


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI(control).setVisible(true);
            }
        });
    }
}
