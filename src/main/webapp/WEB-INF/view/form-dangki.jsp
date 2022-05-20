
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
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="adminPage" value="/admin/trangchu"/>
        <c:url var="viewImgUrl" value="/resources/img/appen2.png" />
        <c:url var="viewImgUrl2" value="/resources/img/cart1.png" />
        <c:url var="trangchusp" value="/dienthoai/listsp"></c:url>
        <c:url var="xulidangki" value="/taikhoan/xulidangki"></c:url>
        <c:url var="formdangnhap" value="/taikhoan/formdangnhap"></c:url>



            <nav class="navbar navbar-expand-lg back bg-dark">
                <a class="navbar-brand" href="${trangchusp}">ShopDienThoaiOnline.com</a>
         
        </nav>



        <div class="container">
            <div class="row mt-5">
                <div class="col-md-7 mx-auto">
                    <h3 class="text-center">Đăng kí tài khoản</h3>
                    <form:form modelAttribute="khachhang" method="POST" action="${xulidangki}">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputHo">Họ</label>
                                <form:input path="ho" class="form-control" id="inputHo" placeholder="Nhập họ" required="required"  />
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputTen">Tên</label>
                                <form:input path="ten" class="form-control" id="inputTen" placeholder="Nhập Tên" required="required" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail">Email</label>
                            <form:input path="email" onblur="validate_emai()" class="form-control" id="inputEmail" placeholder="Nhập email" required="required" />
                            <p id="errEmail" class="text-danger" hidden>*Địa chỉ email sai</p>
                        </div>
                        <div class="form-group">
                            <label for="inputSdt">Số điện thoại </label>
                            <form:input path="sdt" onblur="validatesdt()" class="form-control" id="inputSdt" placeholder="Nhập số điện thoại" required="required" />
                            <p id="errSdt" class="text-danger" hidden>*Số điện thoại tối đa 10 số và không nhập chữ</p>
                        </div>
                        <div class="form-group">
                            <label for="inputTK">Tên tài khoản</label>
                            <form:input path="tenTaiKhoan" onblur="validate_tentk()" class="form-control" id="inputTK" placeholder="Nhập tên tài khoản" required="required" />
                            <p id="errTk" class="text-danger" hidden>*Tên tài khoản ít nhất 5 kí tự và không có kí tự đặc biệt</p>
                        </div>
                        <div class="form-group">
                            <label for="inputPass">Mật khẩu</label>
                            <form:password path="matKhau" onblur="validate_mk()" class="form-control" id="inputPass" placeholder="Nhập mật khẩu" required="required" />
                            <p id="errMk" class="text-danger" hidden>*Mật khẩu ít nhất 6 kí tự và không có kí tự đặc biệt</p>
                        </div>
                        <div class="form-group">
                            <label for="inputDc">Địa chỉ</label>
                            <form:input path="diaChiNha" class="form-control" id="inputDc" placeholder="Nhập địa chỉ" required="required" />
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="inputPx">Phường xã</label>
                                <form:input path="phuong" class="form-control" id="inputDc" placeholder="Nhập phường xã" required="required" />
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputQh">Quận huyện</label>
                                <form:input path="quan" class="form-control" id="inputDc" placeholder="Nhập quận huyện" required="required" />
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputTp">Tỉnh/ Thành Phố</label>
                                <form:input path="thanhPho" class="form-control" id="inputDc" placeholder="Nhập tỉnh/thành phố" required="required" />
                            </div>
                        </div>


                        <button type="submit" class="btn btn-primary col-md-12">Đăng kí</button>


                    </form:form>
                </div>
            </div>
        </div>


        <script>
            function validatesdt() {
                var sdt = document.getElementById("inputSdt").value;
                var sdtRegex = /^\d{10}$/;
                if (sdtRegex.test(sdt)) {
                    document.getElementById("errSdt").hidden = true;
                    return true;
                } else {
                    document.getElementById("errSdt").hidden = false;
                    return false;
                }
            }
            function validate_emai() {
                var email = document.getElementById("inputEmail").value;
                var emailRegex = /^[a-zA-Z]+[a-zA-Z0-9]+@gmail.com$/;
                if (emailRegex.test(email)) {
                    document.getElementById("errEmail").hidden = true;
                    return true;
                } else {
                    document.getElementById("errEmail").hidden = false;
                    return false;
                }
            }
            function validate_tentk() {
                var tentk = document.getElementById("inputTK").value;
                var tentkRegex = /^[a-zA-Z0-9]{5,}$/;
                if (tentkRegex.test(tentk)) {
                    document.getElementById("errTk").hidden = true;
                    return true;
                } else {
                    document.getElementById("errTk").hidden = false;
                    return false;
                }
            }
            function validate_mk() {
                var mk = document.getElementById("inputPass").value;
                //mk 5 ki tu tro len
                var mkRegex = /^[a-zA-Z0-9]{6,}$/;
                if (mkRegex.test(mk)) {
                    document.getElementById("errMk").hidden = true;
                    return true;
                } else {
                    document.getElementById("errMk").hidden = false;
                    return false;
                }
            }


        </script>        
    </body>
</html>
