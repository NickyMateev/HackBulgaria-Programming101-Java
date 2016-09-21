package WordCountCommand;

import java.io.*;
import java.nio.file.*;

public class WCCommand {

	public static WordCountResult wordCount(Path path) throws IOException{

		WordCountResult wc = new WordCountResult();
		int words = 0, lines = 0, chars = 0;

		try(BufferedReader reader = Files.newBufferedReader(path)){

			String line = null;
			while((line = reader.readLine()) != null){
				lines++;
				chars += line.length() + 1; // +1 because we have to take into account the new line character also
				words += line.split("\\s+").length;
			}
		}

		wc.setWordCount(words);
		wc.setLinesCount(lines);
		wc.setCharactersCount(chars);

		return wc;
	}

	public static WordCountResult wordCount(File file) throws IOException{
		return wordCount(file.toPath());
	}

}
