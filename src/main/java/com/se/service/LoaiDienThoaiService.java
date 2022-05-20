/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import java.util.List;

import com.se.entity.LoaiDienThoai;

/**
 *
 * @author nghiathieu
 */
public interface LoaiDienThoaiService {

    void saveLoaiDienThoai(LoaiDienThoai loaiDienThoai);

    public List<LoaiDienThoai> getDanhSachLoaiDienThoai();

    public LoaiDienThoai getLoaiDienThoai(int maLoai);

}
