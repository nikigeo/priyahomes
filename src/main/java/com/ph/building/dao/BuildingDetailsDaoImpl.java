package com.ph.building.dao;

import com.ph.building.model.BuildingDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BuildingDetailsDaoImpl implements BuildingDetailsDao{

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    public int insertBuildingDetails(BuildingDetails buildingDetails) {
        Integer customerId = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        customerId = (Integer)session.save(buildingDetails);
        session.getTransaction().commit();
        return customerId;
    }
}
