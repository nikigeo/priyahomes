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

    public int insertBuilding(final Building building) {
        return buildingDao.insertBuilding(building);
    }

    public void updateBuilding(final Building building) {
        buildingDao.updateBuilding(building);
    }

    public List<Building> getAllBuildings() {
        return buildingDao.getAllBuildings();
    }
}
