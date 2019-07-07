package com.ph.admin.room.facade;

import com.ph.admin.room.model.Room;

import java.util.List;

/**
 * Created by Pradeesh on 12/6/2015.
 */
public interface RoomApiFacade {
    int insertRoom(final Room room);
    List<Room> getAllAvailableRooms(final String fromDate,final String toDate);
}
