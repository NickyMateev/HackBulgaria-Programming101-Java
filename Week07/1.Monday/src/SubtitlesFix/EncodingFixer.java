package SubtitlesFix;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncodingFixer {
	
	public static void fixEncoding(Path path) throws IOException {
		
		Path backup = createBackup(path);
		
		StringBuilder sb = new StringBuilder();
		// reading the file:
		Charset charset = Charset.forName("Windows-1251");
		try(BufferedReader reader = Files.newBufferedReader(path, charset)){
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line);
				sb.append(String.format("%n"));
			}
		} catch (IOException ex) {
			Files.copy(backup, path, REPLACE_EXISTING); // in case of exception -> replace original with backup
			Files.delete(backup);
			return;
		}
		
		// writing the file:
		charset = Charset.forName("UTF-8");
		try(BufferedWriter writer = Files.newBufferedWriter(path, charset)){
			writer.write(sb.toString(), 0, sb.length());
		} catch (IOException ex) {
			Files.copy(backup, path, REPLACE_EXISTING); // in case of exception -> replace original with backup
		}
		
		Files.delete(backup);
	}
	
	private static Path createBackup(Path original) throws IOException{
		
		Path backup = Files.createTempFile(Paths.get("."), "tempFile", ".srt");
		Files.copy(original, backup, REPLACE_EXISTING);
		
		return backup;
	}

}