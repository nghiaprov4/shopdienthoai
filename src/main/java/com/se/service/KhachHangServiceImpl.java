/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import com.se.dao.KhachHangDao;
import com.se.entity.KhachHang;
import com.se.entity.NguoiDung;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghiathieu
 */
@Service
public class KhachHangServiceImpl implements KhachHangService,UserDetailsService{
    
    @Autowired
    private KhachHangDao khachHangDao;

    @Override
    @Transactional
    public void saveKhachHang(KhachHang khachHang) {
        khachHangDao.saveKhachHang(khachHang);
    }

    @Override
    @Transactional
    public KhachHang findKhbyTk_Mk(String tentk, String matkhau) {
        return khachHangDao.findKhbyTk_Mk(tentk, matkhau);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String tentk) throws UsernameNotFoundException {
        KhachHang khachHang = khachHangDao.loadUserByUsername(tentk);
        if (khachHang == null) {
            throw new UsernameNotFoundException("Not Found!");
        }

        List<SimpleGrantedAuthority> roleList = new ArrayList<>();

        roleList.add(new SimpleGrantedAuthority(khachHang.getVaiTro().getTenVaitro()));

        NguoiDung nguoiDung = new NguoiDung(khachHang.getTenTaiKhoan(), khachHang.getMatKhau(), roleList);
        nguoiDung.setMaKh(khachHang.getMaKh());
        nguoiDung.setHo(khachHang.getHo());
        nguoiDung.setTen(khachHang.getTen());
        nguoiDung.setSdt(khachHang.getSdt());
        nguoiDung.setEmail(khachHang.getEmail());
        nguoiDung.setDiaChiNha(khachHang.getDiaChiNha());
        nguoiDung.setPhuong(khachHang.getPhuong());
        nguoiDung.setQuan(khachHang.getQuan());
        nguoiDung.setThanhPho(khachHang.getThanhPho());
        nguoiDung.setTinhTrang(Boolean.TRUE);
        nguoiDung.setVaiTro(khachHang.getVaiTro());
        
       
        return nguoiDung;
    }

    @Override
    @Transactional
    public KhachHang loadkh_tentk(String string) {
        return khachHangDao.loadkh_tentk(string);
    }

    @Override
    @Transactional
    public List<KhachHang> danhSachKh() {
        return khachHangDao.danhSachKh();
    }

    @Override
    @Transactional
    public void xoaKhachHang(int maKh) {
        khachHangDao.xoaKhachHang(maKh);
    }

    @Override
    @Transactional
    public KhachHang getKhachHang(int i) {
        return khachHangDao.getKhachHang(i);
    }
    
}
