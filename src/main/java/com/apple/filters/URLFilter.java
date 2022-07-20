package com.apple.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.apple.model.ShortenedURLs;
import com.apple.service.URLManipulate;
 
@Component
public class URLFilter extends GenericFilterBean  {
	
	Logger LOG = LoggerFactory.getLogger(URLFilter.class);
	
	@Autowired
	private URLManipulate urlContent;
	
	//Filter to check short url requests and redirect to actual url
    @Override
    public void doFilter(ServletRequest request,
                        ServletResponse response,
                        FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
 
        LOG.info("Requested URI is: " + req.getRequestURI());
        if(req.getRequestURI().startsWith("/r/")){
            LOG.info("Request longURL for: " + "http://localhost:8080"+req.getRequestURI());
    		ShortenedURLs redirectUrlObj = null;
    		
    		try {
				redirectUrlObj = urlContent.findShortURL("http://localhost:8080"+req.getRequestURI());
			} catch (Exception e) {
				LOG.error("Error while retrieving main URL in Filters");
			}
    		
    		if(null != redirectUrlObj)
    			res.sendRedirect( redirectUrlObj.getLongUrl());
    		else
    			res.sendRedirect("http://localhost:8080/404.html");
    	}
        else
        	chain.doFilter(request, response);

    }
}

