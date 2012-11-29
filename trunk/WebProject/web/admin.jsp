<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.PageType"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<% pageContext.setAttribute("pageTitle", "Entrar");%>
<% pageContext.setAttribute("pageType", PageType.NONE);%>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body><f:view>
        <h1>Administração</h1> 

        <table id="optionsTable">
            <tr>
                <td>Opções</td>
                <td class="Right">
                    <a href="index.jsp"><img src="image/control_panel.png" title="Índice"/></a>
                </td>
            </tr>
        </table>
                    
        <h:dataTable value="#{loginManager.logins}" var="login">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="ID"/>
                </f:facet>
                <h:outputText value="#{login.id}"/>
            </h:column>
            <h:column> 
                <f:facet name="header">
                    <h:outputText value="Email"/>
                </f:facet>
                <h:outputText value="#{login.email}"/>
            </h:column>
            <h:column> 
                <f:facet name="header">
                    <h:outputText value="Senha"/>
                </f:facet>
                <h:outputText value="#{login.password}"/>
            </h:column>
            <h:column> 
                <f:facet name="header">
                    <h:outputText value="Habilitado"/>
                </f:facet>
                <h:outputText value="#{login.enabled}"/>
            </h:column>
            <h:column> 
                <f:facet name="header">
                    <h:outputText value="Ação"/>
                </f:facet>
                <h:form styleClass="Invisible">
                    <h:commandLink actionListener="#{loginManager.updateLogin(login.id, true)}">
                        <img src="image/enable.png" title="Habilitar"/>
                    </h:commandLink>
                    <h:commandLink actionListener="#{loginManager.updateLogin(login.id, false)}">
                        <img src="image/disable.png" title="Desabilitar"/>
                    </h:commandLink>
                        <h:commandLink actionListener="#{loginManager.deleteLogin(login.id)}">
                        <img src="image/delete.png" title="Deletar"/>
                    </h:commandLink>
                </h:form>
            </h:column>
        </h:dataTable>

    </f:view></body>
</html>
