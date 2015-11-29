package com.ph.admin.building.service;


import com.ph.admin.building.dao.BuildingDao;
import com.ph.admin.building.model.Building;

public class BuildingServiceImpl implements BuildingService {

    public BuildingDao getBuildingDao() {
        return buildingDao;
    }

    public void setBuildingDao(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    private BuildingDao buildingDao;
    public int insertBuilding(final Building building) {
        return buildingDao.insertBuilding(building);
    }
}
