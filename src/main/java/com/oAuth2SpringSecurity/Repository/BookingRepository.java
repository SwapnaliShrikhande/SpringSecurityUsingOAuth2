package com.oAuth2SpringSecurity.Repository;

/*
 * @Swapnali Shrikhande
*/

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oAuth2SpringSecurity.Entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	Collection<Booking> findByBookingName(String bookingName);
	//Collection<Booking> findByBookingNameLike(@Param("booking_name") String bookingName);
}