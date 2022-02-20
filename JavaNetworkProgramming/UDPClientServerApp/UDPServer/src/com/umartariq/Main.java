package com.umartariq;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//UDP without threading / multithreading
public class Main {

    public static void main(String[] args) {
	try{
        DatagramSocket socket = new DatagramSocket(5000);
        while(true){
            //byte array accepts the data from socket
            byte[] buffer = new byte[50];
            //this is the packet, that receives data from the UDP Client
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            //receive method is the blocking method in this case
            //this does not connect end-to-end connection
            //it does not create anything.. to return/echo back something to server

            socket.receive(packet);

            System.out.println("Text received is  "+ new String(buffer,0,packet.getLength()));

            //address and port in received packet is used to send the datagram back again to client
            //there is no permanent end to end connection
            //we are getting information from the client datagram packet received by udp server
            String returnString = "Echo : " + new String(buffer, 0, packet.getLength());
            byte[] buffer2 = returnString.getBytes();
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buffer2,buffer2.length,address,port);
            socket.send(packet);
        }
    }catch(SocketException e){
        System.out.println("SocketException: " + e.getMessage());
    }catch(IOException e){
        System.out.println("IOException: " + e.getMessage());
    }
    }
}
