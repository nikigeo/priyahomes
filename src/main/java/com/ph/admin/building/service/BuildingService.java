package com.ph.admin.building.service;

import com.ph.admin.building.model.Building;

import java.util.List;

public interface BuildingService {
    int insertBuilding(final Building building);
    void updateBuilding(final Building building);
    List<Building> getAllBuildings();
}
