package com.mobilebulletin.webservice.handler;

/**
 * 
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;



/**
 * Handler to authenticate the requests send in by the user from information provided through soap-headers.
 */
public class AuthenticateHandler implements SOAPHandler<SOAPMessageContext> {

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(AuthenticateHandler.class);

    /** The Constant USERNAME_TOKEN_STRING. */
    private static final String USERNAME_TOKEN_STRING = "UsernameToken";

    /** The Constant USERNAME_STRING. */
    private static final String USERNAME_STRING = "Username";

    /** The Constant ARG_0_STRING. */
    private static final String ARG_0_STRING = "arg0";

    /** The Constant PASSWORD_STRING. */
    private static final String PASSWORD_STRING = "Password";


    private static final String HIGHPHEN = "-";

    /*
     * (non-Javadoc)
     * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
     */
    public boolean handleFault(SOAPMessageContext context) {
        // throw new UnsupportedOperationException("Not supported yet.");
        logger.debug("handleFault() is called");
        return true;
    }

    /*
     * (non-Javadoc)
     * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
     */
    public boolean handleMessage(SOAPMessageContext smc) {

        SOAPMessage message = smc.getMessage();
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        boolean authenticated = false;

        try {

            // Let's extract information and try to log XML.
            SOAPPart sp = message.getSOAPPart();
            SOAPEnvelope envelope = sp.getEnvelope();

           
            if (!outboundProperty) {

                SOAPHeader header = envelope.getHeader();

                if (header != null) {
                    authenticated = processSOAPHeader(header);
                }

            }

        } catch (SOAPException se) {
            logger.error("SOAPException occured while processing the message", se);

        }
        return authenticated;
    }

    /**
     * Gets the sOAP message as string.
     * 
     * @param msg the msg
     * @return the sOAP message as string
     */
    private String getSOAPMessageAsString(SOAPMessage msg) {

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            msg.writeTo(baos);
            return baos.toString();

        } catch (IOException ioe) {
            logger.warn("Could not extract XML from soap message", ioe);
            return null;
        } catch (SOAPException se) {
            logger.warn("Could not extract XML from soap message", se);
            return null;
        }
    }

    /**
     * Process soap header. This method is called by handleRequest method It retrieves the SOAP headers in the message
     * and authenticates the client.
     * 
     * @param sh the soap header
     * @return true, if successful
     */
    private boolean processSOAPHeader(SOAPHeader sh) {
        boolean authenticated = false;

        // look for authentication header element inside the HEADER block
        Iterator childElems = sh.getChildElements();

        SOAPElement child = extractUserNameInfo(childElems);

        if (child != null) {

            // call method to perform authentication
            authenticated = authenticateRequest(child);
        }
        return authenticated;
    }

    /**
     * Extract user name info.
     * 
     * @param childElems the child elems
     * @return the sOAP element
     */
    private SOAPElement extractUserNameInfo(Iterator childElems) {

        logger.debug("extractUserNameInfo called.");

        SOAPElement child = null;
        Name sName;

        // iterate through child elements
        while (childElems.hasNext()) {
            Object elem = childElems.next();

            if (elem instanceof SOAPElement) {

                // Get child element and its name
                child = (SOAPElement) elem;
                sName = child.getElementName();

                // Check whether there is a UserNameToken element
                if (!USERNAME_TOKEN_STRING.equalsIgnoreCase(sName.getLocalName())) {

                    if (child.getChildElements().hasNext()) { // TODO check logic
                        return extractUserNameInfo(child.getChildElements());
                    }
                }
            }
        }

        return child;
    }

    /**
     * Authenticate request. This method retrieves the authentication information for the request header and validates
     * it.
     * 
     * @param element the element
     * @return true, if successful
     */
    private boolean authenticateRequest(SOAPElement element) {

        logger.debug("authenticateRequest called");
        boolean authenticated = false;

        // variable for user name and password
        String userName = null;
        String password = null;
        Name sName;

        // get an iterator on child elements of SOAP element
        Iterator childElems = element.getChildElements();

        SOAPElement child;
        // loop through child elements

        while (childElems.hasNext()) {
            // get next child element
            Object elem = childElems.next();

            if (elem instanceof SOAPElement) {
                child = (SOAPElement) elem;

                // get the name of SOAP element
                sName = child.getElementName();

                // get the value of username element
                if (USERNAME_STRING.equalsIgnoreCase(sName.getLocalName())) {
                    logger.debug("---UserName =" + child.getValue());
                    userName = child.getValue();
                } else if (PASSWORD_STRING.equalsIgnoreCase(sName.getLocalName())) {
                    // get the value of password element
                    password = child.getValue();
                }

                if (userName != null && password != null) {

                   
   /**
       Note that in this instance i have used my custom used class
       called ClientLoginModule whic wraps a JBossLoginModule instance.
         You can use your own authentication mechanism as you have the user name
        and password at this point.
   **/
                try{	//read property file
                	if(userName != null && password != null){
                		if(userName.equalsIgnoreCase(ReadProperties.getUsernameProperty()) && 
                				password.equalsIgnoreCase(ReadProperties.getPasswordProperty()) 	)
                			return true;
                	}
                }catch(Exception e){
                	e.printStackTrace();
                }    
                  

                    break;
                }

            }
        }

        if (userName == null || password == null) {
            logger.warn("Username or password is empty. userName : [" + userName + "], password : [" + password + "]");
        }

        return authenticated;

    }

    

    /**
     * Extract TCI info.
     * 
     * @param childElems the child elems
     * @return the sOAP element
     */
    private SOAPElement extractTCIInfo(Iterator childElems) {

        logger.debug("extractTCIInfo called.");

        SOAPElement child = null;
        Name sName;

        // iterate through child elements
        while (childElems.hasNext()) {
            Object elem = childElems.next();

            if (elem instanceof SOAPElement) {

                // Get child element and its name
                child = (SOAPElement) elem;
                sName = child.getElementName();

                // Check whether there is a UserNameToken element
                if (!ARG_0_STRING.equalsIgnoreCase(sName.getLocalName())) {

                    if (child.getChildElements().hasNext()) {
                        return extractTCIInfo(child.getChildElements());
                    }
                }
            }
        }

        return child;
    }

    /*
     * (non-Javadoc)
     * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
     */
    public Set<QName> getHeaders() {
        logger.debug("--- In AuthenticateHandler.getHeaders ()");
        // return headers;
        return null;
    }

    /*
     * (non-Javadoc)
     * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
     */
    public void close(MessageContext context) {
        logger.debug("close() is called");
        // throw new UnsupportedOperationException("Not supported yet.");
    }

}
