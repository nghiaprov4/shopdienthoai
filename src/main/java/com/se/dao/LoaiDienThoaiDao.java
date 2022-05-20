
package com.se.dao;

import java.util.List;

import com.se.entity.LoaiDienThoai;

/**
 *
 * @author nghiathieu
 */
public interface LoaiDienThoaiDao {
    void saveLoaiDienThoai(LoaiDienThoai loaiDienThoai);
    public List<LoaiDienThoai> getDanhSachDienThoai();
    public LoaiDienThoai getLoaiDienThoai(int maLoai);
}
