package telran.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackInt {
	private LinkedList<Integer> list;
	private LinkedList<Integer> maxList;
	
	public StackInt() {
		this.list = new LinkedList<>();
		this.maxList = new LinkedList<>();
	}

	public void push(int num) {
		int max = num;
		if(!maxList.isEmpty() && max < maxList.getFirst()) {
			max = maxList.getFirst();
		}
		list.addFirst(num);
		maxList.addFirst(max);
	}
	
	public int pop() {
			Integer res = list.getFirst();
			list.removeFirst();
			maxList.removeFirst();
			return res;
	}
	
	public boolean isEmpty()  {
		return list.isEmpty();
	}
	
	public int getMax() {
		//returns maximal value of the stack or throws NoSuchElementException
		//if the stack is empty
		return maxList.getFirst();
	}
}