<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.PageType"%>
<% pageContext.setAttribute("pageTitle", "Entrar"); %>
<% pageContext.setAttribute("pageType", PageType.INDEX); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/index.js" charset="utf-8"></script>
        
        <h1>Entrar</h1>
        
        <label class="Error" id="errorLabel">
            <%
            String message = (String) request.getAttribute("errorMessage");
            if (message != null)
            {
                out.println(message);
            }
            %>
        </label>
        
        <form name="form" method="POST" action="./Login" onsubmit="return validateForm();">
            
            <h3>Entrar</h3>
            <label>Email:</label>
            <input type="text" name="email"/>
            <label class="Small">Email/senha válidos: admin@admin.com/123456</label>
            <label>Senha:</label>
            <input type="password" name="password"/> 
            <label class="Small">Aceita todos os tipos de caracteres. Tamanho de 6 a 30</label>
            <input type="submit" value="Entrar"/>
            
        </form>
    </body>
</html>
