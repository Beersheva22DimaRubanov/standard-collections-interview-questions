package telran.util;

import java.util.HashMap;
import java.util.LinkedList;

public class ConnectionList implements CollectionPool {
	
	HashMap<Integer, Connection> hashMap;
	LinkedList<Connection> list;
	int maxSize;
	int size;
		
	public ConnectionList(int maxSize) {
		this.maxSize = maxSize;
		hashMap = new HashMap<>(maxSize);
		list =  new LinkedList<>();
	}
	

	@Override
	public boolean addConnection(Connection connection) {
		boolean res = false;
		if (!hashMap.containsKey(connection.id)) {
			if(size >= maxSize) {
				hashMap.remove(list.removeLast().id);
			}
			list.add(connection);
			hashMap.put(connection.id, list.getLast());
			size++;
			res = true;
		}
		return res;
	}
	
	@Override
	public Connection getConnection(int id) {
		Connection current = hashMap.get(id);
		list.remove(current);
		hashMap.remove(id);
		hashMap.put(id, current);
		list.addFirst(current);
		return current !=null ? current : null;
	}

}
