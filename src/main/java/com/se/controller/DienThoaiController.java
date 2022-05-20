/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.controller;


import com.se.entity.DienThoai;
import com.se.entity.DienThoaiDTO;
import com.se.entity.LoaiDienThoai;
import com.se.entity.NhaSanXuat;
import com.se.service.DienThoaiService;
import com.se.service.LoaiDienThoaiService;
import com.se.service.NhaSanXuatService;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nghiathieu
 */
@Controller
@RequestMapping("/dienthoai")
public class DienThoaiController {

    @Autowired
    private DienThoaiService dienThoaiService;

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private LoaiDienThoaiService loaiDienThoaiService;

    @GetMapping("/showFormThem")
    public String showFormThem(Model model) {
        DienThoai dienThoai = new DienThoai();
        List<LoaiDienThoai> listLoaiDienThoai = loaiDienThoaiService.getDanhSachLoaiDienThoai();
        List<NhaSanXuat> listNsx = nhaSanXuatService.getDsNhaSanXuat();
        model.addAttribute("dienthoai", dienThoai);
        model.addAttribute("listLoaiDienThoai", listLoaiDienThoai);
        model.addAttribute("listNsx", listNsx);
        return "form-sp-dienthoai-them";

    }

    @PostMapping("/themsp")
    public String themSanPham(@ModelAttribute("dienthoai") DienThoai dienThoai,
            @RequestParam("file") MultipartFile multipartFile,
            @RequestParam("ldt") String ml,
            @RequestParam("nsx") String mNSX) {

        try {

            int maLoai = Integer.parseInt(ml);
            int maNsx = Integer.parseInt(mNSX);
            LoaiDienThoai loaiDienThoai = loaiDienThoaiService.getLoaiDienThoai(maLoai);
            NhaSanXuat nhaSanXuat = nhaSanXuatService.getNhaSanXuat(maNsx);

            InputStream inputStream = multipartFile.getInputStream();
            dienThoai.setNhaSanXuat(nhaSanXuat);
            dienThoai.setLoaiDienThoai(loaiDienThoai);
            dienThoaiService.saveDienThoai(dienThoai, inputStream);

        } catch (Exception e) {
        }
        return "redirect:/dienthoai/listsp";
    }

    @GetMapping("/listsp")
    public String getListSp(Model model, @RequestParam(value = "page", required = false) String trang,
            @RequestParam(value = "loaimay", required = false) String loaimay,
            @RequestParam(value = "tennsx", required = false) String tennsx) {

        List<DienThoaiDTO> listDienThoaiDto = new ArrayList<>();
        List<DienThoaiDTO> listDienThoaiDTOAndPage = new ArrayList<>();
        List<DienThoai> listDienThoai = null;
        List<NhaSanXuat> listNsx = nhaSanXuatService.getDsNhaSanXuat();
        List<LoaiDienThoai> listLoai = loaiDienThoaiService.getDanhSachLoaiDienThoai();

        if (loaimay != null) {
            listDienThoai = dienThoaiService.getListDienThoaiTheoLoai(loaimay);
        } else if (tennsx!=null) {
            listDienThoai =dienThoaiService.getListDienThoaiTheoNsx(tennsx);
        } else {
        	listDienThoai = dienThoaiService.getListDienThoai();
        }
        DienThoaiDTO dienThoaiDTO = null;
        int page = 1;

        if (trang != null) {
            try {
                page = Integer.parseInt(trang);
            } catch (Exception e) {
            }
//            if (page > 3) {
//                page = 1;
//            }
        }

        int start = page * 9 - 9;
        for (DienThoai dienThoai : listDienThoai) {
        	dienThoaiDTO = dienThoaiService.getDienThoaiDTO(dienThoai.getId());
        	listDienThoaiDto.add(dienThoaiDTO);

            System.out.println(listDienThoaiDto.size());
        }
        for (int i = start; i < start + 9; i++) {
            try {
                listDienThoaiDTOAndPage.add(listDienThoaiDto.get(i));

            } catch (Exception e) {
                break;
            }
        }
        
        int sotrang = listDienThoai.size()/9+1;
        
        List<DienThoaiDTO> list_followpage = listDienThoaiDTOAndPage;
        model.addAttribute("listDienThoaiDto", list_followpage);
        model.addAttribute("sotrang",sotrang);
        model.addAttribute("listNsx", listNsx);
        model.addAttribute("listLoai", listLoai);
        return "list-sp";
    }

