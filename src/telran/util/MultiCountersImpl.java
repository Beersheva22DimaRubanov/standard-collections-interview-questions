package telran.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MultiCountersImpl implements MultiCounters {
	Map<Object, Integer> map = new HashMap<>();
	TreeMap<Integer, HashSet<Object>> mapWithSet = new TreeMap<>();

	public Integer addItem(Object item) {
		Integer count = map.getOrDefault(item, 0);
		moveItemCounters(item, count);
		map.put(item, ++count);
		return map.get(item);
	}

	private void moveItemCounters(Object item, Integer count) {
		if (count != 0) {
			removeCountersItem(count, item);
		}
		addCountersItem(count + 1, item);

	}

	private void addCountersItem(int counter, Object item) {
		HashSet<Object> set = mapWithSet.get(counter);
		if (set == null) {
			set = new HashSet<>();
			mapWithSet.put(counter, set);
		}
		set.add(item);
	}

	public Integer getValue(Object item) {
		return map.get(item);
	}

	public boolean remove(Object item) {
		boolean res = false;
		Integer count = map.remove(item);
		if (count != null) {
			res = true;
			removeCountersItem(count, item);
		}
		return res;
	}

	private void removeCountersItem(Integer count, Object item) {
		HashSet<Object> set = mapWithSet.get(count);
		set.remove(item);
		if(set.isEmpty()) {
			mapWithSet.remove(count);
		}
	}

	public Set<Object> getMaxItems() {
		var lastEntry = mapWithSet.lastEntry();
		return lastEntry != null ? lastEntry.getValue() : Collections.emptySet();
	}
}
