package com.ph.booking.service;

import com.ph.booking.model.Booking;

import java.util.Date;
import java.util.List;

/**
 * Created by mozanta on 6/12/15.
 */
public interface BookingService {

    Integer insertBooking(Booking booking);

    List<Booking> findByDates(final String fromDate,final String toDate);

}
