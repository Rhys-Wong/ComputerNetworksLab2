import java.io.IOException;
import java.net.*;
public class UdpServer {
	 public static void main(String[] argv) throws IOException {
	 //
	 // 1. Open UDP socket at well-known port
	 //
	 DatagramSocket socket = new DatagramSocket();
	 while (true) {
		 try {
		 //
		 // 2. Listen for UDP request from client
		 //
		 InetAddress address = InetAddress.getByName("localhost");
		 byte buf[] = { 12, 13 };
		 byte buf1[] = new byte[2];
		 int port = 8080;
		 
		 DatagramPacket request = new DatagramPacket(buf, 2, address, port);
		 socket.receive(request);
		 System.out.println("Recevied packet");
		 
		 //
		 // 3. Send UDP reply to client
		 //
		 DatagramPacket reply = new DatagramPacket(buf1, 2);
		 socket.send(reply);
		 } catch (IOException e) {}
	 }
	 }
}