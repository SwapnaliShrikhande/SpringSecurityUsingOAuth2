package com.oAuth2SpringSecurity.Controller;

/*
 * @Swapnali Shrikhande
*/

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oAuth2SpringSecurity.Entity.Booking;
import com.oAuth2SpringSecurity.Repository.BookingDao;
import com.oAuth2SpringSecurity.Repository.BookingRepository;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	@Autowired
	private BookingDao bookingDao;
	
	@RequestMapping(value="/save")
	  @ResponseBody
	public String create(String bookingName) {
		try {
			Booking booking = new Booking(bookingName);
			bookingDao.create(booking);
			
		} catch(Exception ex) {
			return "Error while booking"+ex.toString();
		}
		return "Booking done successfully";
	}
	
	@RequestMapping(value="/delete")
	  @ResponseBody
	  public String delete(int id) {
	    try {
	      Booking booking = new Booking(id);
	      bookingDao.delete(booking);
	    }
	    catch (Exception ex) {
	      return "Error deleting the Booking: " + ex.toString();
	    }
	    return "Booking succesfully deleted!";
	  }
	  
	  
	  @RequestMapping(value="/get-by-name")
	  @ResponseBody
	  public String getByName(String bookingName) {
	    String id;
	    try {
	      Booking booking = bookingDao.getByName(bookingName);
	      id = String.valueOf(booking.getId());
	    }
	    catch (Exception ex) {
	      return "No booking found: " + ex.toString();
	    }
	    return "The booking-ID is: " + id;
	  }

	   @RequestMapping(value="/update")
	  @ResponseBody
	  public String updateName(int id, String bookingName) {
	    try {
	      Booking booking = bookingDao.getById(id);
	      booking.setBookingName(bookingName);
	      bookingDao.update(booking);
	    }
	    catch (Exception ex) {
	      return "Error updating the booking: " + ex.toString();
	    }
	    return "Booking succesfull!";
	  } 
	
	@Secured("#oauth2.clientHasAnyRole('ROLE_TRUSTED_CLIENT')")
	@RequestMapping("/bookings")
	Collection<Booking> bookings() {
		return this.bookingRepository.findAll();
	}
	
	//@Secured("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/bookings/{id}")
    @ResponseBody
    public Booking findById(@PathVariable int id) {
		Booking booking = bookingDao.getById(id);		
		try {
			
		} catch(Exception ex) {
			return null;
		}
		return booking;
    }
	
	@Autowired
	BookingRepository bookingRepository;
}