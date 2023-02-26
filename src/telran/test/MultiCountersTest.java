package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MultiCounters;

class MultiCountersTest implements MultiCounters {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void test() {
		Integer[] arr = {5, 6, 6,7,8,12,12,23,14,6,6,8};
		addItem(6);
		addItem(6);
		addItem(7);
		addItem(3);
		addItem(3);
		addItem(7);
		addItem(8);
		
		assertEquals(2, getValue(6));
		assertEquals(1, getValue(8));
		
		remove(7);
		
		assertNull(getValue(7));
		getMaxItems().stream().forEach(x -> System.out.println(x));
	}

}
