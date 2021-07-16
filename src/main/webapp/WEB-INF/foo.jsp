<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="${pageContext.request.contextPath}/foo" method="post">
  <label for="foo">Foo</label>
  <input id="foo" name="foo" value="${fn:escapeXml(param.foo)}">
  <span class="error">${messages.foo}</span>
  <br />
  <label for="bar">Bar</label>
  <input id="bar" name="bar" value="${fn:escapeXml(param.bar)}">
  <span class="error">${messages.bar}</span>
  <br />
  ...
  <input type="submit">
  <span class="success">${messages.success}</span>
</form>
