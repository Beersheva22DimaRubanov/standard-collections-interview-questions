package telran.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public interface MultiCounters {
	Map<Object, Integer> map = new HashMap<>();
	TreeMap<Integer, HashSet<Object>> mapWithSet = new TreeMap<>();

	default Integer addItem(Object item) {
		if (!map.containsKey(item)) {
			map.put(item, 1);
		} else {
			map.put(item, map.get(item) + 1);
		}
		if (!mapWithSet.containsKey(map.get(item))) {
			mapWithSet.put(map.get(item), new HashSet<>());
		}
		mapWithSet.get(map.get(item)).add(item);
		return map.get(item);
	}

	default Integer getValue(Object item) {
		return map.get(item);
	}

	default boolean remove(Object item) {
		boolean res = false;
		if (map.containsKey(item)) {
			mapWithSet.get(map.get(item)).remove(item);
			if (mapWithSet.get(map.get(item)) == null) {
				mapWithSet.remove(map.get(item));
			}
			map.remove(item);
			res = true;
		}
		return res;
	}

	default Set<Object> getMaxItems() {
		return mapWithSet.lastEntry().getValue();
	}
}
