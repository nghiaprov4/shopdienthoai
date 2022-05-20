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

import org.hibernate.annotations.Nationalized;


/**
*
* @author nghiathieu
*/

@Entity
@Table
public class LoaiDienThoai {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "maloai")
	    private int maLoai;

	    @Nationalized
	    @Column(name = "tenloai")
	    private String tenLoai;
	    
	    @OneToMany(mappedBy = "loaiDienThoai",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private List<DienThoai> listDienThoai;
	    
	    public LoaiDienThoai() {
			// TODO Auto-generated constructor stub
		}

		public LoaiDienThoai(int maLoai, String tenLoai, List<DienThoai> listDienThoai) {
			super();
			this.maLoai = maLoai;
			this.tenLoai = tenLoai;
			this.listDienThoai = listDienThoai;
		}

		public LoaiDienThoai(int maLoai, String tenLoai) {
			super();
			this.maLoai = maLoai;
			this.tenLoai = tenLoai;
		}

		public int getMaLoai() {
			return maLoai;
		}

		public void setMaLoai(int maLoai) {
			this.maLoai = maLoai;
		}

		public String getTenLoai() {
			return tenLoai;
		}

		public void setTenLoai(String tenLoai) {
			this.tenLoai = tenLoai;
		}

		public List<DienThoai> getListDienThoai() {
			return listDienThoai;
		}

		public void setListDienThoai(List<DienThoai> listDienThoai) {
			this.listDienThoai = listDienThoai;
		}
	    
	    
}
