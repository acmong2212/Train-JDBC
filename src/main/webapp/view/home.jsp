<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <style>
        th, td {
            border: 1px solid;
            padding: 5px 5px;
        }
    </style>
</head>
<body>
<h1 style="margin-left: 700px">Dien Thoai Duc Thang</h1>
<button><a href="/create">Create</a></button>
<form action="" method="post">
<table style="width: 100%">
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Price</th>
        <th>Image</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="p" items="${products}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td><img src="${p.img}" height="400" width="600" alt="Khong hien thi"></td>
            <td>
                <button><a href="/?action=edit&id=${p.id}">Edit</a></button>
            </td>
            <td>
                <button><a href="/?action=delete&id=${p.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>

