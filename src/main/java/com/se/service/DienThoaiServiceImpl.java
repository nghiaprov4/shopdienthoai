/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import com.se.dao.DienThoaiDao;
import com.se.entity.DienThoai;
import com.se.entity.DienThoaiDTO;

import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghiathieu
 */
@Service
public class DienThoaiServiceImpl implements DienThoaiService{
    
    @Autowired
    private DienThoaiDao dienThoaiDao;

	@Override
    @Transactional
	public void saveDienThoai(DienThoai dienThoai, InputStream inputStream) {
		// TODO Auto-generated method stub
        dienThoaiDao.saveDienThoai(dienThoai, inputStream);

	}

	@Override
	@Transactional
	public DienThoaiDTO getDienThoaiDTO(int id) {
		// TODO Auto-generated method stub
        return dienThoaiDao.getDienThoaiDTO(id);
	}

	@Override
	@Transactional
	public List<DienThoai> getListDienThoai() {
		// TODO Auto-generated method stub
        return dienThoaiDao.getListDienThoai();
	}

	@Override
	@Transactional
	public DienThoai getDienThoai(int i) {
		// TODO Auto-generated method stub
        return dienThoaiDao.getDienThoai(i);
	}

	@Override
	@Transactional
	public void deleteDienThoai(int id) {
		// TODO Auto-generated method stub
        dienThoaiDao.deleteDienThoai(id);

	}

	@Override
	@Transactional
	public List<DienThoai> getListDienThoaiTheoLoai(String tenLoai) {
		// TODO Auto-generated method stub
        return dienThoaiDao.getListDienThoaiTheoLoai(tenLoai);
	}

	@Override
	@Transactional
	public List<DienThoai> getListDienThoaiTheoNsx(String tenNsx) {
		// TODO Auto-generated method stub
        return dienThoaiDao.getListDienThoaiTheoNsx(tenNsx);
	}

	@Override
	@Transactional
	public void capnhatsoluong(DienThoai dienThoai) {
		// TODO Auto-generated method stub
        dienThoaiDao.capnhatsoluong(dienThoai);

	}
    
    
    
}
