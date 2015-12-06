package com.ph.booking.dao;

import com.ph.booking.model.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mozanta on 6/12/15.
 */
@Service
public class BookingDaoImpl implements  BookingDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public Integer insertBooking(Booking booking) {
        Integer bookingConfirmationNumber = null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        bookingConfirmationNumber = (Integer)session.save(booking);
        session.getTransaction().commit();
        return bookingConfirmationNumber;
    }
}
