package FindDuplicateFiles;

import java.io.IOException;
import java.nio.file.Paths;

public class MainClass {

	public static void main(String[] args) throws IOException {
		new DuplicateFileFinder().findDuplicates(Paths.get("/home/userpc/Documents"));
	}

}
