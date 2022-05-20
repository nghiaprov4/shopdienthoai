
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Máy <c:out value="${dienthoai.loaiDienThoai.tenLoai}"></c:out> <c:out value="${dienthoai.dongMay}"></c:out> (<c:out value="${dienthoai.model}"></c:out>)</title>
        </head>
        <body>
        <c:url var="viewImgUrl" value="/resources/img/appen2.png" />
        <c:url var="viewImgUrl2" value="/resources/img/cart1.png" />
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="adminPage" value="/admin/trangchu"/>
         <c:url var="formDangKi" value="/taikhoan/formdangki"></c:url>
         <c:url var="xemgiohang" value="/giohang/xemgiohang"></c:url>
        <c:url var="formdangnhap" value="/taikhoan/formdangnhap"></c:url>
        <c:url var="themgiohang" value="/giohang/themvaogio">
          <c:url var="qlsp" value="/admin/quanlisanpham" />
        <c:url var="qlkh" value="/admin/quanlitaikhoan" />
        <c:url var="qlhd" value="/admin/quanlihoadon" />
            <c:param name="masp" value="${dienthoai.id}"></c:param>
        </c:url>
        <c:url var="formdangnhap" value="/taikhoan/formdangnhap"></c:url>


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
                        Thương hiệu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                          <nav class="nav flex-column">
                            <c:forEach items="${listNsx}" var="dsNsx">
                                <c:url var="listsp" value="/dienthoai/listsp">
                                    <c:param name="tennsx" value="${dsNsx.tenNsx}"></c:param>
                                </c:url>
                                <a class="nav-link" href="${listsp}">${dsNsx.tenNsx}</a>
                            </c:forEach>


                        </nav>
                    </div>
                </li>
                
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Loại điện thoại
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                           <nav class="nav flex-column">
                            <c:forEach items="${listLoai}" var="dsLoai">
                                <c:url var="listsp" value="/dienthoai/listsp">
                                    <c:param name="loaimay" value="${dsLoai.tenLoai}"></c:param>
                                </c:url>
                                <a class="nav-link" href="${listsp}">${dsLoai.tenLoai}</a>
                            </c:forEach>
                        </nav>
                    </div>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="${formDangKi}">Đăng kí</a>
                </li>


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
                <li class="nav-item">
                    <a class="nav-link" href="${xemgiohang}"><img src="${viewImgUrl2}" height="27px">&nbsp; Giỏ hàng</a>
                </li>
            </ul>
        </nav>
 


        <div class="container">
            <div class="row">
                <div class="col-md-6 border">
                    <img src="data:image/jpg;base64,${dienthoai.base64Image}" alt="" width="100%" class="p-5">
                </div>
                <div class="col-md-6 p-4" style="line-height: 200%;">
                    <b>Thương hiệu : <c:out value="${dienthoai.nhaSanXuat.tenNsx}"></c:out></b>
                    <h4>Máy <c:out value="${dienthoai.loaiDienThoai.tenLoai}"></c:out> <c:out value="${dienthoai.dongMay}"></c:out> (<c:out value="${dienthoai.model}"></c:out>)</h4>
                        <h4>
                        <%--<fmt:setLocale value="vi_VN"/>--%>
                        <%--<fmt:setLocale value="en_US"/>--%>



                       <b style="color: red"><c:out value="${giaBan}"></c:out></b> 


                        </h4>
                        <h6>Đặc điểm nổi bật</h6>
                                            <i><c:out value="${dienthoai.moTa}"></c:out></i>   

                    <c:if test="${dienthoai.soLuongTon == 1}">
                        <p class="text-danger">Chỉ còn <c:out value="${dienthoai.soLuongTon}"></c:out> sản phẩm</p>
                    </c:if>

                    <form action=" ${themgiohang}" method="POST" >
                        <p>Số lượng</p>
                        <input type="number" min="1" max="${dienthoai.soLuongTon}" value="1" name="soluong">
                        
                        <button type="submit" class="btn btn-lg btn-primary col-md-12 mt-3">Thêm vào giỏ hàng</button>
                    </form>
                    
       			  <div class="col-4 p-2 my-3 mx-auto">
                    <a href="${trangchusp}" class="btn btn-danger"> <- Quay về trang chủ</a>
          	 	 </div>
                </div>
            </div>
            <hr>
      

                <div class="col-md-100 mx-auto text-center">
                    <div class="col-md-7">
                        <h2 style="">Thông tin chi tiết</h2>
                        <table class="table table-bordered" >
                            <tbody>
                                
                                <tr>
                                    <th>Thương hiệu</th>
                                    <td><c:out value="${dienthoai.nhaSanXuat.tenNsx}"></c:out></td>
                                </tr>
                                <tr>
                                    <th>Loại điện thoại</th>
                                    <td><c:out value="${dienthoai.loaiDienThoai.tenLoai}"></c:out></td>
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
                                    <td><b>Màu sắc</b></td>
                                    <td><c:out value="${dienthoai.mauSac}"></c:out></td>
                                </tr>
								<tr>
                                    <th>Dung lượng pin</th>
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

                            </tbody>
                        </table>
              
                </div>
             


        </div>
         <div class="bg-dark text-white text-center" style="height: 80px;">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <p>Nhóm 09: </p> 
                        <i style="padding-left: 50px">Thiều Quang Nghĩa</i>
                        <i style="padding-left: 100px">Bùi Quang Minh</i>
                        <i style="padding-left: 150px">Huỳnh Nguyễn Đức Hưng</i>
                        
                     
                        
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
