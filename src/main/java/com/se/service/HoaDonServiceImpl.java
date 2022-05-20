/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import com.se.dao.HoaDonDao;
import com.se.entity.HoaDon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghiathieu
 */
@Service
public class HoaDonServiceImpl implements HoaDonService{
    
    @Autowired
    private HoaDonDao hoaDonDao;
    
    @Override
    @Transactional
    public void saveHoaDon(HoaDon hoaDon) {
        hoaDonDao.saveHoaDon(hoaDon);
    }

    @Override
    @Transactional
    public List<HoaDon> showDsHD() {
        return hoaDonDao.showDsHD();
    }
    
}
