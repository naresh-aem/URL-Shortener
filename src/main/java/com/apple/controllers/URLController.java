package com.apple.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apple.model.ShortenedURLs;
import com.apple.service.URLManipulate;

@Controller
public class URLController {

	Logger LOG = LoggerFactory.getLogger(URLController.class);
	
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
		LOG.error("+++++"+outputUrl.toString());
		return new ModelAndView("result", "outputUrl", outputUrl);
	}
	
	@RequestMapping(value = "/all-shortened-urls.html", method = RequestMethod.GET)
	public ModelAndView allUrls() {
		List<ShortenedURLs> allURLs = urlService.getAllURLs();
		return new ModelAndView("all-shortened-urls", "allURLs", allURLs);

	}
	
	@RequestMapping(value = "/404.html", method = RequestMethod.GET)
	public ModelAndView error() {
		return new ModelAndView("404", "sample", "Sample");

	}
	
	@RequestMapping(value = "/deleteUrls", method = RequestMethod.GET)
	public ModelAndView deleteContent() {
		urlService.deleteAllURLs();
		return new ModelAndView("redirect:/url-shortener.html");

	}

}
