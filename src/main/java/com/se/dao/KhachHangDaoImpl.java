/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.dao;

import com.se.entity.KhachHang;
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
public class KhachHangDaoImpl implements KhachHangDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveKhachHang(KhachHang khachHang) {
        Session session = sessionFactory.getCurrentSession();
        String email = khachHang.getEmail();
        Query q = session.createQuery("select k from KhachHang k where k.email= :param", KhachHang.class);
        q.setParameter("param", email);
        try {
            KhachHang kh = (KhachHang) q.getSingleResult();
            if (kh == null) {
                session.saveOrUpdate(khachHang);
            }
        } catch (Exception e) {
            session.saveOrUpdate(khachHang);
        }

    }

    @Override
    public KhachHang findKhbyTk_Mk(String tentk, String matkhau) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select k from KhachHang k where k.tenTaiKhoan = '" + tentk + "'"
                + " and k.matKhau = '" + matkhau + "'";

        Query q = session.createQuery(sql);

        return (KhachHang) q.uniqueResult();

    }

    @Override
    public KhachHang loadUserByUsername(String tentk) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select k from KhachHang k where k.tenTaiKhoan = '" + tentk + "'";

        Query q = session.createQuery(sql);
        System.out.println((KhachHang) q.uniqueResult());
        return (KhachHang) q.uniqueResult();
    }

    @Override
    public KhachHang loadkh_tentk(String tentaikhoan) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select k from KhachHang k where k.tenTaiKhoan = '" + tentaikhoan + "'";

        Query q = session.createQuery(sql);
        System.out.println((KhachHang) q.uniqueResult());
        return (KhachHang) q.uniqueResult();
    }

    @Override
    public List<KhachHang> danhSachKh() {
        Session session = sessionFactory.getCurrentSession();
        Query<KhachHang> q = session.createQuery("from KhachHang k where not k.tenTaiKhoan = 'admin' ", KhachHang.class);
        List<KhachHang> listKh = q.getResultList();
        return listKh;
    }

    @Override
    public void xoaKhachHang(int maKh) {
        Session session = sessionFactory.getCurrentSession();
        KhachHang k = session.get(KhachHang.class, maKh);
        session.delete(k);
    }

    @Override
    public KhachHang getKhachHang(int i) {
        Session session = sessionFactory.getCurrentSession();
        KhachHang k = session.get(KhachHang.class, i);
        return k;
    }

}
