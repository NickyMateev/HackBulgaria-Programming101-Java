package PropertiesParser;

import java.awt.GradientPaint;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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