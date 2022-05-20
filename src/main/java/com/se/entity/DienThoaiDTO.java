package com.se.entity;
/**
*
* @author nghiathieu
*/
public class DienThoaiDTO {
		private int id;
	    private String dongMay;
	    private String model;
	    private String mauSac;
	    private NhaSanXuat nhaSanXuat;
	    private LoaiDienThoai loaiDienThoai;
	    private String doPhanGiai;
	    private String moTa;
	    private double giaNhap;
	    private double giaBan;
	    private int soLuongTon;
	    private String base64Image;
	    private String xuatXu;
	    private String dungLuongPin;
	    private String boNhoTrong;
	    private String ram;
	    private String chipXuLy;
	    private String camara;
	     
	     
	     public DienThoaiDTO() {
			// TODO Auto-generated constructor stub
		}

	
		public DienThoaiDTO(int id, String dongMay, String model, String mauSac, NhaSanXuat nhaSanXuat,
				LoaiDienThoai loaiDienThoai, String doPhanGiai, String moTa, double giaNhap, double giaBan,
				int soLuongTon, String base64Image, String xuatXu, String dungLuongPin, String boNhoTrong, String ram,
				String chipXuLy, String camara) {
			this.id = id;
			this.dongMay = dongMay;
			this.model = model;
			this.mauSac = mauSac;
			this.nhaSanXuat = nhaSanXuat;
			this.loaiDienThoai = loaiDienThoai;
			this.doPhanGiai = doPhanGiai;
			this.moTa = moTa;
			this.giaNhap = giaNhap;
			this.giaBan = giaBan;
			this.soLuongTon = soLuongTon;
			this.base64Image = base64Image;
			this.xuatXu = xuatXu;
			this.dungLuongPin = dungLuongPin;
			this.boNhoTrong = boNhoTrong;
			this.ram = ram;
			this.chipXuLy = chipXuLy;
			this.camara = camara;
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

		public String getGiaBan() {
			String gia  = String.format("%.0f", giaBan);
					//Double.toString(giaBan);
			return gia;
		}

		public void setGiaBan(double giaBan) {
			this.giaBan = giaBan;
		}

//		public double getGiaBan() {
//			return giaBan;
//		}

		public int getSoLuongTon() {
			return soLuongTon;
		}

		public void setSoLuongTon(int soLuongTon) {
			this.soLuongTon = soLuongTon;
		}

		public String getBase64Image() {
			return base64Image;
		}

		public void setBase64Image(String base64Image) {
			this.base64Image = base64Image;
		}

		public String getXuatXu() {
			return xuatXu;
		}

		public void setXuatXu(String xuatXu) {
			this.xuatXu = xuatXu;
		}
	     

}
