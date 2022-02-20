package com.umartariq;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //PREVIOUSLY - in TCP version - handshaking has to take place in between client and server
        //two way connection
        //tight coupling
        //reliable and requires overhead
        //client sends request
        //server sends response
        //TCP has error checking , and retransmission capability

        //UDP - User Datagram Protocol
        //in UDP there is no handshake no 2 way connection
        //we use UDP when we don't need a
        //1. reliable connection
        //2. speed is essential
        //we have no need for retransmitting upon errors as
        // there is No Error Checking in UDP version

        //DATAGRAM - is a self contained message
        //not guaranteed to arrive at destination
        //used for time sensitive apps
        // like VoIP apps such as Skype etc
        //it is not necessary that all packets reach destination
try{
    InetAddress address = InetAddress.getLocalHost();//Address of the (SERVER)host on which you want to send data to
    System.out.println("InetAddress LocalHost" + address);
    System.out.println("InetAddress LocalHost -getByNameToString" + InetAddress.getByName(InetAddress.getLocalHost().getHostName()));
    System.out.println("InetAddress LocalHost - Name of HOST" + address.getHostName());
    System.out.println("InetAddress Loopback" + InetAddress.getLoopbackAddress());
    //socket in this case does not have a port number (UDP connection)

    DatagramSocket datagramSocket = new DatagramSocket();
    Scanner scanner = new Scanner(System.in);
    String echoString;
    do{
        System.out.println("Enter string to be echoed ");
        echoString = scanner.nextLine();

        //convert input to byte array
        byte[] buffer = echoString.getBytes();
        //datagram is a self contained message with data address and port number
        //server obtains all information from the Datagram packet in UDP
        //in TCP.. the server obtained information from the socket after END-TO-END Connection


        //https://www.windows-commandline.com/how-to-create-large-dummy-file/
        //
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,5000);
        datagramSocket.send(packet);

        //dont do this in production
        byte[] buffer2 = new byte[50];
        packet = new DatagramPacket(buffer2,buffer2.length);
        datagramSocket.receive(packet);
        System.out.println("Text received is :  "+ new String(buffer2,0,packet.getLength()));

    }while(!echoString.equals("exit"));
}catch(SocketException e){
    System.out.println("SocketException: " + e.getMessage());
}catch(IOException e){
    System.out.println("ClientError: " + e.getMessage());
}


    }
}
