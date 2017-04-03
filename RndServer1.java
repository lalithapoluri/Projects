package homeWork6;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class RndServer1 {

	public static void main(String[] args) throws Exception{
		
		 		byte[] val = new byte[1];
		 		byte[] dataReceived,datasent;
		        DatagramPacket receivedPacket,sendingPacket;
		        receivedPacket =new DatagramPacket(val,1);
		        DatagramSocket serverSocket = new DatagramSocket(5390);
		        while(true){
		        	System.out.println("Receiving request from client");
		        	serverSocket.receive(receivedPacket);
		        	InetAddress client = receivedPacket.getAddress(); 
		        	int clientPort = receivedPacket.getPort();
			        dataReceived = receivedPacket.getData();
			        int num = (int)dataReceived[0];
		            datasent = new byte[num];
		            System.out.println("The number of expected bytes is: "+num);
		            Random numGen = new Random();
	            	numGen.nextBytes(datasent);
	            	System.out.println("\nThe sent data: ");
	            	for(int i=0;i<num;i++){	            		
	            		System.out.println("Byte"+i+" value is: "+datasent[i]);
	            		}
	            	sendingPacket = new DatagramPacket(datasent,num,client,clientPort);
		            serverSocket.send(sendingPacket);
		            System.out.println("Sending the response to the client.../n");
		        }
		    }
	
	
}
