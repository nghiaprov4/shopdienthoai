
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
        <title>Điện thoại <c:out value="${dienthoai.loaiDienThoai.tenLoai}"></c:out> <c:out value="${dienthoai.dongMay}"></c:out> (<c:out value="${dienthoai.model}"></c:out>)</title>
        </head>
        <body>
        <c:url var="viewImgUrl" value="/resources/img/appen2.png" />
        <c:url var="viewImgUrl2" value="/resources/img/cart1.png" />
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="capnhatsp" value="/dienthoai/showFormCapNhat">
            <c:param name="masp" value="${dienthoai.id}"></c:param>
        </c:url>
        <c:url var="xoasp" value="/dienthoai/xoasp">  
            <c:param name="masp" value="${dienthoai.id}"></c:param>
        </c:url>
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="qlsp" value="/admin/quanlisanpham" />
        <c:url var="formdangnhap" value="/taikhoan/formdangnhap"></c:url>
        <c:url var="qlkh" value="/admin/quanlitaikhoan" />
        <c:url var="qlhd" value="/admin/quanlihoadon" />
        <c:url var="adminPage" value="/admin/trangchu"/>




         
         
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
                            <a class="nav-link text-truncate" href="${qlsp}">Quản lí sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link collapsed text-truncate" href="${qlkh}">Quản lí tài khoản</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-truncate" href="${qlhd}">Quản lí đơn hàng</a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-6">
                            <h2 style="visibility: hidden;">Thông tin chi tiết</h2>
                            <img src="data:image/jpg;base64,${dienthoai.base64Image}" class="img-fluid" />
                            <div class="col-md-8 mx-auto mt-4">
                                <a href="${capnhatsp}" class="btn-lg btn-primary ">Cập nhật</a>                                   
                                <a href="${xoasp}" class="btn-lg btn-danger " onclick="return confirm('Bạn có muốn xóa?') ? true : false;">Xóa</a>
                               
                            </div>


                        </div>

                        <div class="col-md-6">
                            <h2>Thông tin chi tiết</h2>
                            <table class="table table-bordered">
                                <tbody>
                                    <tr>
                                        <td><b>Thương hiệu</b></td>
                                        <td><c:out value="${dienthoai.nhaSanXuat.tenNsx}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <th>Loại điện tthoại</th>
                                            <td><c:out value="${dienthoai.loaiDienThoai.tenLoai}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <th>Dòng máy</th>
                                            <td><c:out value="${dienthoai.dongMay}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <th>Model</th>
                                            <td><c:out value="${dienthoai.model}"></c:out></td>
                                        </tr>
                                         <tr>
                                            <th>Dung lương pin</th>
                                            <td><c:out value="${dienthoai.dungLuongPin}"></c:out></td>
                                        </tr>
                                         <tr>
                                            <th>Bộ nhớ trong</th>
                                            <td><c:out value="${dienthoai.boNhoTrong}"></c:out></td>
                                        </tr>
                                         <tr>
                                            <th>Ram</th>
                                            <td><c:out value="${dienthoai.ram}"></c:out></td>
                                        </tr>
                                         <tr>
                                            <th>Chip xử lý</th>
                                            <td><c:out value="${dienthoai.chipXuLy}"></c:out></td>
                                        </tr>
                                         <tr>
                                            <th>Camera</th>
                                            <td><c:out value="${dienthoai.camara}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <th>Màu sắc</th>
                                            <td><c:out value="${dienthoai.mauSac}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <th>Xuất xứ</th>
                                            <td><c:out value="${dienthoai.xuatXu}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <th>Độ phân giải</th>
                                            <td><c:out value="${dienthoai.doPhanGiai}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td> <b>Số lượng tồn</b></td>
                                            <td><c:out value="${dienthoai.soLuongTon}"></c:out></td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>



                </div>
            </div>



        </div>
    </body>
</html>
