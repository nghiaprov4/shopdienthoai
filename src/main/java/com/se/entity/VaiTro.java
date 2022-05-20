package com.se.entity;

import java.io.Serializable;
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
public class VaiTro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vaitro")
    private int maVaitro;
    
    @Column(name = "tenvaitro")
    private String tenVaitro;

    @OneToMany(mappedBy = "vaiTro",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<KhachHang> dsKh;
    
    public VaiTro() {
		// TODO Auto-generated constructor stub
	}

	public int getMaVaitro() {
		return maVaitro;
	}

	public void setMaVaitro(int maVaitro) {
		this.maVaitro = maVaitro;
	}

	public String getTenVaitro() {
		return tenVaitro;
	}

	public void setTenVaitro(String tenVaitro) {
		this.tenVaitro = tenVaitro;
	}

	public List<KhachHang> getDsKh() {
		return dsKh;
	}

	public void setDsKh(List<KhachHang> dsKh) {
		this.dsKh = dsKh;
	}
    
}
