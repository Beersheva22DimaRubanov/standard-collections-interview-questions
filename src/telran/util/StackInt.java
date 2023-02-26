package telran.util;

import java.util.LinkedList;

public class StackInt {
	private LinkedList<Integer> list;
	private LinkedList<Integer> maxList;

	public StackInt() {
		this.list = new LinkedList<>();
		this.maxList = new LinkedList<>();
	}

	public void push(int num) {
		if (maxList.isEmpty() || num >= maxList.getFirst()) {
			maxList.addFirst(num);
		}
		list.addFirst(num);
	}

	public int pop() {
		Integer res = list.getFirst();
		if (res == maxList.getFirst()) {
			maxList.removeFirst();
		}
		list.removeFirst();
		return res;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getMax() {
		return maxList.getFirst();
	}
}
