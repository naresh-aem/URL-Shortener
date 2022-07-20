<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script type="text/javascript" src="/scripts/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/scripts/js/url-shortener.js"></script>
<link rel="stylesheet" href="/css/url-shortener.css">
</head>
<body>
	<div>
		<h1>Shorten URLs</h1>
	</div>


	<form:form modelAttribute="form">
		<form:errors path="" element="div" />
		<div>
			<form:label for="longUrl" path="longUrl">Enter an URL to be shortened</form:label>
			<form:input path="longUrl" type="url"
				placeholder="https://www.apple.com/ipad/" />
			<form:errors path="longUrl" />
		</div>
		<div>
			<input type="submit" />
		</div>
	</form:form>

	<div></div>
</body>
</html>
