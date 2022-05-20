/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import com.se.entity.KhachHang;
import java.util.List;

/**
 *
 * @author nghiathieu
 */
public interface KhachHangService {

    public void saveKhachHang(KhachHang khachHang);

    public KhachHang findKhbyTk_Mk(String tentk, String matkhau);

    public KhachHang loadkh_tentk(String taikhoan);

    public List<KhachHang> danhSachKh();

    public void xoaKhachHang(int maKh);
    
    public KhachHang getKhachHang(int makh);
}
