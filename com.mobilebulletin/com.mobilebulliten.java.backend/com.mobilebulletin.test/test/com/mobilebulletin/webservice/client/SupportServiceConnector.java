package com.mobilebulletin.webservice.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.log4j.Logger;

import com.mobilebulletin.remote.support.SupportRemoteService;
import com.mobilebulletin.webservice.util.HeaderHandlerResolver;

public class SupportServiceConnector {

	public static SupportRemoteService getServicePort(){
		try {
            URL wsdlLocation = new URL("http://localhost:8080/com.mobilebulletin.remote.service/MobileBulletin/SupportRemoteBean?wsdl");

            QName qName = new QName("mobilebulletin", "MobileBulletin");

            Service service = null;
            service = Service.create(wsdlLocation, qName);
            
		     /**
		  HeaderHandlerResolve will pass this information to a HeaderHandler implementation
		  class which will embed the user name and password passed in to the ws-security
		  header within the soap header element
		     **/
            HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver(ReadProperties.getUsernameProperty(),ReadProperties.getPasswordProperty());
            service.setHandlerResolver(handlerResolver);

            SupportRemoteService servicePort = service.getPort(SupportRemoteService.class);

            return servicePort;
        } catch (MalformedURLException mue) {
            Logger.getLogger(SupportServiceConnector.class).warn("An error occurred while getting the wsdl location.", mue);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
