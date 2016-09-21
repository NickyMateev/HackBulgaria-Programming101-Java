package PropertiesParser;

import java.awt.GradientPaint;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import UtilityMethods.InvalidFileTypeException;

public class PropertiesParser {

	private static final PropertiesParser parser = new PropertiesParser();

	private PropertiesParser(){
	}

	public static PropertiesParser getInstance(){
		return parser;
	}

	private List<String> getPairs(Path path) throws IOException{

		ArrayList<String> pairs = new ArrayList<>();

		try(BufferedReader reader = Files.newBufferedReader(path)){
			String line = null;
			while((line = reader.readLine()) != null){
				if(line.charAt(0) != '#'){
					pairs.add(line);
				}
			}
		}
		return pairs;
	}

	public Map<String, String> parseProperties(Path path) throws IOException, InvalidFileTypeException{

		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{properties}");
		if(!matcher.matches(path.getFileName())){
			throw new InvalidFileTypeException("ERROR: The provided file is not a .properties file!");
		}

		Map<String, String> map = new HashMap<>();
		List<String> pairs = getPairs(path);

		for (String pair : pairs) {
			int index = pair.indexOf('=');
			map.put(pair.substring(0, index), pair.substring(index + 1, pair.length()));
		}


		return map;
	}
}
