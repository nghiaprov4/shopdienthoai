/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;

import com.se.entity.ChiTietHoaDon;
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
public class ChiTietHoaDonImpl implements ChiTietHoaDonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(chiTietHoaDon);
    }

    @Override
    public List<ChiTietHoaDon> getChiTietTheoMaHd(int maHd) {
        Session session = sessionFactory.getCurrentSession();
        Query<ChiTietHoaDon> q = session.createQuery("select c from ChiTietHoaDon c where c.hoaDon.maHd = :param");
        q.setParameter("param", maHd);
        List<ChiTietHoaDon> listCt = q.getResultList();
        return listCt;
    }

	@Override
	public List<ChiTietHoaDon> getDienThoaiTheoMaSp(int masp) {
		// TODO Auto-generated method stub
	    Session session = sessionFactory.getCurrentSession();
        Query<ChiTietHoaDon> q = session.createQuery("select c from ChiTietHoaDon c where c.dienThoai.id = :param");
        q.setParameter("param",  masp);
        List<ChiTietHoaDon> listCtdt = q.getResultList();
        return listCtdt;	}

}
