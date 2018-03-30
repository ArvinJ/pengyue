/**
 * WebServiceWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sh.pengyue.arvin.serviceimpl;

public interface WebServiceWs extends javax.xml.rpc.Service {
    public java.lang.String getWebServiceImplPortAddress();

    public com.sh.pengyue.arvin.service.WebService getWebServiceImplPort() throws javax.xml.rpc.ServiceException;

    public com.sh.pengyue.arvin.service.WebService getWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
