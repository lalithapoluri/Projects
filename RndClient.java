
package homeWork6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class RndClient {
    public static void main(String[] args) throws Exception {
    	
        Random random = new Random(); 
        byte[] receivedBytes = new byte[1];
        int bytesFromserver = random.nextInt(20); 
        int portNumber = 5390;
        receivedBytes[0] = (byte)bytesFromserver; 
        System.out.println("The number of bytes expected from the server is"+receivedBytes[0]);
        InetAddress localServer = InetAddress.getLocalHost(); //IP address.
        DatagramPacket DataPacket = new DatagramPacket(receivedBytes,1,localServer,portNumber);
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.send(DataPacket);
        System.out.println("\nSending request to Server");
        byte[] receivedMessage = new byte[bytesFromserver];
        DatagramPacket dataReceived = new DatagramPacket(receivedMessage,bytesFromserver);
        try{
            clientSocket.setSoTimeout(5000);
            System.out.println("Receiving response from the server");
            clientSocket.receive(dataReceived);  
            receivedMessage = dataReceived.getData();
            System.out.println("The data received is : ");
            for(int i=0;i<bytesFromserver;i++){System.out.println("The Received byte "+i+" is: "+receivedMessage[i]);}
        }
        catch (java.io.InterruptedIOException exp){
            System.out.println("Client Socket Timeout"+"\nException Message: "+exp.getMessage());
            System.exit(0);
        }
        clientSocket.close();

    }

}

/*
OUTPUT 1:
    Server Side:
        Receiving request from client
        the client address is:/10.109.88.100
        the port number is:57532
        the # of bytes required: 12

        The sent data:
        the byte0 value is: 47
        the byte1 value is: -22
        the byte2 value is: -105
        the byte3 value is: -90
        the byte4 value is: 89
        the byte5 value is: -3
        the byte6 value is: -112
        the byte7 value is: 69
        the byte8 value is: -33
        the byte9 value is: 100
        the byte10 value is: -87
        the byte11 value is: 25
        Client Touch-based/n
        Receiving request from client

    Client Side:
        number of bytes requested: 12
        Server details: YS3P/10.109.88.100

        Sending request to Sever
        Receiving response from the server
        The received data:
        the transmitted byte0 is: 47
        the transmitted byte1 is: -22
        the transmitted byte2 is: -105
        the transmitted byte3 is: -90
        the transmitted byte4 is: 89
        the transmitted byte5 is: -3
        the transmitted byte6 is: -112
        the transmitted byte7 is: 69
        the transmitted byte8 is: -33
        the transmitted byte9 is: 100
        the transmitted byte10 is: -87
        the transmitted byte11 is: 25


OUTPUT 2: When the timeout occurs (Server Not running)

        number of bytes requested: 3
        Server details: YS3P/10.109.88.100

        Sending request to Sever
        Receiving response from the server
        Client Socket Timeout
        Exception Message: Receive timed out
*/
