import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds = new DatagramSocket(8080);
		byte[] buffer = new byte[512];
		String message = "ChengisSuperGay";
		buffer = message.getBytes();
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
		InetAddress address = InetAddress.getByName("hwlab1.scse.ntu.edu.sg");;
		int port = 17;
		DatagramPacket senddp = new DatagramPacket(buffer, buffer.length,
				address, port);
		ds.send(senddp);
		
		
		ds.receive(dp);
		String qotd = new String(dp.getData(),0,dp.getLength());
		
		System.out.println(qotd);

		
	}

}
