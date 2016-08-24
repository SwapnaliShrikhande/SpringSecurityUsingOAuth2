package com.oAuth2SpringSecurity.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.oAuth2SpringSecurity.Entity.Booking;

@Repository
@Transactional
public class BookingDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Booking booking) {
	    entityManager.persist(booking);
	    return;
	  }
	  
	  
  public void delete(Booking booking) {
    if (entityManager.contains(booking))
      entityManager.remove(booking);
    else
      entityManager.remove(entityManager.merge(booking));
    return;
  }
  
  public List getAll() {
    return entityManager.createQuery("from Booking").getResultList();
  }
  
  
  public Booking getByName(String bookingName) {
    return (Booking) entityManager.createQuery(
        "from Booking where bookingName = :bookingName")
        .setParameter("bookingName", bookingName)
        .getSingleResult();
  }

  
  public Booking getById(int id) {
    return entityManager.find(Booking.class, id);
  }

  
  public void update(Booking booking) {
    entityManager.merge(booking);
    return;
  }
}