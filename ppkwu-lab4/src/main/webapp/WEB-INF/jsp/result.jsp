<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css" href="css/style.css"/>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        .table-bordered{
            width:100%;
            border-collapse:collapse;
        }
        .table-bordered td{
            padding:7px; border:#9A10F6 1px solid;
        }
        .table-bordered tr{
            background: #FEFEFE;
        }
        button{
            background-color: green;
            width: 100%;
            padding: 8px 8px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Lista wyników</h1>
<table class="table table-bordered table-striped">
    <thead class="thead-dark">
    <tr>
        <th scope="col">          </th>
        <th scope="col">Nazwa</th>
        <th scope="col">Tytuł</th>
        <th scope="col">Miejsce pracy</th>
        <th scope="col">          </th>
    </tr>
    </thead>
    <c:forEach items="${people}" var="person" varStatus="theCount">
        <form:form method="POST" action="generate-vcard/${nameGivenByUser}/${theCount.index}" modelAttribute="person" acceptCharset="ISO 8859-16 UTF-8">
            <tr>
                <td>${theCount.index + 1}</td>
                <td>${person.getName()}</td>
                <td>${person.getTitle()}</td>
                <td>${person.getPlace()}</td>
                <td><button type="submit">Generuj vCard</button></td>
            </tr>

<%--            <tr>--%>
<%--                <td>Imie</td>--%>
<%--                <td>${person.getName()}</td>--%>
<%--                <td><form:input type="hidden" path="name" value="${person.getName()}"/></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>Tytul</td>--%>
<%--                <td>${person.getTitle()}</td>--%>
<%--                <td><form:input type="hidden" path="title" value="${person.getTitle()}"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Miejsce pracy</td>--%>
<%--                <td>${person.getPlace()}</td>--%>
<%--                <td><form:input type="hidden" path="place" value="${person.getPlace()}"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>--%>
<%--                    <button type="submit">Generuj vCard</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
        </form:form>
    </c:forEach>
</table>

</body>
</html>
