package Server;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class RndServer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		        byte[] receivedData,sendData;
		        byte[] bufVal = new byte[1];
		        DatagramPacket receivedPacket,sendPacket;
		        receivedPacket =new DatagramPacket(bufVal,1);
		        DatagramSocket serverSocket = new DatagramSocket(3939);
		        while(true){
		        	System.out.println("Receiving request from client");
		            serverSocket.receive(receivedPacket);
		            InetAddress client = receivedPacket.getAddress();
		            int clientPort = receivedPacket.getPort();
		            receivedData = receivedPacket.getData();
		            int numReq = (int)receivedData[0];
		            sendData = new byte[numReq];
		            System.out.println("the client address is:"+client+"\nthe port number is:"+clientPort+"\nthe # of bytes required: "+numReq);
		            Random numGen = new Random();
	            	numGen.nextBytes(sendData);
	            	System.out.println("\nThe sent data: ");
	            	for(int i=0;i<numReq;i++){	            		
	            		System.out.println("the byte"+i+" value is: "+sendData[i]);
	            		}
		            sendPacket = new DatagramPacket(sendData,numReq,client,clientPort);
		            serverSocket.send(sendPacket);
		            System.out.println("Client Touch-based/n");
		        }
		    }
	
	
}
