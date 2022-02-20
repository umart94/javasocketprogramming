package com.umartariq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try{
            //URL url = new URL("http://example.org");
            /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                System.out.println(line);
            }
            bufferedReader.close();

             */

            //we can configure such as reading,writing,caching, that is why there are two steps here. open and connect.
            //URLConnection urlConnection = url.openConnection();
            //config here
            //urlConnection.setDoOutput(true);//trying to set values on connection will cause error
            //we make sure that we config after open and before connect
            /*
            Adding a comment, if you have a long lasting connection and you send both GETs and POSTs, this is what I do:
            setDoOutput(true) is used for POST and PUT requests. If it is false then it is for using GET requests.

                    if (doGet) {    // some boolean
            con.setDoOutput(false); // reset any previous setting, if con is long lasting
            con.setRequestMethod("GET");
            }
            else {
                con.setDoOutput(true);  // reset any previous setting, if con is long lasting
                con.setRequestMethod("POST");
            }
            And to avoid making the connection long lasting, close it each time.

            if (doClose)    // some boolean
                con.setRequestProperty("Connection", "close");

            con.connect();              // force connect request
             */


            //urlConnection.connect();

          /*  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                System.out.println(line);
            }
            bufferedReader.close();
*/


        /*  Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
          for(Map.Entry<String,List<String>> entry : headerFields.entrySet()){
              String key = entry.getKey();
              List<String> value = entry.getValue();
              System.out.println("Key=\t"+key);
              for(String string : value){
                  System.out.println("Value=\t"+ value);
              }
          }


          /*
          Key=	null
Value=	[HTTP/1.1 200 OK]
Key=	X-Cache
Value=	[HIT]
Key=	Server
Value=	[ECS (oxr/8310)]
Key=	Etag
Value=	["3147526947+ident"]
Key=	Cache-Control
Value=	[max-age=604800]
Key=	Vary
Value=	[Accept-Encoding]
Key=	Last-Modified
Value=	[Thu, 17 Oct 2019 07:18:26 GMT]
Key=	Expires
Value=	[Fri, 03 Jul 2020 08:48:16 GMT]
Key=	Content-Length
Value=	[1256]
Key=	Date
Value=	[Fri, 26 Jun 2020 08:48:16 GMT]
Key=	Age
Value=	[315844]
Key=	Content-Type
Value=	[text/html; charset=UTF-8]
         */





            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=dccomics");
            HttpURLConnection httpURLconnection = (HttpURLConnection) url.openConnection();

            httpURLconnection.setRequestMethod("GET");
            httpURLconnection.setRequestProperty("User-Agent","Chrome");
            httpURLconnection.setReadTimeout(30000);//30 seconds. , don't keep timeout too small.


            int responseCode = httpURLconnection.getResponseCode();
            //getResponseCode and getInputStream call the connect methods implicitly for HttpUrlConnection.
            //System.out.println("ResponseCode" + responseCode);

            if(responseCode!=200){
                //System.out.println(httpURLconnection.getResponseMessage());
                //System.out.println("Error Reading webpage. ");
                return; //exit.
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLconnection.getInputStream()));
            String line = "";
            while((line=bufferedReader.readLine()) != null){
                line = bufferedReader.readLine();
                System.out.println(line);
            }
            bufferedReader.close();


        }catch(MalformedURLException e){
            System.out.println("malformed url "+e.getMessage());
        }catch(IOException e){
            System.out.println("ioexception " + e.getMessage());
        }
    }
}

