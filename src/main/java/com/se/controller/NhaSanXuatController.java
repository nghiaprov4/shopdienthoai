/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.controller;

import com.se.entity.NhaSanXuat;
import com.se.service.NhaSanXuatService;
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
@RequestMapping("/nhasanxuat")
public class NhaSanXuatController {
    @Autowired
    private NhaSanXuatService nhaSanXuatService;
    
    @GetMapping("/showFormThem")
    public String showFormThem(Model model){
        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        model.addAttribute("nhasanxuat",nhaSanXuat);
        return "form-sp-nsx-them";
    }
    
    @PostMapping("/themsp")
    public String themSanPham(@ModelAttribute("nhasanxuat") NhaSanXuat nhaSanXuat){
        nhaSanXuatService.saveNhaSanXuat(nhaSanXuat);
        return "redirect:/dienthoai/showFormThem";
    }
}
