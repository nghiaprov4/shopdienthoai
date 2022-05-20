package com.se.entity;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

/**
*
* @author nghiathieu
*/

@Entity
@Table
public class DienThoai {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sp")
	private int id;
	
    @Column(name = "dongmay")
    private String dongMay;
    
    @Column(name = "model")
    private String model;

    @Nationalized
    @Column(name = "mausac")
    private String mauSac;
    
    @ManyToOne
    @JoinColumn(name = "ma_nsx")
    private NhaSanXuat nhaSanXuat;
    
    @ManyToOne
    @JoinColumn(name = "maloai_dienthoai")
    @Nationalized
    private LoaiDienThoai loaiDienThoai;
    
    @OneToMany(mappedBy = "dienThoai", cascade = CascadeType.ALL)
    List<ChiTietHoaDon> listChiTietHoaDon;
    
    @Column(name = "do_phan_giai")
    private String doPhanGiai;
    
    @Nationalized
    @Column(name = "mota")
    private String moTa;
    
    
    @Nationalized
    @Column(name = "dungluongpin")
    private String dungLuongPin;
    
    @Nationalized
    @Column(name = "bonhotrong")
    private String boNhoTrong;
    
    @Nationalized
    @Column(name = "ram")
    private String ram;
    
    @Nationalized
    @Column(name = "chipxuly")
    private String chipXuLy;
    
    @Nationalized
    @Column(name = "camara")
    private String camara;
    
    
    
    @Column(name = "gianhap")
    private double giaNhap;
    
    @Column(name = "giaban")
    private double giaBan;
    
    @Column(name = "soluongton")
    private int soLuongTon;
    
    
    @Nationalized
    @Column(name = "xuatxu")
    private String xuatXu;
    
    @Lob
    @Column(name = "hinhanh")
    private Blob hinhAnh;
    
    public DienThoai() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDongMay() {
		return dongMay;
	}

	public void setDongMay(String dongMay) {
		this.dongMay = dongMay;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public NhaSanXuat getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public LoaiDienThoai getLoaiDienThoai() {
		return loaiDienThoai;
	}

	public void setLoaiDienThoai(LoaiDienThoai loaiDienThoai) {
		this.loaiDienThoai = loaiDienThoai;
	}

	public List<ChiTietHoaDon> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}

	public void setListChiTietHoaDon(List<ChiTietHoaDon> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public String getDoPhanGiai() {
		return doPhanGiai;
	}

	public void setDoPhanGiai(String doPhanGiai) {
		this.doPhanGiai = doPhanGiai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public Blob getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(Blob hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getDungLuongPin() {
		return dungLuongPin;
	}

	public void setDungLuongPin(String dungLuongPin) {
		this.dungLuongPin = dungLuongPin;
	}

	public String getBoNhoTrong() {
		return boNhoTrong;
	}

	public void setBoNhoTrong(String boNhoTrong) {
		this.boNhoTrong = boNhoTrong;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getChipXuLy() {
		return chipXuLy;
	}

	public void setChipXuLy(String chipXuLy) {
		this.chipXuLy = chipXuLy;
	}

	public String getCamara() {
		return camara;
	}

	public void setCamara(String camara) {
		this.camara = camara;
	}

	@Override
	public String toString() {
		return "DienThoai [id=" + id + ", dongMay=" + dongMay + ", model=" + model + ", mauSac=" + mauSac
				+ ", nhaSanXuat=" + nhaSanXuat + ", loaiDienThoai=" + loaiDienThoai + ", doPhanGiai=" + doPhanGiai
				+ ", moTa=" + moTa + ", dungLuongPin=" + dungLuongPin + ", boNhoTrong=" + boNhoTrong + ", ram=" + ram
				+ ", chipXuLy=" + chipXuLy + ", camara=" + camara + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan
				+ ", soLuongTon=" + soLuongTon + ", xuatXu=" + xuatXu + ", hinhAnh=" + hinhAnh + "]";
	}


 
    
    
}
