package com.ph.admin.room.dao;

import com.ph.admin.room.model.Room;

import java.util.List;

/**
 * Created by Pradeesh on 12/6/2015.
 */
public interface RoomDao {
    int insertRoom(final Room room);
    List<Room> getAllAvailableRooms();
}
