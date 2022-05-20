
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Chi tiết hóa đơn</title>
    </head>
    <body>
        <c:url var="qlsp" value="/admin/quanlisanpham" />
        <c:url var="qlkh" value="/admin/quanlitaikhoan" />
        <c:url var="qlhd" value="/admin/quanlihoadon" />
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="formdangnhap" value="/taikhoan/formdangnhap"></c:url>
        <c:url var="xemgiohang" value="/giohang/xemgiohang"></c:url>
        <c:url var="viewImgUrl2" value="/resources/img/cart1.png" />
        
      <nav class="navbar navbar-expand-lg back bg-dark">
                <a class="navbar-brand" href="${trangchusp}">ShopDienThoaiOnline.com</a>
            <ul class="navbar-nav ml-auto">
                <security:authorize access="hasRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${adminPage}">Admin</a>
                    </li>
                </security:authorize>
                

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Tài khoản
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <security:authorize access="isAuthenticated() == false">
                            <a class="dropdown-item" href="${formdangnhap}">Đăng nhập</a>
                        </security:authorize>
                        <security:authorize access="isAuthenticated()">
                            <p class="dropdown-item"">${khachhang.ten}</p>
                        </security:authorize>

                        <security:authorize access="isAuthenticated()">
                            <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                                <input type="submit" class="dropdown-item " value="Đăng xuất"></input>
                            </form:form>
                        </security:authorize>
                    </div>
                </li>
              
            </ul>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-2 collapse show d-md-flex bg-light pt-2 pl-0 min-vh-100" id="sidebar">
                    <ul class="nav flex-column flex-nowrap overflow-hidden">
                        <li class="nav-item">
                            <a class="nav-link text-truncate " href="${qlsp}" >Quản lí sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-truncate" href="${qlkh}">Quản lí tài khoản</a>
                        </li>
                        <li class="nav-item"><a class="nav-link text-truncate" href="${qlhd}">
                                Quản lí đơn hàng</a></li>
                    </ul>
                </div>

                <div class="col pt-2">
                    <h2>Chi tiết hóa đơn</h2>
                    <table class="table">
                       	 <th>Mã hóa đơn</th>
<!--                         <th>Tên Sản phẩm</th>
 -->                        <th>Số lượng</th>
                        
                        
                            <c:forEach items="${listct}" var="ct">
                            <tr>
                                <td>${ct.hoaDon.maHd}</td>                             
                                <td>${ct.soLuong}</td>

                                

                            </tr>
                        </c:forEach>
                          <c:forEach items="${listctHDsp}" var="ct">
                            <tr>
                                <td>${ct.dienThoai.model}</td>                             

                                

                            </tr>
                        </c:forEach>
                          
                    </table>


                </div>
            </div>
        </div>
    </body>
</html>
