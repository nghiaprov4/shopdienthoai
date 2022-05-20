/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import com.se.dao.LoaiDienThoaiDao;
import com.se.entity.LoaiDienThoai;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghiathieu
 */
@Service
public class LoaiDienThoaiServiceImpl implements LoaiDienThoaiService{
    
    @Autowired
    private LoaiDienThoaiDao loaiDienThoaiDao;

	@Override
    @Transactional
	public void saveLoaiDienThoai(LoaiDienThoai loaiDienThoai) {
		// TODO Auto-generated method stub
        loaiDienThoaiDao.saveLoaiDienThoai(loaiDienThoai);

	}



	@Override
    @Transactional
	public LoaiDienThoai getLoaiDienThoai(int i) {
		// TODO Auto-generated method stub
        return loaiDienThoaiDao.getLoaiDienThoai(i);
	}

	@Override
	@Transactional   
	public List<LoaiDienThoai> getDanhSachLoaiDienThoai() {
		// TODO Auto-generated method stub
        return loaiDienThoaiDao.getDanhSachDienThoai();
	}
    
   
    
}
