package com.umartariq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


//SINGLE SERVER APP
public class Main {

    public static void main(String[] args) {
	// write your code here
        //network is a system of computers connected together so they can share resources and communicate with each other
        //it refers to how connected computers communicate
        //java.net package contains classes used to establish connections between computers and send messages between them
        //2 concepts threads, and input/output streams

        //intranet is a private network
        /*
        The Intranet is presumed to
   be used by corporate employees for business purposes, and to
   interconnect hosts that carry sensitive or confidential information.
   It is also held to a higher standard of operational availability than
   the Internet at large. Its usage can be monitored and controlled, and
   its resources can be better planned and tuned than those of the
   public network. These arguments of security and resource management
   have ensured the dominance of the Intranet model in most corporations
   and campuses.

         file to print : send over intranet to the printer.. to print

            second method is
         version control systems that have a central repository..  users are limited to upload files to it so they can be printed

         In Networking .. a single machine is a Host

         */

        /*
        servers - hosts
        our machines are called clients that connect to those servers

        this interaction can be on the same host.. e.g Application/WebServers that come with Web Dev tools
        such as Apache,IIS,MySQL(XAMPP / Workbench) etc.

        computers communicate with a transport protocol like TCP / UDP

        Data comes from the server to the client.. to route the data to the target application Each Application that needs data from
        network is assigned a port(which includes clients connecting to a server that is on the same machine)
        when data arrives , the port number is used to route the data to the application that's waiting for it.

        ipv4,32bit
        ipv6,128bit
        two applications running on the same HOST (127.0.0.1 - localhost) use TCP/IP to communicate with each other


         */


        /*
        java.net package consists of 2 APIS
        Low Level and High Level
         */

        /*
        when communicating using tcp/ip the sequence of events is as follows:
        1. the client opens a connection to the server
        2. the client sends a request to the server
        3. the server sends a response to the client
        4. the client closes the connection to the server

        in low level api - we use sockets to establish connections and send requests and receive responses - A Socket is one end-point of
        two way connection. the client will have a socket , and the server will have a socket

        Multiple clients connecting to the same server, will use the same port number, but each client will have its own socket.
        Socket class for - CLIENT SOCKET
        ServerSocket class for - SERVER SOCKET

        for socket creation we need (IPADDRESS,PORT)
        There needs to be a handshake
        and data has to be sent as packets


         */

        //port number is an integer b/w 0 to 65535 - [16 bit integer range]
        try(ServerSocket serverSocket = new ServerSocket(5000)){
                Socket socket = serverSocket.accept();
                //this Application and main method is the SERVER
                //its waiting for a client to connect to it at port 5000
                //when a client connects , the message is printed
            System.out.println(" Client Connected ");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            //wrap input stream with buffered reader
            //output stream with print writer, Flush the output stream after every write method MANUALLY.. Or Pass True in the Writer Constructor here

            while(true){
                //runs until program ends

                String echoString = input.readLine();
                //when we receive exit from client, this server ( java app) will terminate
                if(echoString.equals("exit")){
                    break;
                }
                output.println("Echo from server:" + echoString);
            }

        }catch(IOException e){
            System.out.println("Server exception "+e.getMessage());
            e.printStackTrace();
        }

//if you run this without client app.. it gives this errir
        //java.net.SocketException: An established connection was aborted by the software in your host machine

    }
}
