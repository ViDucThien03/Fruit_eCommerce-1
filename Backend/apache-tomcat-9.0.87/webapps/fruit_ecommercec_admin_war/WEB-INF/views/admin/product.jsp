<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2024
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<title>Product</title>

<body>
<div class="col-sm-12 col-xl-12">
    <div class="bg-light rounded h-100 p-4">
        <h6 class="mb-4">Product</h6>
        <a href="addproduct" class="btn btn-primary mb-2"><span>+</span> Add new product</a>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">Giá</th>
                <th scope="col">Số lượng bán</th>
                <th scope="col">Số lượng còn</th>
                <th scope="col">Danh mục sản phẩm</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${paginationProduct}">
                <tr>
                    <th scope="row">${product.productId}</th>
                    <td>${product.productName}</td>
                    <td>${product.productPrice}</td>
                    <td>${product.sellQuantity}</td>
                    <td>${product.quantity}</td>
                    <td>${product.cateName}</td>
                    <td>
                        <a href="#" class="me-4"><i class="fa-solid fa-arrows-rotate"></i></a>
                        <a href="#"><i class="fa-solid fa-trash-can" style="width: 24px; height: 24px" onclick="deleteProduct('${product.productId}')"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/product/${i}">${i}</a></li>
                    </c:forEach>
                    <%--                <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
                    <%--                <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script>
    function deleteProduct(id) {
        let ans = confirm("Bạn có đồng ý xóa sản phẩm này?");
        if(ans){
            window.location = "delete/"+id;
        }
    }
</script>
</body>
