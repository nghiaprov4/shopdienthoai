/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import com.se.dao.NhaSanXuatDao;
import com.se.entity.NhaSanXuat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghiathieu
 */
@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    private NhaSanXuatDao nhaSanXuatDao;

    @Override
    @Transactional
    public NhaSanXuat getNhaSanXuat(int maNhaSx) {
        return nhaSanXuatDao.getNhaSanXuat(maNhaSx);
    }

    @Override
    @Transactional
    public void saveNhaSanXuat(NhaSanXuat nhaSanXuat) {
        nhaSanXuatDao.saveNhaSanXuat(nhaSanXuat);
    }

    @Override
    @Transactional
    public List<NhaSanXuat> getDsNhaSanXuat() {
        return nhaSanXuatDao.getDsNhaSanXuat();
    }

}
