package org.tempuri;

public class MyWebServiceSoapProxy implements org.tempuri.MyWebServiceSoap {
  private String _endpoint = null;
  private org.tempuri.MyWebServiceSoap myWebServiceSoap = null;
  
  public MyWebServiceSoapProxy() {
    _initMyWebServiceSoapProxy();
  }
  
  public MyWebServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initMyWebServiceSoapProxy();
  }
  
  private void _initMyWebServiceSoapProxy() {
    try {
      myWebServiceSoap = (new org.tempuri.MyWebServiceLocator()).getMyWebServiceSoap();
      if (myWebServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)myWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)myWebServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (myWebServiceSoap != null)
      ((javax.xml.rpc.Stub)myWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.MyWebServiceSoap getMyWebServiceSoap() {
    if (myWebServiceSoap == null)
      _initMyWebServiceSoapProxy();
    return myWebServiceSoap;
  }
  
  public java.lang.String helloWorld() throws java.rmi.RemoteException{
    if (myWebServiceSoap == null)
      _initMyWebServiceSoapProxy();
    return myWebServiceSoap.helloWorld();
  }
  
  public double addNumbers(double val1, double val2) throws java.rmi.RemoteException{
    if (myWebServiceSoap == null)
      _initMyWebServiceSoapProxy();
    return myWebServiceSoap.addNumbers(val1, val2);
  }
  
  
}