package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandartCollectionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 70, -20));
		list.add(5);
		List<Integer> listSub = list.subList(6, 9);

		System.out.println(listSub);
		listSub.add(1, -2);
		listSub.sort(Integer::compare);
		System.out.println(list);
	}

	@Test
	void displayOccurrencesCount() {
		String[] strings = { "lmn", "abc", "abc", "lmn", "a", "lmn" };
		Arrays.stream(strings).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
		.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
	}
	
	@Test
	void displayDigitStatistics() {
		(new Random().ints(1000000, 1, Integer.MAX_VALUE)).flatMap(x -> String.valueOf(x).chars()
		.map(Character::getNumericValue)).boxed()
		.collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
		.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
	}
}
