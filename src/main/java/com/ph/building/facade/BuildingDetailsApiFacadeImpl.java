package com.ph.building.facade;

import com.ph.building.model.BuildingDetails;
import com.ph.building.service.BuildingDetailsService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BuildingDetailsApiFacadeImpl implements BuildingiDetailsApiFacade {

    private BuildingDetailsService buildingDetailsService;

    public BuildingDetailsService getBuildingDetailsService() {
        return buildingDetailsService;
    }

    @Inject
    public void setBuildingDetailsService(BuildingDetailsService buildingDetailsService) {
        this.buildingDetailsService = buildingDetailsService;
    }

    public int insertBuildingDetails(BuildingDetails buildingDetails) {
        return buildingDetailsService.insertBuildingDetails(buildingDetails);
    }
}
