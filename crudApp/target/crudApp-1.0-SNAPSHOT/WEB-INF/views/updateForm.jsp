
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h1 class="text-center mb-3">Fill the details in Update form</h1>
            <form method="post" class="text-center" action="${pageContext.request.contextPath}/processUpdate">
                <div class="form-group">
                    <label for="name2">Name</label>
                    <input type="text"
                           class="form-control"
                           id="name2"
                           aria-describedby="emailHelp"
                           placeholder="Enter Product Name"
                           name="name">
                </div>
                <div class="form-group">
                    <label for="description2">Description</label>
                    <textarea class="form-control"
                              id="description2"
                              rows="3"
                              placeholder="Enter Product Description"
                              name="description">
                        </textarea>
                </div>
                <div class="form-group ">
                    <label for="pPrice2">Price</label>
                    <input type="number"
                           class="form-control"
                           id="pPrice2"
                           placeholder="Enter Product Price"
                           name="price">
                </div>
                <div>
                    <button type="submit" class="btn btn-secondary">Update</button>
                    <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Back</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
