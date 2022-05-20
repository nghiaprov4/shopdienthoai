package com.se.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author nghiathieu
*/

@Entity
@Table
public class ChiTietHoaDon implements Serializable {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ma_cthd")
	    private int id;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "ma_hd")
	    private HoaDon hoaDon;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "ma_sp")
	    private DienThoai dienThoai;

	    @Column(name = "soluong", nullable = false)
	    private int soLuong;
	    
	    public ChiTietHoaDon() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public HoaDon getHoaDon() {
			return hoaDon;
		}

		public void setHoaDon(HoaDon hoaDon) {
			this.hoaDon = hoaDon;
		}

		public DienThoai getDienThoai() {
			return dienThoai;
		}

		public void setDienThoai(DienThoai dienThoai) {
			this.dienThoai = dienThoai;
		}

		public int getSoLuong() {
			return soLuong;
		}

		public void setSoLuong(int soLuong) {
			this.soLuong = soLuong;
		}
		 @Override
		    public int hashCode() {
		        int hash = 7;
		        hash = 29 * hash + this.id;
		        hash = 29 * hash + Objects.hashCode(this.hoaDon);
		        hash = 29 * hash + Objects.hashCode(this.dienThoai);
		        hash = 29 * hash + this.soLuong;
		        return hash;
		    }

		    @Override
		    public boolean equals(Object obj) {
		        if (this == obj) {
		            return true;
		        }
		        if (obj == null) {
		            return false;
		        }
		        if (getClass() != obj.getClass()) {
		            return false;
		        }
		        final ChiTietHoaDon other = (ChiTietHoaDon) obj;
		        if (this.id != other.id) {
		            return false;
		        }
		        if (this.soLuong != other.soLuong) {
		            return false;
		        }
		        if (!Objects.equals(this.hoaDon, other.hoaDon)) {
		            return false;
		        }
		        if (!Objects.equals(this.dienThoai, other.dienThoai)) {
		            return false;
		        }
		        return true;
		    }
		    

}
