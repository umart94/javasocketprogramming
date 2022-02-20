/**
 * MyWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class MyWebServiceLocator extends org.apache.axis.client.Service implements org.tempuri.MyWebService {

    public MyWebServiceLocator() {
    }


    public MyWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MyWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MyWebServiceSoap
    private java.lang.String MyWebServiceSoap_address = "http://localhost:2190/MyWebService.asmx";

    public java.lang.String getMyWebServiceSoapAddress() {
        return MyWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MyWebServiceSoapWSDDServiceName = "MyWebServiceSoap";

    public java.lang.String getMyWebServiceSoapWSDDServiceName() {
        return MyWebServiceSoapWSDDServiceName;
    }

    public void setMyWebServiceSoapWSDDServiceName(java.lang.String name) {
        MyWebServiceSoapWSDDServiceName = name;
    }

    public org.tempuri.MyWebServiceSoap getMyWebServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MyWebServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMyWebServiceSoap(endpoint);
    }

    public org.tempuri.MyWebServiceSoap getMyWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.MyWebServiceSoapStub _stub = new org.tempuri.MyWebServiceSoapStub(portAddress, this);
            _stub.setPortName(getMyWebServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMyWebServiceSoapEndpointAddress(java.lang.String address) {
        MyWebServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.MyWebServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.MyWebServiceSoapStub _stub = new org.tempuri.MyWebServiceSoapStub(new java.net.URL(MyWebServiceSoap_address), this);
                _stub.setPortName(getMyWebServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MyWebServiceSoap".equals(inputPortName)) {
            return getMyWebServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "MyWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "MyWebServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MyWebServiceSoap".equals(portName)) {
            setMyWebServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
