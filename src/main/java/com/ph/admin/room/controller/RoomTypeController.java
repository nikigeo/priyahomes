package com.ph.admin.room.controller;

import com.ph.admin.room.facade.RoomTypeApiFacade;
import com.ph.admin.room.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Pradeesh on 12/5/2015.
 */

@Controller
@RequestMapping("v1/ph/roomtype")
public class RoomTypeController {

    @Autowired(required = true)
    private RoomTypeApiFacade roomTypeApiFacade;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json" })
    @ResponseBody
    public int insertRoomType(@RequestBody RoomType roomType) {
        return roomTypeApiFacade.insertRoomType(roomType);
    }

}
