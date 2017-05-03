import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 * A complete Java class that demonstrates how to create an HTML viewer with
 * styles, using the JEditorPane, HTMLEditorKit, StyleSheet, and JFrame.
 * 
 * @author alvin alexander, devdaily.com.
 *
 */
public class HTML {

	public static String getHTML(String busqueda) throws IOException {
		String url = "http://www.google.com/search?q=";
		String charset = "UTF-8";
		String res = "";
		String key = busqueda;
		String query = String.format("%s", URLEncoder.encode(key, charset));
		URLConnection con = new URL(url + query).openConnection();
		con.setRequestProperty(
				"User-Agent",
				"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine = in.readLine();
		res = inputLine + '\n';
		while ((inputLine = in.readLine()) != null)
			res += inputLine + '\n';

		in.close();
		return res;
	}
}
