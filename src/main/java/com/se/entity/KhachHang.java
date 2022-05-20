package com.se.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

/**
*
* @author nghiathieu
*/
@Entity
@Table
public class KhachHang {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ma_kh")
	    private int maKh;

	    @Nationalized
	    private String ho;
	    @Nationalized
	    private String ten;
	    private String sdt;
	    private String email;

	    @Column(name = "tentaikhoan")
	    private String tenTaiKhoan;

	    @Column(name = "matkhau")
	    private String matKhau;

	    @Column(name = "tinhtrang")
	    private Boolean tinhTrang;

	    @Nationalized
	    @Column(name = "diachinha")
	    private String diaChiNha;
	    @Nationalized
	    private String phuong;
	    @Nationalized
	    private String quan;

	    @Nationalized
	    @Column(name = "thanhpho")
	    private String thanhPho;
	    
	    @ManyToOne
	    @JoinColumn(name = "ma_vaitro")
	    private VaiTro vaiTro;

		public KhachHang() {
			
			// TODO Auto-generated constructor stub
		}

		public int getMaKh() {
			return maKh;
		}

		public void setMaKh(int maKh) {
			this.maKh = maKh;
		}

		public String getHo() {
			return ho;
		}

		public void setHo(String ho) {
			this.ho = ho;
		}

		public String getTen() {
			return ten;
		}

		public void setTen(String ten) {
			this.ten = ten;
		}

		public String getSdt() {
			return sdt;
		}

		public void setSdt(String sdt) {
			this.sdt = sdt;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTenTaiKhoan() {
			return tenTaiKhoan;
		}

		public void setTenTaiKhoan(String tenTaiKhoan) {
			this.tenTaiKhoan = tenTaiKhoan;
		}

		public String getMatKhau() {
			return matKhau;
		}

		public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
		}

		public Boolean getTinhTrang() {
			return tinhTrang;
		}

		public void setTinhTrang(Boolean tinhTrang) {
			this.tinhTrang = tinhTrang;
		}

		public String getDiaChiNha() {
			return diaChiNha;
		}

		public void setDiaChiNha(String diaChiNha) {
			this.diaChiNha = diaChiNha;
		}

		public String getPhuong() {
			return phuong;
		}

		public void setPhuong(String phuong) {
			this.phuong = phuong;
		}

		public String getQuan() {
			return quan;
		}

		public void setQuan(String quan) {
			this.quan = quan;
		}

		public String getThanhPho() {
			return thanhPho;
		}

		public void setThanhPho(String thanhPho) {
			this.thanhPho = thanhPho;
		}

		public VaiTro getVaiTro() {
			return vaiTro;
		}

		public void setVaiTro(VaiTro vaiTro) {
			this.vaiTro = vaiTro;
		}
		
	    
	    
}
