package com.mobilebulletin.webservice.util;

/**
 * 
 */

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
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
 * Taken from www.javadb.com and modified.
 * 
 * @author www.javadb.com
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(HeaderHandler.class);

    /** The Constant WS_SECURITY_SECEXT_URI. */
    private static final String WS_SECURITY_SECEXT_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";

    /** The Constant WS_SECURITY_UTILITY_URI. */
    private static final String WS_SECURITY_UTILITY_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";

    /** The Constant WS_PASSWORD_TYPE_URI. */
    private static final String WS_PASSWORD_TYPE_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText";

    /** The Constant WSSE_PREFIX. */
    private static final String WSSE_PREFIX = "wsse";

    /** The Constant SECURITY_LOCAL_NAME. */
    private static final String SECURITY_LOCAL_NAME = "Security";

    /** The Constant USERNAME_TOKEN_LOCAL_NAME. */
    private static final String USERNAME_TOKEN_LOCAL_NAME = "UsernameToken";

    /** The Constant LOCAL_PART_XMLNS_WSU. */
    private static final String LOCAL_PART_XMLNS_WSU = "wsu";

    /** The Constant USERNAME_LOCAL_NAME. */
    private static final String USERNAME_LOCAL_NAME = "Username";

    /** The Constant PASSWORD_LOCAL_NAME. */
    private static final String PASSWORD_LOCAL_NAME = "Password";

    /** The Constant PASSWORD_ATTRIBUTE_TYPE. */
    private static final String PASSWORD_ATTRIBUTE_TYPE = "Type";

    private static final String HIGHPHEN = "-";

    private String userName;

    private String password;

    public HeaderHandler(String userName,String password) {
        this.userName = userName;
 this.password = password;
    }

    /*
     * (non-Javadoc)
     * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
     */
    public boolean handleMessage(SOAPMessageContext smc) {

        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        SOAPMessage message = smc.getMessage();

        try {

            // Let's extract information and try to log XML.
            SOAPPart sp = message.getSOAPPart();
            SOAPEnvelope envelope = sp.getEnvelope();

         

            if (outboundProperty.booleanValue()) {

                SOAPHeader header = envelope.getHeader();

                if (header != null) {
                    header.detachNode();
                }

                header = envelope.addHeader();

                SOAPElement security = header.addChildElement(SECURITY_LOCAL_NAME, WSSE_PREFIX, WS_SECURITY_SECEXT_URI);

                SOAPElement usernameToken = security.addChildElement(USERNAME_TOKEN_LOCAL_NAME, WSSE_PREFIX);

                QName qName = new QName(XMLConstants.NULL_NS_URI, LOCAL_PART_XMLNS_WSU);
                usernameToken.addAttribute(qName, WS_SECURITY_UTILITY_URI);

                SOAPElement username = usernameToken.addChildElement(USERNAME_LOCAL_NAME, WSSE_PREFIX);

                username.addTextNode(userName);

                SOAPElement password = usernameToken.addChildElement(PASSWORD_LOCAL_NAME, WSSE_PREFIX);
                password.setAttribute(PASSWORD_ATTRIBUTE_TYPE, WS_PASSWORD_TYPE_URI);

                password.addTextNode(this.password);

            }

        } catch (SOAPException se) {
            logger.error("SOAPException occured while processing the message", se);

        }

        return outboundProperty;

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

        } catch (Exception e) {
            logger.warn("Could not extract XML from soap message");
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
     */
    public Set<QName> getHeaders() {
        // throw new UnsupportedOperationException("Not supported yet.");
        logger.info("getHeaders() is called");
        return null;
    }

    /*
     * (non-Javadoc)
     * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
     */
    public boolean handleFault(SOAPMessageContext context) {
        // throw new UnsupportedOperationException("Not supported yet.");
        logger.info("handleFault() is called");
        return true;
    }

    /*
     * (non-Javadoc)
     * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
     */
    public void close(MessageContext context) {
        logger.info("close() is called");
        // throw new UnsupportedOperationException("Not supported yet.");
    }
}


