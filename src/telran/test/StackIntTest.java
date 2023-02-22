package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.StackInt;

class StackIntTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		StackInt stack = new StackInt();
		assertTrue(stack.isEmpty());
		stack.push(4);
		stack.push(6);
		stack.push(9);
		stack.push(0);
		stack.push(-5);
		stack.push(19);
		stack.push(5);
		stack.push(20);
		assertEquals(20, stack.getMax());
		assertEquals(20, stack.pop());
		assertEquals(5, stack.pop());
		assertEquals(19, stack.getMax());
		assertEquals(19, stack.pop());
		assertEquals(9, stack.getMax());
		assertFalse(stack.isEmpty());
	}

}
