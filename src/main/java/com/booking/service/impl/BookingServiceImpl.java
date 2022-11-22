package com.booking.service.impl;

import com.booking.entity.Booking;
import com.booking.repository.BookingRepository;
import com.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking getBookingById(UUID id) {
        return null;
    }

    @Override
    public List<Booking> getBookings() {
        return null;
    }

    @Override
    public boolean createBooking(Booking booking) {
        return false;
    }
}