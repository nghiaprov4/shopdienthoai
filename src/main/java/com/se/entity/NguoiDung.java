package com.se.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class NguoiDung extends User {


		private int maKh;

	   
	    private String ho;
	   
	    private String ten;
	    private String sdt;
	    private String email;

	   
	    private String tenTaiKhoan;

	    
	    private String matKhau;

	   
	    private Boolean tinhTrang;

	   
	    private String diaChiNha;
	   
	    private String phuong;
	  
	    private String quan;

	    
	    private String thanhPho;
	    
	   
	    private VaiTro vaiTro;
	    
	    public NguoiDung(String tenTaiKhhoan, String matKhau, Collection<? extends GrantedAuthority> authorities) {
				super(tenTaiKhhoan, matKhau, authorities);
				// TODO Auto-generated constructor stub
			}

		public NguoiDung(String username, String password, Collection<? extends GrantedAuthority> authorities, int maKh,
				String ho, String ten, String sdt, String email, String tenTaiKhoan, String matKhau, Boolean tinhTrang,
				String diaChiNha, String phuong, String quan, String thanhPho, VaiTro vaiTro) {
			super(username, password, authorities);
			this.maKh = maKh;
			this.ho = ho;
			this.ten = ten;
			this.sdt = sdt;
			this.email = email;
			this.tenTaiKhoan = tenTaiKhoan;
			this.matKhau = matKhau;
			this.tinhTrang = tinhTrang;
			this.diaChiNha = diaChiNha;
			this.phuong = phuong;
			this.quan = quan;
			this.thanhPho = thanhPho;
			this.vaiTro = vaiTro;
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
