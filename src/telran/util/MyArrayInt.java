package telran.util;

import java.util.HashMap;

public class MyArrayInt {
	private int value;
	private int size;
	HashMap<Integer, Integer> array;
	
	//TODO
	public MyArrayInt(int size, int value) {
		this.size = size;
		this.value = value;
	}
	
	public void set(int index, int value) {
		//TODO
		//sets a given value at a given index
		//throws exception IndexOutOfBoundsException
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(array == null) {
			array = new HashMap<>();
		}
		array.put(index, value);
	}
	
	public int get (int index) {
		//TODO
		//returns a value at a given index
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int res = value;
		if(array != null) {
			res = array.getOrDefault(index, value);
		}
		return res;
	}
	
	public void setAll(int value) {
		//TODO
		//sets a given value for all array's element
		this.value = value;
		array = null;
	}

}
