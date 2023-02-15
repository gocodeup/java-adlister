<%--
  Created by IntelliJ IDEA.
  User: tripp
  Date: 2/14/23
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>

    // listeners
	$(".redirect").click(function(){
		console.log("fired");
		let id = $(this).attr("id");
		$(location).attr('href','/ads/ad?'+id);
	})
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

