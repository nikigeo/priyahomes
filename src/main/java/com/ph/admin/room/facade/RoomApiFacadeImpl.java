package com.ph.admin.room.facade;

import com.ph.admin.room.model.Room;
import com.ph.admin.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pradeesh on 12/6/2015.
 */

@Service
public class RoomApiFacadeImpl implements RoomApiFacade{

    @Autowired(required = true)
    private RoomService roomService;

    public int insertRoom(final Room room) {
        return roomService.insertRoom(room);
    }
}
