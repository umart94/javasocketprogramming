package com.umartariq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Echoer.java created by umartariq on 26/05/2020
 * 10:56 AM inside the package - com.umartariq
 */
public class Echoer extends Thread {
    private Socket socket;
    public Echoer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            while(true){
                String echoString = input.readLine();
                System.out.println("Received Client Input : "+ echoString);
                if(echoString.equals("exit")){
                    break;
                }
                try{
                    Thread.sleep(15000);//15 seconds
                }catch (InterruptedException e){
                    System.out.println("Thread interrupted");
                }

                output.println(echoString);
            }
        }catch(IOException e){
            System.out.println("Error in Echoer -> : "+e.getMessage());
        } finally {
            try{
                socket.close();
            }catch (IOException e){

            }
        }
    }
}
