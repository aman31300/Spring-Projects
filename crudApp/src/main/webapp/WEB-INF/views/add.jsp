
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container mt-3">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h1 class="text-center mb-3">Fill the details</h1>
                <form action="process" method="post" class="text-center">
                    <div class="form-group">
                        <label for="name">Email address</label>
                        <input type="text"
                               class="form-control"
                               id="name"
                               aria-describedby="emailHelp"
                               placeholder="Enter Product Name"
                               name="pName">
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control"
                                  id="description"
                                  rows="3"
                                  placeholder="Enter Product Description"
                                  name="pDescription">

                        </textarea>
                    </div>
                    <div class="form-group ">
                        <label for="pPrice">Price</label>
                        <input type="number"
                               class="form-control"
                               id="pPrice"
                               placeholder="Enter Product Price"
                               name="pPrice">
                    </div>
                    <div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                        <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Back</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
