package com.mobilebulletin.webservice.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.mobilebulletin.remote.department.DepartmentRemoteService;
import com.mobilebulletin.webservice.util.HeaderHandlerResolver;

import javax.xml.ws.Service;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
public class DepartmentServiceConnector {

	public static DepartmentRemoteService getServicePort(){
		try {
            URL wsdlLocation = new URL("http://localhost:8080/com.mobilebulletin.remote.service/MobileBulletin/DepartmentRemoteBean?wsdl");

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

            DepartmentRemoteService servicePort = service.getPort(DepartmentRemoteService.class);

            return servicePort;
        } catch (MalformedURLException mue) {
            Logger.getLogger(DepartmentServiceConnector.class).warn("An error occurred while getting the wsdl location.", mue);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
