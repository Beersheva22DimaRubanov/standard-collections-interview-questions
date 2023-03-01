package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Connection;
import telran.util.ConnectionList;

class ConnectionListTests {
	ConnectionList connections;
	@BeforeEach
	void setUp() throws Exception {
		connections = new ConnectionList(4);
		connections.addConnection(new Connection(2, "Somport2", 123));
		connections.addConnection(new Connection(4, "Some", 123));
		connections.addConnection(new Connection(67, "Some", 123));
		connections.addConnection(new Connection(12, "", 123));
		connections.addConnection(new Connection(13, "Sdu", 123));
	}

	@Test
	void addConnectionTest() {
		assertFalse(connections.addConnection(new Connection(2, "Somport2", 123)));
		assertEquals(67, connections.getConnection(67).getId());
		assertTrue(connections.addConnection(new Connection(14, "Somport2", 12344)));
		assertNull(connections.getConnection(13));
	}

}
