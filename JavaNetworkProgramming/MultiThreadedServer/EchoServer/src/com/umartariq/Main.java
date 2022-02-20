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

        //Single EchoClient and Server apps could connect only 1 client at a time
        //to make the same app multi-threaded we shift the try block and ServerSocket Creation in a loop.. so that every time a client connects to server,


        try (ServerSocket serverSocket = new ServerSocket(5000)) {
        while (true) {
            /**
             * without Echoer Class
             *
             *
            //runs until program ends
            //accepts more than 1 client connection
                Socket socket = serverSocket.accept();
                System.out.println(" Client Connected ");
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String echoString = input.readLine();
                try{
                    Thread.sleep(15000);
                }catch(InterruptedException e){
                    System.out.println("Thread Interrupted");
                }
                //when we receive exit from client, this server ( java app) will terminate
                //in case of multiple clients - the server gets blocked at input readLine

                //multiple apps.. multiple clients means multiple threads

                //for multiple clients we need to modify code
            // so that Server Handles Each Client On a Seperate Thread

                if (echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server:" + echoString);

                without Echoer Class
                */



            //Socket socket = serverSocket.accept();
            //Echoer echoer = new Echoer(socket);
            //echoer.start();

            //equivalent of above three LOC
                new Echoer(serverSocket.accept()).start();



            }
        }
        catch (IOException e) {
                System.out.println("Server exception " + e.getMessage());
                e.printStackTrace();
            }

//if you run this without client app running before server app.. it gives this error
//java.net.SocketException: An established connection was aborted by the software in your host machine

        }
    }

