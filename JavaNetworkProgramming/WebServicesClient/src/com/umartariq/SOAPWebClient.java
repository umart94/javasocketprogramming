package com.umartariq;

import java.rmi.RemoteException;

import org.tempuri.MyWebServiceSoapProxy;

public class SOAPWebClient {

	public static void main(String[] args) {
		System.out.println("PrintLn from Eclipse - SOAP JAVA WEBSERVICESCLIENT - UMARTARIQ"+
				" USING Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter");
				
		
		
		
		/*
		 * 
		 * PrintLn from Eclipse - SOAP JAVA WEBSERVICESCLIENT - UMARTARIQ
Jun 27, 2020 3:40:26 PM org.apache.axis.utils.JavaUtils isAttachmentSupported
WARNING: Unable to find required classes (javax.activation.DataHandler and javax.mail.internet.MimeMultipart). Attachment support is disabled.
SOAP Webservice by Umar Tariq - Printing from The Actual SOAPWebService.

packages not included in runtime environment. we need to download them and integrate into our app.
		 */
		
		//in this constructor add the window->preferences->tcpmonitor port number.
		//when running again change the tcp/ip monitor port
		//run the project again, server first, client second, and then change ports.
		MyWebServiceSoapProxy MyWebServiceSoapProxyobject = new MyWebServiceSoapProxy("http://localhost:2190/MyWebService.asmx");
		try {
			String helloString = MyWebServiceSoapProxyobject.helloWorld();
			System.out.println(helloString);
			
			
			double val1 = 7999;
					double val2 = 10000; 
					double result = MyWebServiceSoapProxyobject.addNumbers(val1, val2);
					
					System.out.println("the answer from soap webservice of the result of addition of two numbers is " +result);
			
			//the answer from soap webservice of the result of addition of two numbers is 17999.0
					
					
//the endpoint of the soap webservice, the place where the request needs to be sent		, inside mywebservicelocator.			
					// private java.lang.String MyWebServiceSoap_address = "http://localhost:2190/MyWebService.asmx";

			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
