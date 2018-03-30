package com.sh.pengyue.arvin.service;

public class WebServiceProxy implements com.sh.pengyue.arvin.service.WebService {
  private String _endpoint = null;
  private com.sh.pengyue.arvin.service.WebService webService = null;
  
  public WebServiceProxy() {
    _initWebServiceProxy();
  }
  
  public WebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceProxy();
  }
  
  private void _initWebServiceProxy() {
    try {
      webService = (new com.sh.pengyue.arvin.serviceimpl.WebServiceWsLocator()).getWebServiceImplPort();
      if (webService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webService != null)
      ((javax.xml.rpc.Stub)webService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sh.pengyue.arvin.service.WebService getWebService() {
    if (webService == null)
      _initWebServiceProxy();
    return webService;
  }
  
  public java.lang.String sayHello(java.lang.String arg0) throws java.rmi.RemoteException{
    if (webService == null)
      _initWebServiceProxy();
    return webService.sayHello(arg0);
  }
  
  
}