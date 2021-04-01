package com.mediscreen.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {

    private static final Logger logger = LogManager.getLogger(LogFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
        logger.info("*** Requete vue par Zuul :" + req.getRequestURL());
        logger.info("*** ----- Avec getAuthType :"+ req.getAuthType());
        logger.info("*** ----- Avec getRemoteUser :"+ req.getRemoteUser());
        logger.info("*** ----- Avec getUserPrincipal :"+ req.getUserPrincipal());
        logger.info("*** ----- Avec getCookies :"+ req.getCookies());
        logger.info("*** ----- Avec methode :"+ req.getMethod());
        return null;
    }
}
