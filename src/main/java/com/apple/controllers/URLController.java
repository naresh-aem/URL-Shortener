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

	@Autowired
	private URLManipulate urlService;

	//Input form page controller
	@RequestMapping(value = {"/","/url-shortener.html"}, method = RequestMethod.GET)
	public ModelAndView getShortendURL() {
		ShortenedURLs urlList = new ShortenedURLs();
		return new ModelAndView("url-shortener", "form", urlList);
	}

	//Form submit page mapping
	@RequestMapping(value = {"/","/url-shortener.html"}, method = RequestMethod.POST)
	public ModelAndView newURL(ShortenedURLs inputData) {
		ShortenedURLs outputUrl = urlService.saveURL(inputData);
		return new ModelAndView("result", "outputUrl", outputUrl);
	}

	//List of URLs shortened page mapping
	@RequestMapping(value = "/all-shortened-urls.html", method = RequestMethod.GET)
	public ModelAndView allUrls() {
		List<ShortenedURLs> allURLs = urlService.getAllURLs();
		return new ModelAndView("all-shortened-urls", "allURLs", allURLs);
	}

	//common 404 page mapping
	@RequestMapping(value = "/404.html", method = RequestMethod.GET)
	public ModelAndView error() { return new ModelAndView("404", "sample", "Sample"); }

	//Delete all content mapping 
	//We can also create a rest controller and call it from front-end 
	@RequestMapping(value = "/deleteUrls", method = RequestMethod.GET)
	public ModelAndView deleteContent() {
		urlService.deleteAllURLs();
		return new ModelAndView("redirect:/url-shortener.html");

	}

}
