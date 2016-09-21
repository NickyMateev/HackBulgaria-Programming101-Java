package FindBrokenLinks;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import javax.swing.text.SimpleAttributeSet;

public class BrokenLinkFinder {

	public static void printBrokenLinks(Path path) throws IOException {

		SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {

			public FileVisitResult visitResult(Path file, BasicFileAttributes attr) throws IOException {

				if (Files.isSymbolicLink(file)) {
					if (!Files.exists(Files.readSymbolicLink(file))) {
						System.err.println("Bad link: " + file);
					}
				}

				return CONTINUE;
			}
		};
		
		Files.walkFileTree(path, fileVisitor);
	}

}
