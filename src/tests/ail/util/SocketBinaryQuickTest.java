package ail.util;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

public class SocketBinaryQuickTest extends Thread {
	
	AILSocketChannelServer server;
	ByteBuffer data;
	/*
	 * Despatch a separate thread for the server so we don't block the test
	 * Wait for connection, then wait for some data, then end the thread
	 */
	public void run() {
		 server = new AILSocketChannelServer();
		 data = ByteBuffer.allocate(16);
		 server.read(data);
		 data.order(ByteOrder.LITTLE_ENDIAN);
		 data.rewind();
		 server.close();
	}
	
	@Test
	public void TransmitBinaryTest() {
		SocketBinaryQuickTest server = new SocketBinaryQuickTest();
		server.start();
		AILSocketChannelClient client = new AILSocketChannelClient();
		
		
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
