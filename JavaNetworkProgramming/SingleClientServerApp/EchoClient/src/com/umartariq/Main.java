package com.umartariq;

//SINGLE CLIENT APP
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //ipaddress and port - of the server... in the constructor of the Socket for the Client Application
        try(Socket socket  = new Socket("localhost",5000)){
            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringtoEcho = new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do{
                //loop executes once
                //we have no idea how many times this type of loop will run
                //
                System.out.println("Enter String to be echoed");
                echoString = scanner.nextLine();
                stringtoEcho.println(echoString);// print writer -> socket output
                if(!echoString.equals("exit")){
                    //until we do not type exit in console - the server will print response
                    response = echoes.readLine();
                    System.out.println(response);
                }
            }while(!echoString.equals("exit"));

        }catch(Exception e){
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
