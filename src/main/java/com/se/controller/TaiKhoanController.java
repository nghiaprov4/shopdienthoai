/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.controller;

import com.se.entity.KhachHang;
import com.se.entity.VaiTro;
import com.se.service.KhachHangService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nghiathieu
 */
@RequestMapping("/taikhoan")
@Controller
public class TaiKhoanController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/formdangki")
    public String showFormDangKi(Model model) {
        KhachHang khachHang = new KhachHang();
        model.addAttribute("khachhang", khachHang);
        return "form-dangki";
    }

    @GetMapping("/formdangnhap")
    public String showFormDangNhap(Model model) {
        
        return "form-dangnhap";
    }

    @PostMapping("/xulidangki")
    public String xuLiDangKi(@ModelAttribute("khachhang") KhachHang khachHang) {

        VaiTro v = new VaiTro();
        v.setMaVaitro(2);
        khachHang.setVaiTro(v);
        khachHang.setTinhTrang(Boolean.TRUE);
//        String mk = khachHang.getMatKhau();
//        khachHang.setMatKhau("{noop}"+mk);
        khachHang.setMatKhau(new BCryptPasswordEncoder().encode(khachHang.getMatKhau()));
        khachHangService.saveKhachHang(khachHang);
        return "redirect:/dienthoai/listsp";
    }
    
    
    
    
    
//    @PostMapping("/xulidangnhap")
//    public String xuLiDangNhap(HttpSession session, @RequestParam(name = "taikhoan") String taikhoan,
//                                @RequestParam(name = "matkhau") String matkhau) {
//                
//        try {
//            System.out.println(taikhoan+matkhau);
//             KhachHang khachHang = khachHangService.findKhbyTk_Mk(taikhoan, matkhau);
//             String username = taikhoan;
//             session.setAttribute("username", username);
//             session.setAttribute("user", khachHang);
//             return "redirect:/dienthoai/listsp";
//        } catch (Exception e) {
//          
//           return "form-dangnhap";
//        }
//           
//    }

}
