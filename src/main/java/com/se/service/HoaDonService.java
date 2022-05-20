/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import com.se.entity.HoaDon;
import java.util.List;

/**
 *
 * @author nghiathieu
 */
public interface HoaDonService {

    public void saveHoaDon(HoaDon hoaDon);

    public List<HoaDon> showDsHD();

}
