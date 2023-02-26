package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
		Arrays.stream(strings).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
	}

	@Test
	void displayDigitStatistics() {
		(new Random().ints(1000000, 1, Integer.MAX_VALUE))
				.flatMap(x -> String.valueOf(x).chars().map(Character::getNumericValue)).boxed()
				.collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
	}

	@Test
	void maxNumberWithNegativeImageTest() {
		int ar[] = { 1000000, 3, -2, -200, 200, -3 };
		int ar1[] = { 1000000, -1000000, 3, -4 };
		assertEquals(200, maxNumberWithNegativeImage(ar));
		assertEquals(1000000, maxNumberWithNegativeImage(ar1));
	}

	int maxNumberWithNegativeImage(int ar[]) {
		int res = -1;
		Set<Integer> set = new HashSet<>();
		for (int x : ar) {
			if (x > 0 && set.contains(-x) && x > res) {
				res = x;
			} else if (x < 0 && set.contains(-x) && -x > res) {
				res = -x;
			}
			set.add(x);
		}
		// TODO
		// return maximal positive number having it negative image or -1 if none such
		// numbers

		return res;
	}

	@Test
	void treeIteratingTest() {
		int array[] = { 1, 11, 111, 32, 9, 1234, 99, 992 };
		createAndIterateTreeInOrder(array);
	}

	private void createAndIterateTreeInOrder(int[] array) {
		// TODO
		// create tree, add in tree numbers from a given array
		// and iterate in the order of array defined in 69
		TreeSet<Integer> tree = new TreeSet<>((x, y) -> getSumOfDigits(x).compareTo(getSumOfDigits(y)));
		for (int x : array) {
			tree.add(x);
		}
		for (int x : tree) {
			System.out.println(x);
		}

	}

	private Integer getSumOfDigits(int num) {
		int res = 0;
		while (num != 0) {
			res += num % 10;
			num /= 10;
		}
		return res;
	}
}
