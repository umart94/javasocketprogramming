package com.umartariq;

//SINGLE CLIENT APP
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //ipaddress and port - of the server... in the constructor of the Socket for the Client Application
        try (Socket socket = new Socket("localhost", 5000)) {
            //if server is down or blocked
//the client should send display a timeout exception (error)
//we will set timeout on the client
            socket.setSoTimeout(5000);//5 seconds timeout
            //handle the socketTimeOutException
            //try sending request , block or terminate .. give a choice to user

            //The Timeout prevents Client from blocking a server
            //client is given 5 seconds and then client timesout
            //this is done to avoid blocking servers


            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringtoEcho = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                //loop executes once
                //we have no idea how many times this type of loop will run
                //
                System.out.println("Enter String to be echoed");
                echoString = scanner.nextLine();
                stringtoEcho.println(echoString);// print writer -> socket output
                if (!echoString.equals("exit")) {
                    //until we do not type exit in console - the server will print response
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));
        } catch (SocketTimeoutException e) {
            System.out.println("The Socket Timed Out");
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}


