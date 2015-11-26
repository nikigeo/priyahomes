/*
 * Copyright (c) Priya homes.
 */

package com.ph.building.controller;

import com.ph.building.facade.BuildingiDetailsApiFacade;
import com.ph.building.model.BuildingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("v1/ph/buildings")
public class BuildingDetailsController {

    @Autowired(required = true)
    private BuildingiDetailsApiFacade buildingiDetailsApiFacade;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json" })
    @ResponseBody
    public ModelAndView createBuildingDetails(@RequestBody BuildingDetails buildingDetails)
    {
        buildingiDetailsApiFacade.insertBuildingDetails(buildingDetails);
        ModelAndView model = new ModelAndView();
        model.setViewName("homepage");
        return model;
    }
}
