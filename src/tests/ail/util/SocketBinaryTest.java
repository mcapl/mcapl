package ail.util;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

public class SocketBinaryTest extends Thread {
	
	AILSocketServer server;
	ByteBuffer data;
	/*
	 * Despatch a separate thread for the server so we don't block the test
	 * Wait for connection, then wait for some data, then end the thread
	 */
	public void run() {
		 server = new AILSocketServer();
		 data = server.read(16);
		 data.order(ByteOrder.LITTLE_ENDIAN);
		 data.rewind();
		 server.close();
	}
	
	@Test
	public void TransmitBinaryTest() {
		SocketBinaryTest server = new SocketBinaryTest();
		server.start();
		AILSocketClient client = new AILSocketClient();
		
		
		ByteBuffer data = ByteBuffer.allocate(16);
		data.order(ByteOrder.LITTLE_ENDIAN);
		data.putInt(1234);
		data.putDouble(Math.PI);
		data.putInt(-4321);
		
		client.write(data);
		
		while (server.isAlive()) {
			
		}
		data.rewind();
		assertTrue(data.equals(server.data));

		client.close();
	}

}
