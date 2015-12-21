package com.ph.admin.room.dao;

import com.ph.admin.room.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pradeesh on 12/6/2015.
 */
@Service
public class RoomDaoImpl implements RoomDao{

    @Autowired(required = true)
    private SessionFactory sessionFactory;


    public int insertRoom(final Room room) {
        Integer roomId = null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        roomId = (Integer)session.save(room);
        session.getTransaction().commit();
        return roomId;
    }

    public List<Room> getAllAvailableRooms() {

        return sessionFactory.getCurrentSession().createQuery("from Room").list();
    }
}
