/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import com.se.dao.ChiTietHoaDonDao;
import com.se.entity.ChiTietHoaDon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghiathieu
 */
@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService{
    
    @Autowired
    private ChiTietHoaDonDao chiTietHoaDonDao;
    
    @Override
    @Transactional
    public void saveChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        chiTietHoaDonDao.saveChiTietHoaDon(chiTietHoaDon);
    }

    @Override
    @Transactional
    public List<ChiTietHoaDon> getChiTietTheoMaHd(int i) {
        return chiTietHoaDonDao.getChiTietTheoMaHd(i);
    }

	@Override
    @Transactional
	public List<ChiTietHoaDon> getDienThoaiTheoMaSp(int i) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.getDienThoaiTheoMaSp(i);
	}
    
}
