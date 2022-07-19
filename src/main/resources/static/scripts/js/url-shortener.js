
function validateUrl(value) {
  return /^(?:(?:(?:https?|ftp):)?\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:[/?#]\S*)?$/i.test(value);
}	

$( document ).ready(function() {
   console.log( "ready!" );
});

$(document).on('change', '#longUrlfield', function() {

   console.log("1 "+$("#longUrlfield").innerHTML);
   console.log("2 "+$("#longUrlfield").innerText);
   console.log("3 "+$("#longUrlfield").innerContent);
   console.log("4 "+$("#longUrlfield").text());
	var cssStyle = (validateUrl($("#longUrlfield").value))?"url-passed":"url-failed";
   console.log( "URL - " +cssStyle);
	$( "#longUrlfield" ).addClass(cssStyle);
});