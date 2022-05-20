
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
        <title>Quản lí sản phẩm</title>
    </head>
    <body>

        <c:url var="formThem" value="/dienthoai/showFormThem"></c:url>
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="imgSamsung" value="/resources/img/samsung2.jpg"></c:url>
        <c:url var="imgapple" value="/resources/img/apple-logo.jpg"></c:url>
        <c:url var="xiaomi" value="/resources/img/xiaomi.jpg"></c:url>
        <c:url var="oppo" value="/resources/img/OPPO_LOGO_2019.png"></c:url>
        <c:url var="nokia" value="/resources/img/Nokia-Logo.png"></c:url>
        <c:url var="formdangnhap" value="/taikhoan/formdangnhap"></c:url>
        <c:url var="qlsp" value="/admin/quanlisanpham" />
        <c:url var="qlkh" value="/admin/quanlitaikhoan" />
        <c:url var="qlhd" value="/admin/quanlihoadon" />


       
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
                            <a class="nav-link text-truncate disabled" href="${qlsp}" >Quản lí sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-truncate" href="${qlkh}">Quản lí tài khoản</a>
                        </li>
                        <li class="nav-item"><a class="nav-link text-truncate" href="${qlhd}">
                                Quản lí đơn hàng</a></li>
                    </ul>
                </div>
                <div class="col pt-2">
                    <h2 class="font-weight-normal">Thương hiệu sản xuất</h2>
                    <div class="row d-flex justify-content-between">
                        <c:url var="nsx1" value="/admin/quanlisanpham">
                            <c:param name="tennsx" value="Canon"></c:param>
                        </c:url>
                         <c:url var="nsx2" value="/admin/quanlisanpham">
                            <c:param name="tennsx" value="HP"></c:param>
                        </c:url>
                         <c:url var="nsx3" value="/admin/quanlisanpham">
                            <c:param name="tennsx" value="Epson"></c:param>
                        </c:url>
                         <c:url var="nsx4" value="/admin/quanlisanpham">
                            <c:param name="tennsx" value="Brother"></c:param>
                        </c:url>
                         <c:url var="nsx5" value="/admin/quanlisanpham">
                            <c:param name="tennsx" value="Samsung"></c:param>
                        </c:url>
                        <div class="col-md-2">
                            <a href="${nsx5}"><img class="img-thumbnail" src="${imgSamsung}" ></a>
                        </div>
                        <div class="col-md-2">
                            <a href="${nsx3}"><img class="img-thumbnail" src="${imgapple}" ></a>
                        </div>
                        <div class="col-md-2">
                            <a href="${nsx2}"><img class="img-thumbnail" src="${xiaomi}" ></a>
                        </div>
                        <div class="col-md-2">
                            <a href="${nsx4}"><img class="img-thumbnail" src="${nokia}"></a>
                        </div>
                        <div class="col-md-2">
                            <a href="${nsx1}"><img class="img-thumbnail" src="${oppo}"></a>
                        </div>

                    </div>
                    <hr>
                    <h2 class="text-center font-weight-normal" style="font-size: 3em;">Danh sách sản phẩm</h2>
                    <a href="${formThem}" class='btn btn-lg btn-outline-warning col-md-12 mb-2'>+ Thêm mới</a>
                    <div class="d-flex flex-wrap justify-content-between">
                        <div class="d-flex flex-wrap justify-content-between">
                            <c:forEach items="${listDienThoaiDto}" var="dienThoaiDTO">
                                <c:url var="chitietURL" value="/admin/chitietsp">
                                    <c:param name="masp" value="${dienThoaiDTO.id}"></c:param>
                                </c:url>
                                <div class="card" style="width: 274px;">
                                    <img class="card-img-top" src="data:image/jpg;base64,${dienThoaiDTO.base64Image}" alt="" style="width: 100%;">
                                    <div class="card-body">
                                        <h5 class="card-title"><c:out value="${dienThoaiDTO.nhaSanXuat.tenNsx}"></c:out> 
                                            <c:out value="${dienThoaiDTO.dongMay}"></c:out> 
                                            <c:out value="${dienThoaiDTO.model}"></c:out></h5>
                                        <p class="card-text">${dienThoaiDTO.giaBan}</p>
                                        <a href="${chitietURL}" class="btn btn-primary stretched-link">Xem chi tiết</a>
                                    </div>
                                </div>
                            </c:forEach>                        
                        </div>

                    </div>

                    
                </div>
            </div>


        </div>
    </body>
</html>
