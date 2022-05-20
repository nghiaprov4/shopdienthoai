
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
        <title>Cập nhật sản phẩm</title>
    </head>
    <body>
        <c:url var="addUrl" value="/dienthoai/capnhatsp">
        </c:url>
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
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


                <div class="col pt-2">
                    <form:form modelAttribute="dienthoai" method="POST" action="${addUrl}" enctype="multipart/form-data">
                        <form:hidden path="id" />
                        <h1 style="text-align: center">CẬP NHẬT SẢN PHẨM </h1>
                        <br/> 
                      
                            <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputLoai">Loại điện thoại</label>

                                <select id="inputLoai" class="form-control" name="ldt">
                                    <c:forEach items="${listLoaiDienThoai}" var="loaiDienThoai">
                                        <option value="${loaiDienThoai.maLoai}" label="${loaiDienThoai.tenLoai}" />
                                    </c:forEach>
                                </select>

                            </div>


                            <div class="form-group col-md-6">
                                <label for="inputNsx">Nhà sản xuất</label>
                                <select id="inputNsx" class="form-control" name="nsx">
                                    <c:forEach items="${listNsx}" var="nhaSanXuat">
                                        <option value="${nhaSanXuat.maNsx}" label="${nhaSanXuat.tenNsx}" />
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="inputDongMay">Dòng máy</label>
                                <form:input path="dongMay" class="form-control" id="inputDongMay" />
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputModel">Model</label>
                                <form:input path="model" class="form-control" id="inputModel" required="required" />
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputMauSac">Màu sắc</label>
                                <form:select path="mauSac" id="inputMauSac" class="form-control" name="mausac">
                                    <form:option value="Trắng" label="Trắng"></form:option>
                                    <form:option value="Đen" label="Đen"></form:option>
                                    <form:option value="Xám" label="Xám"></form:option>
                                    <form:option value="Đỏ" label="Đỏ"></form:option>
                                    <form:option value="Hồng" label="Hồng"></form:option>
                                    <form:option value="Xanh nước biển" label="Xanh nước biển"></form:option>
                                    <form:option value="Xanh lá cây" label="Xanh lá cây"></form:option>
                                    
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group" >
                            <label for="inputMota">Mô tả</label>
                            <form:input path="moTa" class="form-control" id="inputMoTa" required="required"    />
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputDoPhanGiai">Độ phân giải màn hình</label>
                          
                            <form:input path="doPhanGiai" class="form-control" id="inputDoPhanGiai" required="required"  name="dophangiai" />

                            </div>
                             <div class="form-group col-md-6">
                                <label for="inputDungLuongPin">Dung lượng pin</label>
                          
                            <form:input path="dungLuongPin" class="form-control" id="inputDungLuongPin" required="required"  />

                            </div>
                             <div class="form-group col-md-6">
                                <label for="inputBoNhoTrong">Bộ nhớ trong</label>
                          
                            <form:input path="boNhoTrong" class="form-control" id="inputBoNhoTrong" required="required"  />

                            </div>
                             <div class="form-group col-md-6">
                                <label for="inputRam">Ram</label>
                          
                            <form:input path="ram" class="form-control" id="inputRam" required="required"  />

                            </div>
                            
                            <div class="form-group col-md-6">
                                <label for="inputChipXuLy">Chíp xử lý</label>
                          
                            <form:input path="chipXuLy" class="form-control" id="inputChipXuLy" required="required"  />

                            </div>
                            
                                <div class="form-group col-md-6">
                                <label for="inputCamara">Camera</label>
                          
                            <form:input path="camara" class="form-control" id="inputCamara" required="required"  />

                            </div>
                            
                            <div class="form-group col-md-4">
                                <label for="inputGiaNhap">Giá nhập</label>
                                
                                <form:input path="giaNhap"  class="form-control" id="GiaNhap" required="required"/>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="inputGiaBan">Giá bán</label>
                                <form:input path="giaBan"  class="form-control" id="GiaBan" required="required"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="inputSlt">Số lượng tồn</label>
                                <form:input path="soLuongTon" onblur="validate_soLuong()" class="form-control" id="inputSlt" required="required"/>
                            </div>
                            <div class="form-group col-md-4 border">
                                <label for="inputHinh">Hình ảnh</label>
                                <input type="file" name="file" class="form-control-file" id="inputHinh" accept="image/png,image/jpeg" required="required">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputXuatXu">Xuất xứ</label>
                                <form:select path="xuatXu" id="inputXuatXu" class="form-control" name="xuatxu">
                                    <form:option value="Trung Quốc" label="Trung Quốc"></form:option>
                                    <form:option value="Nhật Bản" label="Nhật Bản"></form:option>
                                    <form:option value="Hàn Quốc" label="Hàn Quốc"></form:option>
                                    <form:option value="Mỹ" label="Mỹ"></form:option>
                                    <form:option value="Việt Nam" label="Việt Nam"></form:option>
                                </form:select>

                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Lưu sản phẩm</button>
                                    </form:form>
                           </div>
    				</div>
        </div>
  </body>
  </html>
