package TextFileCompression;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TextFileCompressor {

	private StringBuilder result;
	private String compressionExtension = ".compr"; // default compression
													// extension

	public void compress(Path filePath) throws IOException {

		result = new StringBuilder();

		// reading:
		StringBuilder fileContent = new StringBuilder();
		try (BufferedReader reader = Files.newBufferedReader(filePath)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				fileContent.append(line);
			}
		}

		// compressing:
		compressionAlgorithm(fileContent);

		// writing:
		try (BufferedWriter writer = Files.newBufferedWriter(getCompressedPath(filePath))) {
			writer.write(result.toString());
		}
	}

	private void compressionAlgorithm(StringBuilder fileContent) {

		Map<String, Integer> wordMap = new HashMap<>();
		int currentIndex = 0;
		char prependSymbol = '~';

		String[] allWords = fileContent.toString().split("\\s+");
		char lastChar;
		boolean appendLastChar = false;
		for (String word : allWords) {
			result.append(prependSymbol);

			lastChar = word.charAt(word.length() - 1);
			if (!Character.isLetter(lastChar)) { // performing a check whether
													// the last char is a period
													// or something similar
				word = word.substring(0, word.length() - 1);
				appendLastChar = true;
			}

			if (wordMap.containsKey(word)) {
				result.append(wordMap.get(word));
			} else {
				wordMap.put(word, currentIndex);
				result.append(currentIndex);

				currentIndex++;
			}

			if (appendLastChar) {
				result.append(lastChar);
				appendLastChar = false;
			}

			result.append(' ');
		}
	}

	private Path getCompressedPath(Path path) {
		String pathString = path.toString();
		return Paths.get(pathString + compressionExtension);
	}

	public void decompress(Path filePath, Map<Integer, String> wordMap)
			throws IOException, MissingDecompressionElementException {

		result = new StringBuilder();

		// reading:
		StringBuilder fileContent = new StringBuilder();
		try (BufferedReader reader = Files.newBufferedReader(filePath)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				fileContent.append(line);
			}
		}

		// decompressing:
		decompressionAlgorithm(fileContent, wordMap);

		// writing:
		try (BufferedWriter writer = Files.newBufferedWriter(getDecompressedPath(filePath))) {
			writer.write(result.toString());
		}

	}

	private void decompressionAlgorithm(StringBuilder fileContent, Map<Integer, String> wordMap)
			throws MissingDecompressionElementException {

		String[] allWords = fileContent.toString().split("\\s+");
		char prependSymbol = allWords[0].charAt(0); // retrieving the prepend
													// symbol used in the
													// compression

		char lastChar;
		boolean appendLastChar = false;
		String realWord;
		for (String word : allWords) {
			lastChar = word.charAt(word.length() - 1);

			if (!Character.isDigit(lastChar)) {
				word = word.substring(1, word.length() - 1);
				appendLastChar = true;
			} else {
				word = word.substring(1, word.length());
			}

			realWord = wordMap.get(Integer.parseInt(word));
			if (realWord == null) {
				throw new MissingDecompressionElementException("ERROR: Missing key element in decompression map!");
			}

			result.append(realWord);
			if (appendLastChar) {
				result.append(lastChar);
				appendLastChar = false;
			}

			result.append(' ');
		}

	}

	private Path getDecompressedPath(Path path) {
		String pathString = path.toString();
		String resultString = pathString.substring(0, pathString.indexOf(compressionExtension));
		return Paths.get(resultString);
	}

}
