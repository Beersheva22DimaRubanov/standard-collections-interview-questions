package telran.util;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class WordsImpl implements Words {
	HashMap<Character, TreeSet<String>> words = new HashMap<>();

	@Override
	public boolean addWord(String word) {
		boolean res =false;
		TreeSet<String> set = words.get(word.toLowerCase().charAt(0));
		if(set == null) {
			set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
			words.put(word.toLowerCase().charAt(0), set);
		}
		if(set.add(word)) {
			res = true;
		}
		return res;
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		TreeSet<String> set = words.get(prefix.toLowerCase().charAt(0));
		List<String> res = null;
		if(set != null) {
			res = set.stream().filter(x -> x.toLowerCase().startsWith(prefix.toLowerCase())).toList();
		}
		return res;
	}

}
