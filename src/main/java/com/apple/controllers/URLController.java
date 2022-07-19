package com.apple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apple.model.ShortenedURLs;
import com.apple.service.URLManipulate;

@Controller
public class URLController {
	@Autowired
	private URLManipulate urlService;
	
	@RequestMapping(value = "/url-shortener.html", method = RequestMethod.GET)
	public ModelAndView getShortendURL() {
		ShortenedURLs urlList = new ShortenedURLs();
		return new ModelAndView("url-shortener", "form", urlList);
	}
	
	@RequestMapping(value = "/url-shortener.html", method = RequestMethod.POST)
	public ModelAndView newURL(ShortenedURLs inputData) {
		ShortenedURLs outputUrl = urlService.saveURL(inputData);
		return new ModelAndView("shortened-url-result", "outputUrl", outputUrl);

	}
	
	@RequestMapping(value = "/all-shortened-urls.html", method = RequestMethod.GET)
	public ModelAndView employees() {
		List<ShortenedURLs> allURLs = urlService.getAllURLs();
		return new ModelAndView("all-shortened-urls", "allURLs", allURLs);

	}

}
