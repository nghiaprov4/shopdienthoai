/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;

import com.se.entity.NhaSanXuat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tus
 */
@Repository
public class NhaSanXuatDaoImpl implements NhaSanXuatDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public NhaSanXuat getNhaSanXuat(int maNhaSx) {
        Session session = sessionFactory.getCurrentSession();
        NhaSanXuat nhaSanXuat = session.get(NhaSanXuat.class, maNhaSx);
        return nhaSanXuat;
    }

    @Override
    public void saveNhaSanXuat(NhaSanXuat nhaSanXuat) {
        Session session = sessionFactory.getCurrentSession();
        String tenNhaSx = nhaSanXuat.getTenNsx();
        Query q = session.createQuery("select n from NhaSanXuat n where n.tenNsx = :param", NhaSanXuat.class);
        q.setParameter("param", tenNhaSx);
        try {
            NhaSanXuat n = (NhaSanXuat) q.getSingleResult();
            if (n == null) {
                session.saveOrUpdate(nhaSanXuat);
            }
        } catch (Exception e) {
            session.saveOrUpdate(nhaSanXuat);
        }

    }

    @Override
    public List<NhaSanXuat> getDsNhaSanXuat() {
        Session session = sessionFactory.getCurrentSession();
        Query<NhaSanXuat> q = session.createQuery("from NhaSanXuat", NhaSanXuat.class);
        List<NhaSanXuat> listNhaSx = q.getResultList();
        return listNhaSx;
    }

}
