package com.ph.admin.building.dao;

import com.ph.admin.building.model.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingDaoImpl implements BuildingDao {

    @Autowired(required = true)
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

    public List<Building> getAllBuildings() {
        return sessionFactory.openSession().createQuery("from Building").list();
    }
}
