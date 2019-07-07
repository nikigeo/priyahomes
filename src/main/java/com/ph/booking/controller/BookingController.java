package com.ph.booking.controller;

import com.ph.booking.facade.BookingApiFacade;
import com.ph.booking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


    @RequestMapping(value = "/findByDates/{fromDate}/{toDate}", method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> findByDates(@PathVariable String fromDate ,
                                     @PathVariable String toDate){
        return bookingApiFacade.findByDates(fromDate,toDate);
    }
}
