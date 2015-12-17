package logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CatalogReader {

	private List<String> lines;
	private int fileSize;

	public CatalogReader(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		lines = new ArrayList<>();

		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
			fileSize++;
		}
		reader.close();
	}

	public String[] processLine(int index) {
		if ((lines!=null) && (index < fileSize)) {
			String[] tokens = lines.get(index).split(";");
			return tokens;

		}
		return null;

	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
}