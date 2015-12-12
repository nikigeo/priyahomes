package com.ph.admin.room.dao;

import com.ph.admin.room.model.RoomType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pradeesh on 12/6/2015.
 */
@Service
public class RoomTypeDaoImpl implements RoomTypeDao{

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int insertRoomType(final RoomType roomType) {
        Integer roomTypeId = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        roomTypeId = (Integer)session.save(roomType);
        session.getTransaction().commit();
        return roomTypeId;
    }

    public List<RoomType> getAllRoomTypes() {
        Session session = getSessionFactory().openSession();
        return  session.createQuery("from RoomType").list();
    }
}
