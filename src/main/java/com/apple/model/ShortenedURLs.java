package com.apple.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShortenedURLs {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	private String longUrl;
	
	@Override
	public int hashCode() {
		return Objects.hash(longUrl, shortUrl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShortenedURLs other = (ShortenedURLs) obj;
		return Objects.equals(longUrl, other.longUrl) && Objects.equals(shortUrl, other.shortUrl);
	}

	private String shortUrl;
	
	public String getLongUrl() { return longUrl; }
	
	public void setLongUrl(String longUrl) { this.longUrl = longUrl; }
	
	public String getShortUrl() { return shortUrl; }
	
	public void setShortUrl(String shortUrl) { this.shortUrl = shortUrl; }
	
	@Override
	public String toString() {
		return "ShortenedURLs [id=" + id + ", longUrl=" + longUrl + ", shortUrl=" + shortUrl + "]";
	}
}
