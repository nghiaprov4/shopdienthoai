/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;

import com.se.entity.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author nghhiathieu
 */
public interface ChiTietHoaDonDao {
    public void saveChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
    public List<ChiTietHoaDon> getChiTietTheoMaHd(int maHd);
    public List<ChiTietHoaDon> getDienThoaiTheoMaSp(int masp);
}
