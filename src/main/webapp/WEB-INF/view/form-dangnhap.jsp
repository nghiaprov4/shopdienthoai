
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="viewImgUrl" value="/resources/img/appen2.png" />
        <c:url var="viewImgUrl2" value="/resources/img/cart1.png" />
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="formDangKi" value="/taikhoan/formdangki"></c:url>
        <c:url var="xulidangnhap" value="/taikhoan/xulidangnhap"></c:url>



            <nav class="navbar navbar-expand-lg back bg-dark">
                <a class="navbar-brand" href="${trangchusp}">ShopDienThoaiOnline.com</a>
           
        </nav>


        <div class="container">
            <div class="row mt-5">
                <div class="col-md-4 mx-auto">
                    <c:if test="${param.logout !=null}">
                        <div class="alert alert-warning col-md-12">
                            Bạn vừa đăng xuất
                        </div>
                    </c:if>
                    <h3 class="text-center">Đăng nhập</h3>
                    <form action="${pageContext.request.contextPath}/taikhoan/xulidangnhap" method="POST">
                        <div class="form-group">
                            <label for="inputTk">Tài khoản</label>
                            <input type="text" name="taikhoan" class="form-control" id="inputTk" placeholder="Nhập tài khoản">
                        </div>
                        <div class="form-group">
                            <label for="inputMk">Mật khẩu</label>
                            <input type="password" name="matkhau" class="form-control" id="inputMk" placeholder="Nhập mật khẩu">
                        </div>
                        <div class="form-group">
                        	<a href="${formDangKi }">Bạn chưa có tài khoản?</a>
                        </div>
                       
                        <button class="btn btn-primary col-md-12" type="submit">Đăng nhập</button>
                      <c:if test="${param.error!= null}">

 <div style="color: red">
                            Xin lỗi! Bạn đã nhập sai username hoặc password
                        </div>
</c:if>
                      

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
