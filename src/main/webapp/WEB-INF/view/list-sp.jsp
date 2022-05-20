
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
        <script src="<c:url value='/resources/jquery/jquery-3.5.0.min.js' />" ></script>
        <script src="<c:url value='/resources/bootstrap/bootstrap.min.js' />" ></script>--%>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Trang chủ</title>
    </head>
    <body>
        <c:url var="adminPage" value="/admin/trangchu"/>
        <c:url var="viewImgUrlsp1" value="/resources/img/iphone13promax512gb.png" />
        <c:url var="viewImgUrlsp2" value="/resources/img/iphone13.png" />
        <c:url var="viewImgUrlsp3" value="/resources/img/samsunggalaxy22ultra.png" />
        <c:url var="viewImgUrlsp4" value="/resources/img/samsunggalaxy22.png" />
        <c:url var="viewImgUrlsp5" value="/resources/img/iphone112.png" />
        <c:url var="viewImgUrl2" value="/resources/img/cart3.png" />
        <c:url var="viewImgUrlUser" value="/resources/img/user.png" />
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="formDangKi" value="/taikhoan/formdangki"></c:url>
        <c:url var="xemgiohang" value="/giohang/xemgiohang"></c:url>
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
            <c:if test="${!empty tk}">
                <div class="alert alert-warning col-md-12">
                    Thanh toán thành công
                </div>
            </c:if>
            <h3 class="my-4">Sản phẩm hot nhất hiện nay</h3>

            <div class="card-deck">
                <div class="card">
                    <img class="card-img-top" src="${viewImgUrlsp1}" alt="" style="width: 100%;">
                    <div class="card-body">
                        <h6 class="card-title">Điện thoại di động Apple iPhone 13 Pro Max - 512GB - Chính hãng VN/A</h6>
                        <p class="card-title" style="color: red">36,990,000 ₫ </p><i> Giá đã bao gồm 10% VAT</i>
                        
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="${viewImgUrlsp2}" alt="" style="width: 100%;">
                    <div class="card-body">
                        <h6 class="card-title">Điện thoại di động Apple iPhone 13 - 512GB - Chính hãng VN/A</h6>
                        <p class="card-title" style="color: red">25,980,000 ₫  </p><i> Giá đã bao gồm 10% VAT</i>

                        
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="${viewImgUrlsp3}" alt="" style="width: 100%;">
                    <div class="card-body">
                         <h6 class="card-title">Điện thoại di động Samsung Galaxy S22 Ultra - 12GB/512GB - Chính hãng
</h6>
                        <p class="card-title" style="color: red">31,650,000 ₫  </p><i> Giá đã bao gồm 10% VAT</i>
                        
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="${viewImgUrlsp4}" alt="" style="width: 100%;">
                    <div class="card-body">
                       <h6 class="card-title">Điện thoại di động Samsung Galaxy S22 - 8GB/128GB - Chính hãng</h6>
                        <p class="card-title" style="color: red">17,350,000 ₫  </p><i> Giá đã bao gồm 10% VAT</i>
                        
                       
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="${viewImgUrlsp5}" alt="" style="width: 100%;">
                    <div class="card-body">
                      <h6 class="card-title">Apple iPhone 12 - 256GB - Chính hãng VN/A
</h6>
                        <p class="card-title" style="color: red">22,390,000 ₫  </p><i> Giá đã bao gồm 10% VAT</i>
                        
                    </div>
                </div>

            </div>
            <hr>

            <!-- --------------------------------------------menu trai -->
            <div class="w-25 float-left my-2">
                <h5>Bộ lọc danh mục Điện thoại</h5>
                <div class="btn-group-vertical" style="width: 250px;">
                    <button type="button" class="btn btn-lg btn-outline-primary text-left" data-toggle="collapse"
                            data-target="#list1">Thương
                        hiệu</button>
                    <div id="list1" class="collapse">
                        <nav class="nav flex-column">
                            <c:forEach items="${listNsx}" var="dsNsx">
                                <c:url var="listsp" value="/dienthoai/listsp">
                                    <c:param name="tennsx" value="${dsNsx.tenNsx}"></c:param>
                                </c:url>
                                <a class="nav-link" href="${listsp}">${dsNsx.tenNsx}</a>
                            </c:forEach>


                        </nav>
                    </div>
                    <button type="button" class="btn btn-lg btn-outline-primary text-left" data-toggle="collapse"
                            data-target="#list2">Loại điện thoại</button>
                    <div id="list2" class="collapse">
                        <nav class="nav flex-column">
                            <c:forEach items="${listLoai}" var="dsLoai">
                                <c:url var="listsp" value="/dienthoai/listsp">
                                    <c:param name="loaimay" value="${dsLoai.tenLoai}"></c:param>
                                </c:url>
                                <a class="nav-link" href="${listsp}">${dsLoai.tenLoai}</a>
                            </c:forEach>
                        </nav>
                    </div>


                </div>
            </div>
            <div class="w-75 float-right border border-primary my-2">
                <div class="d-flex flex-wrap justify-content-between">
                    <c:forEach items="${listDienThoaiDto}" var="dienThoaiDTO">
                        <c:url var="chitietURL" value="/dienthoai/chitietsp">
                            <c:param name="masp" value="${dienThoaiDTO.id}"></c:param>
                        </c:url>
                        <div class="card" style="width: 274px;">
                            <img class="card-img-top" src="data:image/jpg;base64,${dienThoaiDTO.base64Image}" alt="" style="width: 100%;">
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${dienThoaiDTO.nhaSanXuat.tenNsx}"></c:out> 
                                    <c:out value="${dienThoaiDTO.dongMay}"></c:out> 
                                    <c:out value="${dienThoaiDTO.model}"></c:out></h5>
                                <h4 class="text-center" style="color: red"> <fmt:formatNumber value="${dienThoaiDTO.giaBan}"/> VNĐ </h4>
                              

                                <a href="${chitietURL}" class="btn btn-primary stretched-link" >Xem chi tiết</a>
                            </div>
                        </div>
                    </c:forEach>






                </div>
                <div class="my-2 mx-auto" style="width: 200px;">
                    <nav aria-label="...">
                        <ul class="pagination ">
                            <c:forEach var="i" begin="1" step="1" end="${sotrang}">
                                <c:url var="trangchutheopage" value="/dienthoai/listsp">
                                    <c:param name="page" value="${i}"></c:param>
                                </c:url>
                                <li class="page-item"><a class="page-link" href="${trangchutheopage}">${i}</a></li> 
                                </c:forEach>

                        </ul>
                    </nav>
                </div>




            </div>
        </div>
        <div class="clearfix">

        </div>
        <div >
          
            
            
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
