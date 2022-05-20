/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.config;

import com.se.dao.KhachHangDao;
import com.se.entity.KhachHang;
import com.se.service.KhachHangService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author nghiathieu
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private KhachHangService khachHangService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        String username = a.getName();
        System.out.println("userName=" + username); 

        KhachHang kh = khachHangService.loadkh_tentk(username);

        HttpSession session = request.getSession();
        session.setAttribute("khachhang", kh);

        response.sendRedirect(request.getContextPath() + "/");

    }

}
