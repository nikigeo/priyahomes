package com.ph.admin.building.facade;

import com.ph.admin.building.model.Building;

import java.util.List;

public interface BuildingApiFacade {
    int insertBuilding(final Building building);
    void updateBuilding(final Building building);
    List<Building> getAllBuildings();
}
