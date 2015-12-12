package com.ph.admin.room.controller;

import com.ph.admin.room.facade.RoomApiFacade;
import com.ph.admin.room.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Pradeesh on 12/6/2015.
 */

@Controller
@RequestMapping("v1/ph/room")
public class RoomController {

    @Autowired(required = true)
    private RoomApiFacade roomApiFacade;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json" })
    @ResponseBody
    public int insertRoom(@RequestBody Room room) {
        return roomApiFacade.insertRoom(room);
    }
}
