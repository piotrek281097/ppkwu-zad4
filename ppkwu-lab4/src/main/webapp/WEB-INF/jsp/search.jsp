<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css" href="css/style.css"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <style type="text/css">
        .container {
            background-color: blueviolet;
            height: 300px;
            width: 700px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            vertical-align: middle;
        }
        table {
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }
        input{
            width: 100%;
            padding: 8px 8px;
            box-sizing: border-box;
        }
        button{
            background-color: green;
            width: 100%;
            padding: 8px 8px;
        }
    </style>
</head>
<body>

<form:form method="POST" action="/api/search" modelAttribute="person" acceptCharset="ISO 8859-16 UTF-8">
    <div class="container">
        <h2>Podaj dane pracownika</h2>
        <table class="search-table">
                <td><form:input path="name"/></td>
                <td><button type="submit">Szukaj</button></td>
        </table>
    </div>
</form:form>
</body>
</html>
