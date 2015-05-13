package com.mobilebulletin.webservice.util;

/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

/**
 * Taken from www.javadb.com and modified.
 * 
 * @author www.javadb.com
 */
public class HeaderHandlerResolver implements HandlerResolver {

    private String userName;

    private String password;

    public HeaderHandlerResolver() {
        super();

    }

    public HeaderHandlerResolver(String userName,String password) {
        super();
 this.userName = userName;
 this.password = password;
    }

    @SuppressWarnings("unchecked")
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        List<Handler> handlerChain = new ArrayList<Handler>();

        HeaderHandler hh = new HeaderHandler(userName,password);

        handlerChain.add(hh);

        return handlerChain;
    }
}

