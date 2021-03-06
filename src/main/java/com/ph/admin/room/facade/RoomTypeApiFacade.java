package com.ph.admin.room.facade;

import com.ph.admin.room.model.RoomType;

import java.util.List;

/**
 * Created by Pradeesh on 12/5/2015.
 */
public interface RoomTypeApiFacade {
    int insertRoomType(final RoomType roomType);
    List<RoomType> getAllRoomTypes();
}
