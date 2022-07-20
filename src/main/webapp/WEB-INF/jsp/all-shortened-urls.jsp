<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript" src="/scripts/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/scripts/js/url-shortener.js"></script>
<link rel="stylesheet" href="/css/url-shortener.css">
</head>
<body>
	<div>
		<h1>All Shortened URLs</h1>
	</div>
	<div>
		<a href="http://localhost:8080/"
			title="Shortened URL List"
			<span class="bold">  Shorten new Url </span>></a><br/> <br/>
		<ul>
			<c:forEach items="${allURLs}" var="allURLs">
				<li>Shorten URL of ${allURLs.longUrl} is: <span> <a
						href="${allURLs.shortUrl}">${allURLs.shortUrl}</a></span>
				<li>
			</c:forEach>
		</ul>

		<a href="http://localhost:8080/deleteUrls">Delete All</a>
	</div>
	<div></div>

</body>
</html>