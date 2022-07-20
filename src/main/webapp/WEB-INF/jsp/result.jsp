<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript" src="/scripts/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/scripts/js/url-shortener.js"></script>
<link rel="stylesheet" href="/css/url-shortener.css">
</head>
<body>
	<div>
		<h1>Result</h1>
	</div>
	<div>
		<a href="http://localhost:8080/"
			title="Shortened URL List"
			<span class="bold">  Shorten new Url </span>></a> <br /> <br />
		<ul>

			<li><br />
			<span>Shorten URL for ${outputUrl.longUrl} is : </span><a
				href="${outputUrl.shortUrl}"
				title="Shortened URL for ${outputUrl.longUrl}">${outputUrl.shortUrl}</a>


				<br /> <br />
		</ul>
		<a href="http://localhost:8080/all-shortened-urls.html"
			title="Shortened URL List"
			<span class="bold"> Check All Shorten Urls list </span>></a>
	</div>
	<div></div>
</body>
</html>

