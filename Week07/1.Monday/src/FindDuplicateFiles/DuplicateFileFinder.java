package FindDuplicateFiles;

import static java.nio.file.FileVisitResult.*;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import UtilityMethods.FileUtils;

public class DuplicateFileFinder {

	public static final long MAX_FILE_SIZE = 512000; // in bytes; so 512000B = 512KB
	private int groupCount = 0;
	private int duplicateFileCount = 0;
	private long potentialFreeSpace = 0;

	public void findDuplicates(Path path) throws IOException{

		resetCounters(); // safety measure, in case of multiple searches

		Map<Long, ArrayList<Path>> filesMap = new HashMap<Long, ArrayList<Path>>(); // will store Size-Paths pairs for files
		traverseFileTree(path, filesMap);

		for (Map.Entry<Long, ArrayList<Path>> entry : filesMap.entrySet()) {
			printDuplicates(entry.getValue());
		}

		System.out.format("%d groups of duplications found.%n", groupCount);
		System.out.format("A total of %d files can be deleted, freeing up %dKB(%dB) disk space.%n", duplicateFileCount, potentialFreeSpace / 1000, potentialFreeSpace);
	}

	private void printDuplicates(ArrayList<Path> pathList) throws IOException{

		Deque<Path> stack = new ArrayDeque<>();

		Path currentFile = null;
		while(pathList.size() > 0){
			currentFile = pathList.get(0);
			stack.push(currentFile);

			for (int i = 1; i < pathList.size(); i++) {
				if(isSameFile(currentFile, pathList.get(i))){
					stack.push(pathList.get(i));
				}
			}

			pathList.removeAll(stack);
			if(stack.size() > 1){ // i.e. duplicates were found in this pathList
        groupCount++;
				duplicateFileCount += stack.size() - 1;
				potentialFreeSpace += (stack.size() - 1) * Files.size(currentFile);

				System.out.format("Group %d:%n", groupCount);
				while(!stack.isEmpty()){
					System.out.println(stack.pop());
				}
				System.out.format("%n");
			}
		}
	}

	private boolean isSameFile(Path path1, Path path2) throws IOException{

		byte[] file1 = Files.readAllBytes(path1);
		byte[] file2 = Files.readAllBytes(path2);

		return Arrays.equals(file1, file2);
	}

	private void traverseFileTree(Path path, Map<Long, ArrayList<Path>> filesMap) throws IOException{

		SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>(){

			public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException{

				if(attr.isRegularFile() && attr.size() < MAX_FILE_SIZE){

					if(attr.isSymbolicLink()){
						if(!isBrokenLink(file)){
							insertPathInMap(Files.readSymbolicLink(file), filesMap);
						}

					} else {
						insertPathInMap(file, filesMap);
					}
				}

				return CONTINUE;
			}
		};

		Files.walkFileTree(path, fileVisitor);
	}

	private void insertPathInMap(Path path, Map<Long, ArrayList<Path>> filesMap) throws IOException{

		long fileSize = Files.size(path);

		ArrayList<Path> list = filesMap.get(fileSize);
		if(list == null){ // i.e the mapping does not exist
			ArrayList<Path> newList = new ArrayList<>();
			newList.add(path);
			filesMap.put(fileSize, newList);
		} else { // i.e. the mapping exists
			list.add(path);
		}
	}

	private boolean isBrokenLink(Path path) throws IOException{
		return !Files.exists(Files.readSymbolicLink(path));
	}

	private void resetCounters(){
		int groupCount = 0;
		int duplicateFileCount = 0;
		long potentialFreeSpace = 0;
	}

}
