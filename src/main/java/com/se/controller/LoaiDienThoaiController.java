/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.controller;


import com.se.entity.LoaiDienThoai;
import com.se.service.LoaiDienThoaiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nghiathieu
 */
@Controller
@RequestMapping("/loaidienthoai")
public class LoaiDienThoaiController {
    
    @Autowired
    private LoaiDienThoaiService loaiDienThoaiService;
    
    @GetMapping("/showFormThem")
    public String showFormThem(Model model){
        LoaiDienThoai loaiDienThoai = new LoaiDienThoai();
        model.addAttribute("loaidienthoai", loaiDienThoai);
        return "form-sp-loaidienthoai-them";
        
    }
    
    @PostMapping("/themsp")
    public String themSanPham(@ModelAttribute("loaidienthoai") LoaiDienThoai loaiDienThoai){
        System.out.println(loaiDienThoai.getTenLoai());
        loaiDienThoaiService.saveLoaiDienThoai(loaiDienThoai);
        return "redirect:/dienthoai/showFormThem";
    }
    
    
    
}
