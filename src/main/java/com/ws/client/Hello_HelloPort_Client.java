
package com.ws.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2017-11-16T21:16:54.160-02:00
 * Generated source version: 3.2.1
 * 
 */
public final class Hello_HelloPort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.ws.com/", "HelloImplService");

    private Hello_HelloPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HelloImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        HelloImplService ss = new HelloImplService(wsdlURL, SERVICE_NAME);
        Hello port = ss.getHelloPort();  
        
        {
        System.out.println("Invoking hello...");
        java.lang.String _hello_arg0 = "_hello_arg0-128243860";
        java.lang.String _hello__return = port.hello(_hello_arg0);
        System.out.println("hello.result=" + _hello__return);


        }

        System.exit(0);
    }

}