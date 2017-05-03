import java.io.IOException;

public class SearchResult extends Thread {
	private String HTML;
	private String Word;
	private long Time;

	public void run() {
		HTML tool = new HTML();
		long startTime = System.currentTimeMillis();


		try {
			HTML = tool.getHTML(Word);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cache.addData(Word, this.getHTML());
		long stopTime = System.currentTimeMillis();
		Time = stopTime - startTime;


	}

	public String getHTML() {
		return HTML;
	}

	public void setHTML(String hTML) {
		HTML = hTML;
	}

	public String getWord() {
		return Word;
	}

	public void setWord(String word) {
		Word = word;
	}

	public long getTime() {
		return Time;
	}

	public void setTime(long time) {
		Time = time;
	}
}
