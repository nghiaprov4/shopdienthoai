/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;


import java.io.InputStream;
import java.util.List;

import com.se.entity.DienThoai;
import com.se.entity.DienThoaiDTO;

/**
 *
 * @author nghiathieu
 */
public interface DienThoaiService {

    void saveDienThoai(DienThoai dienThoai, InputStream inputStream);

    public DienThoaiDTO getDienThoaiDTO(int id);

    public List<DienThoai> getListDienThoai();

    public DienThoai getDienThoai(int id);

    public void deleteDienThoai(int id);

    public List<DienThoai> getListDienThoaiTheoLoai(String tenLoai);

    public List<DienThoai> getListDienThoaiTheoNsx(String tenNsx);

    void capnhatsoluong(DienThoai dienThoai);

}
