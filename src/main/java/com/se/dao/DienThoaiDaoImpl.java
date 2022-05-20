/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.entity.DienThoai;
import com.se.entity.DienThoaiDTO;



/**
 *
 * @author nghiathieu
 */
@Repository
public class DienThoaiDaoImpl implements DienThoaiDao {

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void saveDienThoai(DienThoai dienThoai, InputStream inputStream) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	        try {
	            if (inputStream != null) {
	                byte[] bytes = IOUtils.toByteArray(inputStream);
	                Blob blob = Hibernate.getLobCreator(session).createBlob(bytes);
	                dienThoai.setHinhAnh(blob);
	                session.saveOrUpdate(dienThoai);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public DienThoaiDTO getDienThoaiDTO(int id) {
		// TODO Auto-generated method stub
		   Session session = sessionFactory.getCurrentSession();
	        DienThoai dienThoai = null;
	        DienThoaiDTO dienThoaiDTO = new DienThoaiDTO();
	        try {
	            dienThoai = session.get(DienThoai.class, id);
	            dienThoaiDTO.setId(dienThoai.getId());
	            dienThoaiDTO.setDongMay(dienThoai.getDongMay());
	            dienThoaiDTO.setModel(dienThoai.getModel());
	            dienThoaiDTO.setMauSac(dienThoai.getMauSac());
	            dienThoaiDTO.setNhaSanXuat(dienThoai.getNhaSanXuat());
	            dienThoaiDTO.setLoaiDienThoai(dienThoai.getLoaiDienThoai());
	            dienThoaiDTO.setMoTa(dienThoai.getMoTa());
	            dienThoaiDTO.setGiaNhap(dienThoai.getGiaNhap());
	            dienThoaiDTO.setGiaBan(dienThoai.getGiaBan());
	            dienThoaiDTO.setSoLuongTon(dienThoai.getSoLuongTon());
	            dienThoaiDTO.setDoPhanGiai(dienThoai.getDoPhanGiai());
	            dienThoaiDTO.setXuatXu(dienThoai.getXuatXu());
	            dienThoaiDTO.setDungLuongPin(dienThoai.getDungLuongPin());
	            dienThoaiDTO.setBoNhoTrong(dienThoai.getBoNhoTrong());
	            dienThoaiDTO.setRam(dienThoai.getRam());
	            dienThoaiDTO.setChipXuLy(dienThoai.getChipXuLy());
	            dienThoaiDTO.setCamara(dienThoai.getCamara());
	            Blob blob = dienThoai.getHinhAnh();
	            if (blob != null) {
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;

	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                dienThoaiDTO.setBase64Image(base64Image);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dienThoaiDTO;	}

	@Override
	public List<DienThoai> getListDienThoai() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	        Query<DienThoai> q = session.createQuery("from DienThoai", DienThoai.class);
	        List<DienThoai> listDienThoai = q.getResultList();
	        return listDienThoai;
	}

	@Override
	public DienThoai getDienThoai(int id) {
		// TODO Auto-generated method stub
		   Session session = sessionFactory.getCurrentSession();
	        DienThoai dienThoai = session.get(DienThoai.class, id);
	        return dienThoai;	}

	@Override
	public void deleteDienThoai(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	        DienThoai dienThoai = session.get(DienThoai.class, id);
	        session.delete(dienThoai);
	}

	@Override
	public List<DienThoai> getListDienThoaiTheoLoai(String tenLoai) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	        Query<DienThoai> q = session.createQuery("SELECT m FROM DienThoai as m, LoaiDienThoai as l where"
	                + " l.maLoai = m.loaiDienThoai and l.tenLoai = :param", DienThoai.class);

	        q.setParameter("param", tenLoai);
	        List<DienThoai> listDienThoai = q.getResultList();
	        return listDienThoai;	}

	@Override
	public List<DienThoai> getListDienThoaiTheoNsx(String tenNsx) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        Query<DienThoai> q = session.createQuery("SELECT m FROM DienThoai as m, NhaSanXuat as n where"
                + " m.nhaSanXuat=n.maNsx and n.tenNsx = :param", DienThoai.class);

        q.setParameter("param", tenNsx);
        List<DienThoai> listDienThoai = q.getResultList();
        return listDienThoai;	}

	@Override
	public void capnhatsoluong(DienThoai dienThoai) {
		// TODO Auto-generated method stub
		  Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(dienThoai);
	}

}
