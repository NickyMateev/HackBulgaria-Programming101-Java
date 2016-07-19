import java.util.HashMap;
import java.util.Map;

public final class UtilsClass {

	private UtilsClass() {
	}

	public static String printMap(Map<? extends Object, ? extends Object> map) {

		StringBuilder sb = new StringBuilder();

		sb.append("{ ");

		for (Map.Entry<? extends Object, ? extends Object> entry : map.entrySet()) {
			sb.append(entry.getKey() + ":" + entry.getValue() + ", ");
		}

		if (!map.isEmpty())
			sb.setLength(sb.length() - 2); // delete the last ", " substring
											// from the result string

		sb.append(" }");

		return sb.toString();
	}

	public static Map<String, Integer> getWordCount(String text) {

		Map<String, Integer> words = new HashMap<>();
		String[] wordsFromText = text.split("\\s+");

		for (String word : wordsFromText) {

			if (words.containsKey(word))
				words.put(word, words.get(word) + 1);
			else
				words.put(word, 1);
		}

		return words;
	}

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);

		System.out.println(printMap(map)); // { One:1, Two:2, Three:3 }

		Map<String, Integer> map2 = getWordCount("Ninjas are all over the place! We are all going to die!");
		System.out.println(printMap(map2));
	}

}
