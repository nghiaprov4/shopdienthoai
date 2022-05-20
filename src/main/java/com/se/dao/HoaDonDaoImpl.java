/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;

import com.se.entity.HoaDon;
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
public class HoaDonDaoImpl implements HoaDonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveHoaDon(HoaDon hoaDon) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(hoaDon);
    }

    @Override
    public List<HoaDon> showDsHD() {
        Session session = sessionFactory.getCurrentSession();
        Query<HoaDon> q = session.createQuery("from HoaDon",HoaDon.class);
        List<HoaDon> listHd = q.getResultList();
        return listHd;
    }
}
