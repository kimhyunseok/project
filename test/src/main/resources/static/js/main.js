
$(document).ready(function() {
	$('.test').on('click', function(e) {
		$('.side-nav').toggleClass("open");
		$('#wrapper').toggleClass("open");
		e.preventDefault();
	});
});