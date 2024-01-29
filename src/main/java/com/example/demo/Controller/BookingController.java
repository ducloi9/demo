package com.example.demo.Controller;

import com.example.demo.Data.Entity.Booking;
import com.example.demo.Data.Reponse.BookingReponse;
import com.example.demo.Data.Request.BookingRequest;
import com.example.demo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookingReponse> createBooking(@RequestBody BookingRequest bookingRequest) {
        BookingReponse createdBooking = bookingService.createBooking(bookingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingReponse> getBookingById(@PathVariable int id) {
        Optional<BookingReponse> bookingResponse = bookingService.getBookingById(id);
        return bookingResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<BookingReponse> updateBooking(@PathVariable int id, @RequestBody BookingRequest bookingRequest) {
        BookingReponse updatedBooking = bookingService.updateBooking(id, bookingRequest);
        return ResponseEntity.ok(updatedBooking);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        try {
            bookingService.deleteBooking(id);
            return ResponseEntity.ok("Booking with id " + id + " deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<BookingReponse>> getAllBookingsByAccountId(@PathVariable Long accountId) {
        List<BookingReponse> bookings = bookingService.getAllBookingsByAccountId(accountId);
        return ResponseEntity.ok(bookings);
    }
}
