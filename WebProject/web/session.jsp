<%@page import="webproject.bean.Login"%>
<%@page import="webproject.misc.PageType"%>
<% 
PageType pageType = (PageType) pageContext.getAttribute("pageType");
Login login = (Login) session.getAttribute("login");

if (pageType == pageType.INDEX && login != null)
{
    pageContext.forward("control_panel.jsp");
}
else if (pageType == pageType.SESSION && login == null)
{
    pageContext.forward("index.jsp");
}
%>