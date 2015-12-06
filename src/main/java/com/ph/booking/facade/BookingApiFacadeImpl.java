package com.ph.booking.facade;

import com.ph.booking.model.Booking;
import com.ph.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mozanta on 6/12/15.
 */
@Service
public class BookingApiFacadeImpl implements BookingApiFacade {

    @Autowired(required = true)
    private BookingService bookingService;

    public Integer insertBooking(Booking booking) {
        return bookingService.insertBooking(booking);
    }
}
