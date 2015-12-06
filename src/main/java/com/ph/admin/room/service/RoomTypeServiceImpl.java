package com.ph.admin.room.service;

import com.ph.admin.room.dao.RoomTypeDao;
import com.ph.admin.room.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pradeesh on 12/6/2015.
 */
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired(required = true)
    private RoomTypeDao roomTypeDao;

    public int insertRoomType(final RoomType roomType) {
        return roomTypeDao.insertRoomType(roomType);
    }
}
