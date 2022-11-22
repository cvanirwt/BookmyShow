package com.booking.service;

import com.booking.entity.Booking;

import java.util.List;
import java.util.UUID;

public interface BookingService {

    Booking getBookingById(UUID id);

    List<Booking> getBookings();

    boolean createBooking(Booking booking);

}
