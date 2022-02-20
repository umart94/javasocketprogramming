package com.umartariq;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ApacheTest.java created by umartariq on 26/06/2020
 * 2:17 PM inside the package - com.umartariq
 */
public class ApacheTest {
    public static void main(String[] args) throws IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://www.flickr.com/services/feeds/photos_public.gne?tags=dccomics");
        request.addHeader("User-Agent","Chrome");
        CloseableHttpResponse response = httpClient.execute(request);
        try {

            System.out.println("response code"+response.getStatusLine().getStatusCode());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while((line=bufferedReader.readLine()) != null){
                line = bufferedReader.readLine();
                System.out.println(line);
            }
            bufferedReader.close();

        }catch(IOException e){
            e.getMessage();
        }finally{
            response.close();
        }
    }
}
