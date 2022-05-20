/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.controller;

import com.se.entity.ChiTietHoaDon;
import com.se.entity.DienThoai;
import com.se.entity.DienThoaiDTO;
import com.se.entity.HoaDon;
import com.se.entity.KhachHang;
import com.se.service.ChiTietHoaDonService;
import com.se.service.DienThoaiService;
import com.se.service.HoaDonService;
import com.se.service.KhachHangService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nghiathieu
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DienThoaiService dienThoaiService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    @GetMapping("/trangchu")
    public String showTrangChu(Model model) {
        List<DienThoaiDTO> listDienThoaiDTo = new ArrayList<>();
        List<DienThoai> listDienThoai = dienThoaiService.getListDienThoai();
        DienThoaiDTO dienThoaiDTO = null;
        for (DienThoai dienThoai : listDienThoai) {
            dienThoaiDTO = dienThoaiService.getDienThoaiDTO(dienThoai.getId());
            listDienThoaiDTo.add(dienThoaiDTO);
            System.out.println(listDienThoaiDTo.size());
        }
        model.addAttribute("listDienThoaiDto", listDienThoaiDTo);
        return "admin-page";
    }

    @GetMapping("/quanlisanpham")
    public String showTrangQuanLiSP(Model model,
            @RequestParam(value = "tennsx", required = false) String tennsx) {
        List<DienThoaiDTO> listDienThoaiDTo = new ArrayList<>();
        List<DienThoai> listDienThoai = null;
        DienThoaiDTO dienThoaiDTO = null;
        if(tennsx !=null){
            listDienThoai = dienThoaiService.getListDienThoaiTheoNsx(tennsx);
        }
        else{
            listDienThoai=dienThoaiService.getListDienThoai();
        }
        for (DienThoai dienThoai : listDienThoai) {
            dienThoaiDTO = dienThoaiService.getDienThoaiDTO(dienThoai.getId());
            listDienThoaiDTo.add(dienThoaiDTO);
            System.out.println(listDienThoaiDTo.size());
        }
        model.addAttribute("listDienThoaiDto", listDienThoaiDTo);
        return "admin-quanlisanpham";
    }

    @GetMapping("/chitietsp")
    public String showChiTietAdmin(@RequestParam("masp") String masp, Model model) {
        int maDienThoai = Integer.parseInt(masp);
        DienThoaiDTO dienThoaiDTO = dienThoaiService.getDienThoaiDTO(maDienThoai);
        model.addAttribute("dienthoai", dienThoaiDTO);
        return "admin-chitietsanpham";
    }

    @GetMapping("/quanlitaikhoan")
    public String showTrangQuanLiTk(Model model) {

        List<KhachHang> listKh = khachHangService.danhSachKh();
        model.addAttribute("listkh", listKh);

        return "admin-quanlitaikhoan";
    }

    @GetMapping("/xemchitiettk")
    public String showChiTietKh(@RequestParam("maKh") String makh, Model model) {
        int ma_kh = Integer.parseInt(makh);
        KhachHang k = khachHangService.getKhachHang(ma_kh);
        model.addAttribute("khachhang", k);

        return "admin-chitiettk";
    }

    @GetMapping("/xoatk")
    public String xoaKh(@RequestParam("maKh") String makh, Model model) {
        int ma_kh = Integer.parseInt(makh);
        KhachHang k = khachHangService.getKhachHang(ma_kh);
        khachHangService.xoaKhachHang(ma_kh);
        return "redirect:/admin/quanlitaikhoan";
    }

    @GetMapping("/quanlihoadon")
    public String showDanhSachHd(Model model) {
        List<HoaDon> listHd = hoaDonService.showDsHD();
        model.addAttribute("listhd", listHd);
        return "admin-quanlihoadon";
    }
    
    @GetMapping("/xemchitiethd")
//    public String showchitiethd(@RequestParam("maHd") int maHd,@RequestParam("masp") int masp,Model model) {
    public String showchitiethd(@RequestParam("maHd") int maHd,Model model) {

    	int ma_hd = maHd;
//    	int ma_sp = masp;
        List<ChiTietHoaDon> listctHD = chiTietHoaDonService.getChiTietTheoMaHd(ma_hd);
//        List<ChiTietHoaDon> listctHDsp = chiTietHoaDonService.getDienThoaiTheoMaSp(ma_sp);

        model.addAttribute("listct", listctHD);
//        model.addAttribute("listctHDsp", listctHDsp);

        return "admin-chitiethd";
    }

}
