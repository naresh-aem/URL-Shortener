package com.apple.service;

import java.util.List;

import com.apple.model.ShortenedURLs;

public interface URLManipulate {
	
	public abstract List<ShortenedURLs> getAllURLs();

	public abstract ShortenedURLs saveURL(ShortenedURLs inputUrl);

	public abstract ShortenedURLs findLongURL(String longUrl);
	
	public abstract ShortenedURLs findShortURL(String shortUrl);

	public abstract void deleteAllURLs();

}