    @GetMapping("/chitietsp")
    public String showChiTietSp(@RequestParam("masp") String masp, Model model,  @RequestParam(value = "loaimay", required = false) String loaimay,
            @RequestParam(value = "tennsx", required = false) String tennsx,  @RequestParam(value = "page", required = false) String trang) {
    	
    	 List<DienThoaiDTO> listDienThoaiDto = new ArrayList<>();
         List<DienThoaiDTO> listDienThoaiDTOAndPage = new ArrayList<>();
         List<DienThoai> listDienThoai = null;
         List<NhaSanXuat> listNsx = nhaSanXuatService.getDsNhaSanXuat();
         List<LoaiDienThoai> listLoai = loaiDienThoaiService.getDanhSachLoaiDienThoai();

         if (loaimay != null) {
             listDienThoai = dienThoaiService.getListDienThoaiTheoLoai(loaimay);
         } else if (tennsx!=null) {
             listDienThoai =dienThoaiService.getListDienThoaiTheoNsx(tennsx);
         } else {
         	listDienThoai = dienThoaiService.getListDienThoai();
         }
         DienThoaiDTO dienThoaiDTO = null;
         int page = 1;

         if (trang != null) {
             try {
                 page = Integer.parseInt(trang);
             } catch (Exception e) {
             }
             if (page > 3) {
                 page = 1;
             }
         }

         int start = page * 9 - 9;
         for (DienThoai dienThoai : listDienThoai) {
         	dienThoaiDTO = dienThoaiService.getDienThoaiDTO(dienThoai.getId());
         	listDienThoaiDto.add(dienThoaiDTO);

             System.out.println(listDienThoaiDto.size());
         }
         for (int i = start; i < start + 9; i++) {
             try {
                 listDienThoaiDTOAndPage.add(listDienThoaiDto.get(i));

             } catch (Exception e) {
                 break;
             }
         }
         
         int sotrang = listDienThoai.size()/9+1;
         
         List<DienThoaiDTO> list_followpage = listDienThoaiDTOAndPage;
         model.addAttribute("listDienThoaiDto", list_followpage);
         model.addAttribute("sotrang",sotrang);
         model.addAttribute("listNsx", listNsx);
         model.addAttribute("listLoai", listLoai);
    	
    	
    	
        int maDienThoai = Integer.parseInt(masp);
        DienThoaiDTO dienDto = dienThoaiService.getDienThoaiDTO(maDienThoai);
        BigDecimal giaBan = new BigDecimal(dienDto.getGiaBan());
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        model.addAttribute("giaBan", currencyFormatter.format(giaBan));
        model.addAttribute("dienthoai", dienDto);
        return "chitietsp-sp";

    }

    @GetMapping("/showFormCapNhat")
    public String showFormCapNhat(@RequestParam("masp") String masp, Model model) {
        int maSp = Integer.parseInt(masp);
        List<LoaiDienThoai> listLoaiDienThoai = loaiDienThoaiService.getDanhSachLoaiDienThoai();
        List<NhaSanXuat> listNsx = nhaSanXuatService.getDsNhaSanXuat();
        DienThoai dienThoai = dienThoaiService.getDienThoai(maSp);
        System.out.println(dienThoai);
        model.addAttribute("listLoaiDienThoai", listLoaiDienThoai);
        model.addAttribute("listNsx", listNsx);
        model.addAttribute("dienthoai", dienThoai);
        return "form-sp-dienthoai-capnhat";
    }

    @PostMapping("/capnhatsp")
    public String capnhatSp(@ModelAttribute("dienthoai") DienThoai dienThoai,
            @RequestParam("file") MultipartFile multipartFile,
            @RequestParam("ldt") String ml,
            @RequestParam("nsx") String mNSX
         
       
            

    		) {
        try {
            int maLoai = Integer.parseInt(ml);
            int maNsx = Integer.parseInt(mNSX);

            LoaiDienThoai loaiDienThoai = loaiDienThoaiService.getLoaiDienThoai(maLoai);
            NhaSanXuat nhaSanXuat = nhaSanXuatService.getNhaSanXuat(maNsx);

            InputStream inputStream = multipartFile.getInputStream();
            dienThoai.setNhaSanXuat(nhaSanXuat);
            dienThoai.setLoaiDienThoai(loaiDienThoai);
//            dienThoai.setMauSac(mausac);
//            dienThoai.setDoPhanGiai(doPhanGiai);
//            dienThoai.setXuatXu(xuatxu);
            dienThoaiService.saveDienThoai(dienThoai, inputStream);

        } catch (Exception e) {
        }
        return "redirect:/admin/chitietsp?masp=" + dienThoai.getId();
    }

    @GetMapping("/xoasp")
    public String xoaSp(@RequestParam("masp") String masp) {
        int ma_sp = Integer.parseInt(masp);
        dienThoaiService.deleteDienThoai(ma_sp);
        return "redirect:/admin/quanlisanpham";
    }

}
