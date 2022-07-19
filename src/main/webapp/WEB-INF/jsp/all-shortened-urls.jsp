<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<script type="text/javascript" src="/scripts/jquery/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/scripts/js/url-shortener.js"></script>
	<link rel="stylesheet" href="/css/url-shortener.css">
</head>
<body>
<div>
	<h1>All Shortened URLs</h1>
	<ul>
	<c:forEach items="${allURLs}" var="allURLs">
	  <li>
	    Shorten URL of ${allURLs.longUrl} is: <span>${allURLs.shortUrl}</span>
	  <li>
	</c:forEach>
	</ul>
</div>
</body>
</html>