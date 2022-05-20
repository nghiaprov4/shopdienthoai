package com.se.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nghiathieu
 */
@Entity
@Table
public class NhaSanXuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nsx")
    private int maNsx;
    
    @Column(name = "ten_nsx")
    private String tenNsx;
    
    @OneToMany(mappedBy = "nhaSanXuat",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<DienThoai> listDienThoai;

    public NhaSanXuat() {
    }

    public NhaSanXuat(int maNsx, String tenNsx) {
        this.maNsx = maNsx;
        this.tenNsx = tenNsx;
    }

    public int getMaNsx() {
        return maNsx;
    }

    public void setMaNsx(int maNsx) {
        this.maNsx = maNsx;
    }

    public String getTenNsx() {
        return tenNsx;
    }

    public void setTenNsx(String tenNsx) {
        this.tenNsx = tenNsx;
    }

    public List<DienThoai> getListDienThoai() {
        return listDienThoai;
    }

    public void setListDienThoai(List<DienThoai> listDienThoai) {
        this.listDienThoai = listDienThoai;
    }

 
        
}