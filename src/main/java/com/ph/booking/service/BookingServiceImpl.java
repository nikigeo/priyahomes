package com.ph.booking.service;

import com.ph.booking.dao.BookingDao;
import com.ph.booking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mozanta on 6/12/15.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired(required = true)
    private BookingDao bookingDao;

    public Integer insertBooking(Booking booking) {
        return bookingDao.insertBooking(booking);
    }
}
