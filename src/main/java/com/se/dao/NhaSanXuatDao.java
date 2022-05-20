/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;

import com.se.entity.NhaSanXuat;
import java.util.List;

/**
 *
 * @author nghiathieu
 */
public interface NhaSanXuatDao {
    public NhaSanXuat getNhaSanXuat(int maNhaSx);
    public void saveNhaSanXuat(NhaSanXuat nhaSanXuat);
    public List<NhaSanXuat> getDsNhaSanXuat();
}
