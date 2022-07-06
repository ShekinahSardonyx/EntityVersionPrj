package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Booking;
import com.cg.repository.BookingRepository;

@Service
public class BookingService {
	
  @Autowired
	private BookingRepository  bookingrepository; 
	  
		     public Booking addBooking(Booking b) 
		     {
		    	 return bookingrepository.save(b);
		   	           
		     }
			
			
		       
		    public Booking updateBookingFromDate(int id,LocalDate date)
		    {
		    	   Booking book= bookingrepository.getById(id);
		    	   book.setBookingDate(date);
		           return book;
		    }
		       
		       
		    public Booking updateBookingTillDate(int id,LocalDate tilldate)
		    {
		    	   Booking book=bookingrepository.getById(id);
		    	   book.setBookedTillDate(tilldate);
		    	   return book;
		    }
		       
		       
		    public Booking updatedistance(int id,double distance)
		    {
		    	   Booking book=bookingrepository.getById(id);
		    	   book.setDistance(distance);
		    	   return book;
		    }
		       
		       
		    public Booking updatecost(int id,double cost)
		    {
		    	   Booking book=bookingrepository.getById(id);
		    	   book.setTotalCost(cost);
		    	   return book;
		    }
		       
			
		       
			public String cancelBooking(int id)
			{
				bookingrepository.deleteById(id);
				return " Booking cancelled Successfully";
			}
		
		       
			public Booking viewBooking(int id)
			{       
			
				return bookingrepository.getById(id);
			}
			
			
			public List<Booking> viewAllBookings()
			{
				
				return bookingrepository.findAll();
			}
		
			
			public List<Booking> viewAllBookingByDate(LocalDate bdate)
			{
				return bookingrepository.getByBookingFromDate(bdate);
			}
}
