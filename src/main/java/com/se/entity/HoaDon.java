package com.se.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
*
* @author nghiathieu
*/
@Entity
@Table
public class HoaDon implements Serializable {


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ma_hd")
	    private int maHd;
	    
	    @ManyToOne
	    @JoinColumn(name = "ma_kh")
	    private KhachHang maKh;
	    
	    @Column(name = "ngay_laphd")
	    private LocalDate ngayLapHd;
	    
	    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
	    List<ChiTietHoaDon> listChiTietHoaDon;
	    
	    public HoaDon() {
			// TODO Auto-generated constructor stub
		}

		public int getMaHd() {
			return maHd;
		}

		public void setMaHd(int maHd) {
			this.maHd = maHd;
		}

		public KhachHang getMaKh() {
			return maKh;
		}

		public void setMaKh(KhachHang maKh) {
			this.maKh = maKh;
		}

		public LocalDate getNgayLapHd() {
			return ngayLapHd;
		}

		public void setNgayLapHd(LocalDate ngayLapHd) {
			this.ngayLapHd = ngayLapHd;
		}

		public List<ChiTietHoaDon> getListChiTietHoaDon() {
			return listChiTietHoaDon;
		}

		public void setListChiTietHoaDon(List<ChiTietHoaDon> listChiTietHoaDon) {
			this.listChiTietHoaDon = listChiTietHoaDon;
		}
	    
}