/*
some java.net classes were implemented in the older sdks for Http protocol that was older.
classes that use Http 2.0 protocol were included in Java 9 JDK

older classes worked on blocking modes, 1 thread per request
older classes used multiple protocols and were too abstract.


its not a good idea to use this newer api.

instead use 3rd party libraries

Apache HttpClient : https://hc.apache.org/httpcomponents-client-ga/
Eclipse Jetty : https://www.eclipse.org/jetty/

apache library supports HTTP/1.1

http://openjdk.java.net/jeps/110

Define a new HTTP client API that implements HTTP/2 and WebSocket, and can replace the legacy HttpURLConnection API. The API will be delivered as an incubator module, as defined in JEP 11, with JDK 9. This implies:

The API and implementation will not be part of Java SE.

The API will live under the jdk.incubtor namespace.

The module will not resolve by default at compile or run time.

Motivation
The existing HttpURLConnection API and its implementation have numerous problems:

The base URLConnection API was designed with multiple protocols in mind, nearly all of which are now defunct (ftp, gopher, etc.).

The API predates HTTP/1.1 and is too abstract.

It is hard to use, with many undocumented behaviors.

It works in blocking mode only (i.e., one thread per request/response).

It is very hard to maintain.


Goals
Must be easy to use for common cases, including a simple blocking mode.

Must provide notification of events such as "headers received", errors, and "response body received". This notification is not necessarily based on callbacks but can use an asynchronous mechanism like CompletableFuture.

A simple and concise API which caters for 80-90% of application needs. This probably means a relatively small API footprint that does not necessarily expose all the capabilities of the protocol.

Must expose all relevant aspects of the HTTP protocol request to a server, and the response from a server (headers, body, status codes, etc.).

Must support standard and common authentication mechanisms. This will initially be limited to just Basic authentication.

Must be able to easily set up the WebSocket handshake.

Must support HTTP/2. (The application-level semantics of HTTP/2 are mostly the same as 1.1, though the wire protocol is completely different.)

Must be able to negotiate an upgrade from 1.1 to 2 (or not), or select 2 from the start.

Must support server push, i.e., the ability of the server to push resources to the client without an explicit request by the client.

Must perform security checks consistent with the existing networking API.

Should be friendly towards new language features such as lambda expressions.

Should be friendly towards embedded-system requirements, in particular the avoidance of permanently running timer threads.

Must support HTTPS/TLS.

Performance requirements for HTTP/1.1:

Performance must be on par with the existing HttpURLConnection implementation.

Performance must be on par with the Apache HttpClient library and with Netty and Jetty when used as a client API.

Memory consumption of the new API must be on par or lower than that of HttpURLConnection, Apache HttpClient, and Netty and Jetty when used as a client API.

Performance requirements for HTTP/2:

Performance must be better than HTTP/1.1 in the ways expected by the new protocol (i.e., in scalability and latency), notwithstanding any platform limitations (e.g., TCP segment ack windows).

Performance must be on par with Netty and Jetty when used as a client API for HTTP/2.

Memory consumption of the new API must be on par or lower than when using HttpURLConnection, Apache HttpClient, and Netty and Jetty when used as a client API.

Performance comparisons will only be in the context of comparable modes of operation, since the new API will emphasise simplicity and ease of use over covering all possible use cases,

This work is intended for JDK 9. Some of the code may be re-used by Java EE in their implementation of HTTP/2 in the Servlet 4.0 API, so only JDK 8 language features and, where possible, APIs will be used.

It is intended that with the benefit of experience using the API in JDK 9, it will be possible to standardize the API in Java SE under the java.net namespace in JDK 10. When this happens, as part of a future JEP, the API will no longer exist as an incubator module.

Non-Goals
This API is intended to eventually replace the HttpURLConnection API for new code, but we do not intend immediately to re-implement the old API using the new API. This may happen as future work.

Some requirements were considered in earlier versions of this JEP for JDK 8, but they are being left out in order to keep the API as simple as possible:

Request/response filtering,
A pluggable connection cache, and
A general upgrade mechanism.
Some of these requirements, e.g., connection caching, will become less important with the gradual adoption of HTTP/2.

Description
Some prototyping work has been done for JDK 9 in which separate classes were defined for the HTTP client, requests, and responses. The builder pattern was used to separate mutable entities from the immutable products. A synchronous blocking mode is defined for sending and receiving and an asynchronous mode built on java.util.concurrent.CompletableFuture is also defined.

The prototype was built on NIO SocketChannels with asynchronous behavior implemented with Selectors and externally provided ExecutorServices.

The prototype implementation was standalone, i.e., the existing stack was not changed so as to ensure compatibility and allow a phased approach in which not all functionality must be supported at the start.

The prototype API also included:

Separate requests and responses, like the Servlet and HTTP server API;
Asynchronous notification of the following events:
Response headers received,
Response error,
Response body received, and
Server push (HTTP/2 only);
HTTPS, via SSLEngine;
Proxying;
Cookies; and
Authentication.
The part of the API most likely to need further work is in the support of HTTP/2 multi responses (server push) and HTTP/2 configuration. The prototype implementation supports almost all of HTTP/1.1 but not yet HTTP/2.

HTTP/2 proxying will be implemented in a following change.

Alternatives
A number of existing HTTP client APIs and implementations exist, e.g., Jetty and the Apache HttpClient. Both of these are both rather heavy-weight in terms of the numbers of packages and classes, and they don't take advantage of newer language features such as lambda expressions.

Testing
The internal HTTP server will provide a suitable basis for regression and TCK tests. Functional tests could use that also, but they may need to test against real HTTP servers.
 */
