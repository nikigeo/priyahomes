package com.ph.admin.room.service;

import com.ph.admin.room.model.RoomType;

import java.util.List;

/**
 * Created by pradeesh on 12/5/2015.
 */
public interface RoomTypeService {
    int insertRoomType(final RoomType roomType);
    List<RoomType> getAllRoomTypes();
}
