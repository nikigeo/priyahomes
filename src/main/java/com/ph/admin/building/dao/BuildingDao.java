
package com.ph.admin.building.dao;

import com.ph.admin.building.model.Building;

import java.util.List;

public interface BuildingDao {
    int insertBuilding(final Building building);
    void updateBuilding(final Building building);
    List<Building> getAllBuildings();
}
