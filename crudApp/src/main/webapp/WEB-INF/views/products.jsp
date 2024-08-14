
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="base.jsp"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container mt-3">
    <div class="col-md-12">
        <h1 class="text-center mb-3">Welcome to Product App</h1>
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Product Name</th>
                <th scope="col">Product Description</th>
                <th scope="col">Product Price(INR)</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="p" >
            <tr>
                <td><c:out value="${p.getpName()}"/></td>
                <td><c:out value="${p.getpDescription()}"/></td>
                <td><c:out value="${p.getpPrice()}"/></td>
                <td>
                    <a href="delete/${p.getPid()}"><i class="fa-solid fa-trash"></i></a>
                    <a href="update/${p.getPid()}"><i class="fa-solid fa-pen-clip"></i></a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="text-center">
        <a href="${pageContext.request.contextPath}/add" class="btn btn-primary">Add</a>
        </div>
    </div>

</div>



</body>
</html>
