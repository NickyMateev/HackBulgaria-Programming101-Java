package UtilityMethods;

import java.io.*;
import java.nio.file.*;

public class FileUtils {

	private static final FileUtils instance = new FileUtils();

	private FileUtils() {
	}

	public static FileUtils getInstance() {
		return instance;
	}

	public String readFrom(File file) throws IOException{
		return readFrom(file.toPath());
	}

	public String readFrom(Path path) throws IOException{

		StringBuilder sb = new StringBuilder();
		try(BufferedReader reader = Files.newBufferedReader(path)){
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line);
				sb.append(String.format("%n")); // new line
			}
		}

		return sb.toString();
	}

	public void writeTo(File file, String content) throws IOException{
		writeTo(file.toPath(), content);
	}

	public void writeTo(Path path, String content) throws IOException{

		try(BufferedWriter writer = Files.newBufferedWriter(path)){
			writer.write(content);
		}
	}
}
