package com.ph.booking.dao;

import com.ph.booking.model.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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



    public List<Booking> findByDates(final String fromDate,final String toDate){

        List<Booking> bookingList = new ArrayList<Booking>();

        if(null != fromDate && null != toDate){
            bookingList = sessionFactory.getCurrentSession().createQuery("from Booking where startDate>=:stDate AND  endDate<:edDate ")
                    .setDate("stDate", convertDateFromString(fromDate)).setDate("edDate", convertDateFromString(toDate)).list();
        }

        return bookingList;
    }


    private Date convertDateFromString(String dateString){
        DateFormat inputFormat = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss 'GMT'z",Locale.ENGLISH);
        Date date = null;

        try {
            date= inputFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            date = new Date();
        }
        return date;
    }
}
