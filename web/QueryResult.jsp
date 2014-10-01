<%-- 
    Document   : QueryResult
    Created on : 01/10/2014, 15:43:27
    Author     : Bruom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Storator - Restulados da Busca</title>
    </head>
    <body>
        <h3>Resultados:</h3>
        
        <c:if test="${fn:length(produtos) eq 0}">
            <c:out value="Nenhum produto encontrado!"/>
        </c:if>
        
        <c:if test="${fn:length(produtos) ne 0}">
            <c:out value="${fn:length(produtos)} resultados para a busca." /><br><br>
            <c:forEach var="prod" items="${produtos}">
                <%-- PARA CADA PRODUTO, EXIBIR AQUI --%>
                <div class="itemLista">
                    <img src="${prod.imgurl}" alt="${prod.nome}"/>
                    <c:out value="${prod.nome}"/>
                    <c:out value="${prod.preco}"/>
                    <a href="${pageContext.request.contextPath}/FrontController?opcao=view${produto.cod}"/>
                </div>
            </c:forEach>
        </c:if>
                
    </body>
</html>
