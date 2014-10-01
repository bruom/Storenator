<%-- 
    Document   : ViewProduct
    Created on : 01/10/2014, 15:36:11
    Author     : Bruom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Storator - ${produto.nome}</title>
    </head>
    <body>
        <h3>${produto.nome}</h3>
        <img src="${produto.imgurl}" alt="${prduto.nome}"/>
        <c:out value="${produto.descricao}"/>
    </body>
</html>
