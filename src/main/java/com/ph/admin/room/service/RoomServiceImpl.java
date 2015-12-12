package com.ph.admin.room.service;

import com.ph.admin.room.dao.RoomDao;
import com.ph.admin.room.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pradeesh on 12/6/2015.
 */
@Service
public class RoomServiceImpl implements RoomService{

    @Autowired(required = true)
    private RoomDao roomDao;

    public int insertRoom(final Room room) {
        return roomDao.insertRoom(room);
    }
}
