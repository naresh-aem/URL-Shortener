package com.apple.service.impl;

import java.security.SecureRandom;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.data.URLRepository;
import com.apple.model.ShortenedURLs;
import com.apple.service.URLManipulate;

@Service
public class URLManipulateImpl implements URLManipulate {
	
	Logger LOG = LoggerFactory.getLogger(URLManipulateImpl.class);
	
	@Autowired
	private URLRepository urlRepo;
	

	//Retrieve all entries of content urls from DB
	@Override
	public List<ShortenedURLs> getAllURLs() {		 
		return urlRepo.findAll();
	}

	//Save content object to DB
	@Override
	public ShortenedURLs saveURL(ShortenedURLs inputContentObj){
		ShortenedURLs currentItem = null;
		try {
			String longUrl= inputContentObj.getLongUrl();
			boolean isMatch = Pattern.compile("^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$")
	               .matcher(longUrl)
	               .find(); 
		
			if(isMatch) {
			    currentItem = findLongURL(longUrl);
				if(null == currentItem) {
					String shortUrl = getShortUrl();
					currentItem = new ShortenedURLs();
					currentItem.setLongUrl(longUrl);
					currentItem.setShortUrl(shortUrl);
					currentItem.setMessage("");
					urlRepo.save(currentItem);
				}
				else {
					currentItem.setMessage("URL already exists!!");
					LOG.info("URL already exists!!");
				}
			}
			else {
				currentItem = new ShortenedURLs();
				currentItem.setLongUrl(longUrl);
				currentItem.setLongUrl("");
				currentItem.setMessage("Please enter a valid url!");
				LOG.info("Please enter a valid url!");
			}
		} catch (Exception e) {
			LOG.error("Error while saving content ");
		}
		
		return currentItem;
	}

	//Find a table entry by longUrl
	@Override
	public ShortenedURLs findLongURL(String longUrl) {
		List<ShortenedURLs> urlList= null;
		
		try {
			urlList= urlRepo.findAllByLongUrlEquals(longUrl);
		} catch (Exception e) {
			LOG.error("Error while retrieving content by long Url");
		}
		
		if(!urlList.isEmpty() && urlList.size() == 1)
			return urlList.get(0);
		else
			return null;
	}
	
	//Find a table entry by shortUrl
	@Override
	public ShortenedURLs findShortURL(String shortUrl) {
		List<ShortenedURLs> urlList= null;
		
		try {
			urlList= urlRepo.findAllByShortUrlEquals(shortUrl);
		} catch (Exception e) {
			LOG.error("Error while retrieving content by short Url");
		}

		if(null != urlList && !urlList.isEmpty() && urlList.size() == 1)
			return urlList.get(0);
		else
			return null;
	}
	
	// Delete all table entries from DB 
	@Override
	public void deleteAllURLs() {
		try {
			urlRepo.deleteAll();
		} catch (Exception e) {
			LOG.error("Error while deleting content");
		}
	}
	
	// Simple function to generate unique alphanumeric random string 
	private String getShortUrl() {
		final String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom securerand =new SecureRandom();
		StringBuilder sb = new StringBuilder(12); 
		for (int i = 0; i < 12; i++) 
			sb.append(SOURCE.charAt(securerand.nextInt(SOURCE.length())));
		String shortUrl = "http://localhost:8080/r/"+sb.toString();
		ShortenedURLs recShortObj = findShortURL(shortUrl);
		if(null != recShortObj) 
			getShortUrl();
		
		return shortUrl;
	}

}
