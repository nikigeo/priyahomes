package com.ph.admin.building.dao;

import com.ph.admin.building.model.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BuildingDaoImpl implements BuildingDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int insertBuilding(final Building building) {
        Integer buildingId = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        buildingId = (Integer)session.save(building);
        session.getTransaction().commit();
        return buildingId;
    }
}
