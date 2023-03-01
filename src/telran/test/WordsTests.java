package telran.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.WordsImpl;

class WordsTests {
	WordsImpl words;
	
	@BeforeEach
	void setUp() throws Exception {
		words = new WordsImpl();
		words.addWord("abc");
		words.addWord("fdaf");
		words.addWord("abcd");
		words.addWord("ABcdc");
	}

	@Test
	void test() {
		assertFalse(words.addWord("abc"));
		assertTrue(words.addWord("dasdas"));
		assertNull(words.getWordsByPrefix("vbn"));
		assertArrayEquals(new String[] {"abc", "abcd", "ABcdc"}, words.getWordsByPrefix("abc").toArray());
	}

}
