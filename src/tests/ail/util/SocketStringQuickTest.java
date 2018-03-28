package ail.util;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SocketStringQuickTest extends Thread {
	
	AILSocketChannelServer server;
	String message;
	/*
	 * Despatch a separate thread for the server so we don't block the test
	 * Wait for connection, then wait for a message, then end the thread
	 */
	public void run() {
		 server = new AILSocketChannelServer();
		 message = server.readLine();
		 server.close();
	}
	
	/*
	 * Ensure that a string that is transmitted equals what is received
	 */
	@Test
	public void TransmitStringTest() {

		SocketStringQuickTest server = new SocketStringQuickTest();
		server.start();
		AILSocketChannelClient client = new AILSocketChannelClient();
		
		
		String message = "Is there anybody out there?";
		
		client.write(message);
		
		while (server.isAlive()) {
			
		}
		
		assertTrue(message.equals(server.message));

		client.close();
	}

}
