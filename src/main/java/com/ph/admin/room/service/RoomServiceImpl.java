package com.ph.admin.room.service;

import com.ph.admin.room.dao.RoomDao;
import com.ph.admin.room.model.Room;
import com.ph.booking.model.Booking;
import com.ph.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pradeesh on 12/6/2015.
 */
@Service
public class RoomServiceImpl implements RoomService{

    @Autowired(required = true)
    private RoomDao roomDao;

    @Autowired(required = true)
    private BookingService bookingService;

    public int insertRoom(final Room room) {
        return roomDao.insertRoom(room);
    }

    public List<Room> getAllAvailableRooms(final String fromDate,final String toDate) {
        List<Room> allRoomsList = roomDao.getAllAvailableRooms();
        List<Booking> allBookingsBetweenDates = bookingService.findByDates(fromDate,toDate);

        List<Integer> roomIdList = getRoomIdsFromBooking(allBookingsBetweenDates);

        for (Iterator<Room> roomIterator = allRoomsList.listIterator(); roomIterator.hasNext(); ) {
            Room room = roomIterator.next();
            if(roomIdList.contains(room.getId()) || !room.isAvailable()){
                roomIterator.remove();
            }

        }

        return allRoomsList;
    }

    private List<Integer> getRoomIdsFromBooking(List<Booking> bookingList){
        List<Integer> roomIdList = new ArrayList<Integer>();
        for(Booking booking:bookingList){
            roomIdList.add(booking.getRoomId());

        }
        return roomIdList;
    }
}
