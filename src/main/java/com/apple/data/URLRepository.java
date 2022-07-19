package com.apple.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apple.model.ShortenedURLs;

public interface URLRepository extends JpaRepository<ShortenedURLs, Long>{

	List<ShortenedURLs> findAllByLongUrlEquals(String longUrl);
	
	List<ShortenedURLs> findAllByShortUrlEquals(String shortUrl);

}
