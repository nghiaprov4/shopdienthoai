/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;

import com.se.entity.KhachHang;
import com.se.entity.LoaiDienThoai;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nghiathieu
 */
@Repository
public class LoaiDienThoaiDaoImpl implements LoaiDienThoaiDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveLoaiDienThoai(LoaiDienThoai loaiDienThoai) {
    	 Session session = sessionFactory.getCurrentSession();
         String tenLoaiMay = loaiDienThoai.getTenLoai();
         Query q = session.createQuery("select l from LoaiDienThoai l where l.tenLoai = :param", LoaiDienThoai.class);
         q.setParameter("param", tenLoaiMay);
         try {
             LoaiDienThoai l = (LoaiDienThoai) q.getSingleResult();
             if (l == null) {
                 session.saveOrUpdate(loaiDienThoai);
             }
         } catch (Exception e) {
             session.saveOrUpdate(loaiDienThoai);
         }

    }

	@Override
	public LoaiDienThoai getLoaiDienThoai(int i) {
		// TODO Auto-generated method stub
	     Session session = sessionFactory.getCurrentSession();
	        LoaiDienThoai loaiDienThoai = session.get(LoaiDienThoai.class, i);
	        return loaiDienThoai;	}

	@Override
	public List<LoaiDienThoai> getDanhSachDienThoai() {
		// TODO Auto-generated method stub
		   Session session = sessionFactory.getCurrentSession();
	        Query<LoaiDienThoai> q = session.createQuery("from LoaiDienThoai", LoaiDienThoai.class);
	        List<LoaiDienThoai> listLoaiDienThoai = q.getResultList();
	        return listLoaiDienThoai;	}

}
