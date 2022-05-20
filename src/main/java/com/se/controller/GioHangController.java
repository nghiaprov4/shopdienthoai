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
import com.se.service.LoaiDienThoaiService;
import com.se.service.NhaSanXuatService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nghiathieu
 */
@Controller
@RequestMapping("/giohang")
public class GioHangController {

    @Autowired
    private DienThoaiService dienThoaiService;

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;
    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private LoaiDienThoaiService loaiDienThoaiService;

    @PostMapping("/themvaogio")
    public String themVaoGio(Model model, @RequestParam("masp") String masp,
            HttpSession session, @RequestParam("soluong") String soluong) {

        int ma_sp = Integer.parseInt(masp);
        int soLuong = Integer.parseInt(soluong);
        DienThoai dienThoai = dienThoaiService.getDienThoai(ma_sp);
        //System.out.println(mayIn.toString());
        //session.setAttribute("name", mayIn);
        if (dienThoai != null && dienThoai.getSoLuongTon() > 0) {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();

            chiTietHoaDon.setDienThoai(dienThoai);
            chiTietHoaDon.setSoLuong(soLuong);

            List<ChiTietHoaDon> chiTietHoaDons = (List<ChiTietHoaDon>) session.getAttribute("giohang");
            if (chiTietHoaDons == null) {
                chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
                session.setAttribute("giohang", chiTietHoaDons);
            } else {
                Iterator<ChiTietHoaDon> iterator = chiTietHoaDons.iterator();
                while (iterator.hasNext()) {
                    ChiTietHoaDon c = iterator.next();
                    if (c.getDienThoai().getId() == ma_sp) {
                        iterator.remove();
                        chiTietHoaDon.setDienThoai(dienThoai);
                        chiTietHoaDon.setSoLuong(soLuong + 1);
                    }
                }
            }
            chiTietHoaDons.add(chiTietHoaDon);
            session.removeAttribute("tk");
        }

        return "redirect:/dienthoai/listsp";
    }

    @GetMapping("/xemgiohang")
    public String xemGioHang(HttpSession session, Model model) {

        List<ChiTietHoaDon> chiTietHoaDons = (List<ChiTietHoaDon>) session.getAttribute("giohang");
        List<DienThoai> list = new ArrayList<>();
        List<DienThoaiDTO> listDto = new ArrayList<>();
        DienThoaiDTO dienThoaiDTO = null;
        if (chiTietHoaDons != null) {

            for (ChiTietHoaDon c : chiTietHoaDons) {
                DienThoai dt = c.getDienThoai();

                list.add(dt);
            }

            for (DienThoai dienThoai : list) {
                dienThoaiDTO = dienThoaiService.getDienThoaiDTO(dienThoai.getId());
                listDto.add(dienThoaiDTO);
            }
            session.setAttribute("listsp", listDto);
        }

        //session.setAttribute("mayi", mayIn);
        return "giohang-page";
    }

    @GetMapping("/xoachitiet")
    public String xoachitiet(@RequestParam(name = "remove", required = false) String rm, HttpSession session, @RequestParam("id") String id) {

        List<ChiTietHoaDon> chiTietHoaDons = (List<ChiTietHoaDon>) session.getAttribute("giohang");
        int masp = Integer.parseInt(id);
        if (id != null) {
            Iterator<ChiTietHoaDon> iterator = chiTietHoaDons.iterator();
            while (iterator.hasNext()) {
                ChiTietHoaDon c = iterator.next();
                if (c.getDienThoai().getId() == masp) {
                    iterator.remove();
                }
            }
        }
        session.setAttribute("giohang", chiTietHoaDons);
        return "redirect:/giohang/xemgiohang";
    }

    @PostMapping("/thanhtoan")
    public String thanhtoan(HttpSession session, Model model) {

        List<ChiTietHoaDon> chiTietHoaDons = (List<ChiTietHoaDon>) session.getAttribute("giohang");
        KhachHang khachHang = (KhachHang) session.getAttribute("khachhang");
        HoaDon hd = new HoaDon();
        hd.setNgayLapHd(LocalDate.now());
        hd.setMaKh(khachHang);
        hoaDonService.saveHoaDon(hd);
        for(ChiTietHoaDon ct : chiTietHoaDons){
            DienThoai dt = ct.getDienThoai();
            ct.setHoaDon(hd);
            ct.setDienThoai(dt);
            ct.setSoLuong(ct.getSoLuong());
            dt.setSoLuongTon(dt.getSoLuongTon()-ct.getSoLuong());
            dienThoaiService.capnhatsoluong(dt);
            System.out.println(ct.getDienThoai());
            System.out.println(ct.getHoaDon());
            chiTietHoaDonService.saveChiTietHoaDon(ct);
        }
        
        session.removeAttribute("giohang");
        session.setAttribute("tk", 1);
        
        return "redirect:/dienthoai/listsp";
    }

}
