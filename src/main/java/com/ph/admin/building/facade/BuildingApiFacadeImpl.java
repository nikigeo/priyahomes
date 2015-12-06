package com.ph.admin.building.facade;

import com.ph.admin.building.model.Building;
import com.ph.admin.building.service.BuildingService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BuildingApiFacadeImpl implements BuildingApiFacade{

    private BuildingService buildingService;

    @Inject
    public BuildingApiFacadeImpl(final BuildingService buildingService){
        this.buildingService = buildingService;
    }

    public int insertBuilding(Building building) {
        return buildingService.insertBuilding(building);
    }

    public List<Building> getAllBuldings() {
        return buildingService.getAllBuldings();
    }
}
