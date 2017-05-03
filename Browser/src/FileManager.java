import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

	public String LeerArchivo(File file) throws FileNotFoundException {

		String texto = new Scanner(file).useDelimiter("\\Z").next();

		return texto;

	}

	public void escribirArchivo(File file, String writing) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file.getPath()));
			writer.write(writing);
		} catch (IOException e) {
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}
}
