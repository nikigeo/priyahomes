package com.ph.admin.building.controller;

import com.ph.admin.building.facade.BuildingApiFacade;
import com.ph.admin.building.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("v1/ph/buildings")
public class BuildingController {

    @Autowired(required = true)
    private BuildingApiFacade buildingApiFacade;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json" })
    @ResponseBody
    public ModelAndView insertBuilding(@RequestBody Building building)
    {
        buildingApiFacade.insertBuilding(building);
        ModelAndView model = new ModelAndView();
        model.setViewName("homepage");
        return model;
    }
}
