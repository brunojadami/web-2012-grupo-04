<%@page import="webproject.*" %>
<% 
PageType pageType = (PageType) pageContext.getAttribute("pageType");
String email = (String) session.getAttribute("email");

if (pageType == pageType.INDEX && email != null)
{
    pageContext.forward("control_panel.jsp");
}
else if (pageType != pageType.INDEX && email == null)
{
    pageContext.forward("index.jsp");
}
%>