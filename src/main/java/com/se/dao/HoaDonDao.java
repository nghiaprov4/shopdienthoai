/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;

import com.se.entity.HoaDon;
import java.util.List;

/**
 *
 * @author nghiathieu
 */
public interface HoaDonDao {
    public void saveHoaDon(HoaDon hoaDon);
    public List<HoaDon> showDsHD();
}
