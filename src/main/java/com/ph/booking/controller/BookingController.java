package com.ph.booking.controller;

import com.ph.booking.facade.BookingApiFacade;
import com.ph.booking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mozanta on 6/12/15.
 */
@Controller
@RequestMapping("v1/ph/booking")
public class BookingController {

    @Autowired(required = true)
    private BookingApiFacade bookingApiFacade;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json" })
    @ResponseBody
    public Integer createBooking(@RequestBody Booking booking)
    {
        return bookingApiFacade.insertBooking(booking);
    }
}
