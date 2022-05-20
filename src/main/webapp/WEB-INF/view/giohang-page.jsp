
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
        <c:url var="adminPage" value="/admin/trangchu"/>
        <c:url var="viewImgUrl" value="/resources/img/x.png" />
        <c:url var="viewImgUrl2" value="/resources/img/cart1.png" />
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="formDangKi" value="/taikhoan/formdangki"></c:url>
        <c:url var="formdangnhap" value="/taikhoan/formdangnhap"></c:url>
        <c:url var="xuligiohang" value="/giohang/xuligiohang"></c:url>
        <c:url var="xoachitiet" value="/giohang/xoachitiet"></c:url>
        <c:url var="thanhtoan" value="/giohang/thanhtoan"></c:url>


       <nav class="navbar navbar-expand-lg back bg-dark">
                <a class="navbar-brand" href="${trangchusp}">ShopDienThoaiOnline.com</a>
            <ul class="navbar-nav ml-auto">
                <security:authorize access="hasRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${adminPage}">Admin</a>
                    </li>
                </security:authorize>
                     
        </nav>


        <div class="container mt-5">
            <div class="row">
                <div class="col-md-7">
                    <table class="table">
                        <thead>
                        <th class="text-secondary text-center table-secondary">#</th>
                        <th class="text-secondary text-center table-secondary">Mô tả</th>
                        <th class="text-secondary text-center table-secondary">Giá tiền</th>
                        <th class="text-secondary text-center table-secondary">Số lượng</th>

                        </thead>
                        <tbody>
                            <c:set var="total" value="${0}"/>
                            <c:forEach items="${giohang}" var="dienthoai">

                                <tr class="border-bottom">
                            <form method="GET" action="${xoachitiet}">
                                <td class="text-center">
                                    <input type="hidden" name="id" value="${dienthoai.dienThoai.id}">
                                    <input name="remove" type="image" src="${viewImgUrl}"  style="width: 30px;height: 30px;"></td>
                            </form>
                            <td class="text-success text-center"><c:out value="${dienthoai.dienThoai.nhaSanXuat.tenNsx}" />
                                <c:out value="${dienthoai.dienThoai.dongMay}" />
                                <c:out value="${dienthoai.dienThoai.model}" /></td>
<%--                             <td class="text-success text-center"><c:out value="${dienthoai.dienThoai.giaBan}"></c:out>
 --%>                            
                            <td class="text-success text-center">     <fmt:formatNumber value="${dienthoai.dienThoai.giaBan}"/> 
                            
                            
                            
                            
                            
                                <c:set var="tongtien" value="${dienthoai.dienThoai.giaBan * dienthoai.soLuong}" />
                            </td>
                            <c:set var="total" value="${total + tongtien}" />
                            <td class="text-success text-center">${dienthoai.soLuong}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>



                <div class="col-md-5">
                    <c:if test="${not empty khachhang}">
                        <div class="col-md-12 text-center bg-light">
                            <h5>Thông tin khách hàng</h5>
                            <div class="row">
                                <div class="col-md-6 border-right">
                                    <p>${khachhang.ho} ${khachhang.ten}</p>
                                </div>
                                <div class="col-md-6">
                                    <p>${khachhang.email}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <p>${khachhang.diaChiNha}, ${khachhang.phuong}, ${khachhang.quan}, ${khachhang.thanhPho}
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <div class="col-md-12 border p-2">
                        <div class="row pt-2">
                            <div class="col-md-6 ">
                                <p>Tổng tiền</p>
                            </div>
                            <div class="col-md-6 text-right">

                                <h4 class="text-danger"> <fmt:setLocale value = "vi_VN"/>
                                    <fmt:formatNumber value = "${total}"/> đ
                                </h4>
                            </div>

                        </div>
                        <c:if test="${!empty giohang}">
                            <form method="POST" action="${thanhtoan}">
                                <button type="submit" class="btn btn-primary col-md-12">Thanh Toán</button>
                            </form>
                        </c:if>
                    </div>

                </div>



            </div>

            <div class="row">
                <div class="col-md-8">
                    <h3>Danh sách sản phẩm đã chọn</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-md-8 d-flex flex-wrap">

                    <c:forEach items="${listsp}" var="sp">
                        <div class="col-md-3">
                            <img src="data:image/jpg;base64,${sp.base64Image}" class="img-thumbnail" alt="alt" />
                            <p>${sp.nhaSanXuat.tenNsx} ${sp.dongMay} ${sp.model}</p>
                        </div>
                    </c:forEach> 

                </div>
            </div>
        </div>    
        <script>
            var gia = ${total};
        </script>

    </body>
</html>
