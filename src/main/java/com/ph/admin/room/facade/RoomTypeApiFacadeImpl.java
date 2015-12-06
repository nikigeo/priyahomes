package com.ph.admin.room.facade;

import com.ph.admin.room.model.RoomType;
import com.ph.admin.room.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pradeesh on 12/6/2015.
 */
@Service
public class RoomTypeApiFacadeImpl implements RoomTypeApiFacade{

    @Autowired(required = true)
    private RoomTypeService roomTypeService;

    public int insertRoomType(final RoomType roomType) {
        return roomTypeService.insertRoomType(roomType);
    }
}
