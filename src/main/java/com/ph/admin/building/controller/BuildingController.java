package com.ph.admin.building.controller;

import com.ph.admin.building.facade.BuildingApiFacade;
import com.ph.admin.building.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import java.util.List;

@Controller
@RequestMapping("v1/ph/buildings")
public class BuildingController {

    @Autowired(required = true)
    private BuildingApiFacade buildingApiFacade;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json" })
    @ResponseBody
    public int insertBuilding(@RequestBody Building building)
    {
        int buildingId = buildingApiFacade.insertBuilding(building);
        return buildingId;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Building> getAllBuildings(){
       return buildingApiFacade.getAllBuildings();
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Building> getAllVerificationTypes()
    {
        return buildingApiFacade.getAllBuldings();
    }
}
