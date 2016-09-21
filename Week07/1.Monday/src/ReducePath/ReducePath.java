package ReducePath;

import java.nio.file.Path;

public class ReducePath {
	
	public static Path reduce_file_path(Path path){
		return path.normalize();
	}

}
