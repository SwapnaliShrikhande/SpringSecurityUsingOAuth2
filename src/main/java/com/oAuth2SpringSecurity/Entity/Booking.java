package com.oAuth2SpringSecurity.Entity;

/*
 * @Swapnali Shrikhande
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
public class Booking {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String bookingName;

	public Booking(String bookingName) {
		super();
		this.bookingName = bookingName;
	}
	
	public Booking(int id) {
		super();
		this.id=id;
	}

	public Booking() {
	}
	
	public String getBookingName() {
		return bookingName;
	}

	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingName=" + bookingName + "]";
	}
}