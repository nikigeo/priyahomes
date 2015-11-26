package com.ph.building.service;

import com.ph.building.dao.BuildingDetailsDao;
import com.ph.building.model.BuildingDetails;

public class BuildingDetailsServiceImpl implements BuildingDetailsService{

    public BuildingDetailsDao getBuildingDetailsDao() {
        return buildingDetailsDao;
    }

    public void setBuildingDetailsDao(BuildingDetailsDao buildingDetailsDao) {
        this.buildingDetailsDao = buildingDetailsDao;
    }

    private BuildingDetailsDao buildingDetailsDao;

    public int insertBuildingDetails(BuildingDetails buildingDetails) {
        return getBuildingDetailsDao().insertBuildingDetails(buildingDetails);
    }
}
