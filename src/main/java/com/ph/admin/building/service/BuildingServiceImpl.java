package com.ph.admin.building.service;


import com.ph.admin.building.dao.BuildingDao;
import com.ph.admin.building.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired(required = true)
    private BuildingDao buildingDao;

    public BuildingDao getBuildingDao() {
        return buildingDao;
    }

    public void setBuildingDao(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }


    public int insertBuilding(final Building building) {
        return buildingDao.insertBuilding(building);
    }

    public List<Building> getAllBuldings() {
        return buildingDao.getAllBuldings();
    }
}
