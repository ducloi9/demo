package com.example.demo.Service;
import com.example.demo.Config.BookingConfig;
import com.example.demo.Data.Entity.Booking;
import com.example.demo.Data.Mapper.BookingMapper;
import com.example.demo.Data.Reponse.BookingReponse;
import com.example.demo.Data.Request.BookingRequest;
import com.example.demo.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    public BookingReponse createBooking(BookingRequest bookingRequest) {
        Booking booking = bookingMapper.toEntity(bookingRequest);
        booking = bookingRepository.save(booking);
        return bookingMapper.toResponse(booking);
    }

    public Optional<BookingReponse> getBookingById(int id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        return bookingOptional.map(bookingMapper::toResponse);
    }

//    public BookingReponse updateBooking(int id, BookingRequest bookingRequest) {
//        Optional<Booking> optionalBooking = bookingRepository.findById(id);
//        if (optionalBooking.isPresent()) {
//            Booking booking = optionalBooking.get();
//            // Kiểm tra thời gian cập nhật so với thời gian tạo booking
//            if (isWithin24Hours(booking.getCreatedAt())) {
//                // Ánh xạ dữ liệu từ BookingRequest sang Booking
//                Booking updatedBooking = bookingMapper.toEntity(bookingRequest);
//
//                booking = bookingRepository.save(booking);
//                return bookingMapper.toResponse(booking);
//            } else {
//                throw new BookingConfig.UpdateNotAllowedException("Booking cannot be updated after 24 hours");
//            }
//        } else {
//            try {
//                throw new ChangeSetPersister.NotFoundException();
//            } catch (ChangeSetPersister.NotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//
//    private boolean isWithin24Hours(Date createdAt) {
//        if (createdAt == null) {
//            return false;
//        }
//
//        LocalDateTime currentTime = LocalDateTime.now();
//
//        LocalDateTime createdTime = createdAt.toLocalDate().atStartOfDay();
//
//        Duration duration = Duration.between(createdTime, currentTime);
//
//        return duration.toHours() <= 24;
//    }
   public BookingReponse updateBooking(int id, BookingRequest bookingRequest) {
    Optional<Booking> optionalBooking = bookingRepository.findById(id);
    if (optionalBooking.isPresent()) {
        Booking booking = optionalBooking.get();
        Booking updatedBooking = bookingMapper.toEntity(bookingRequest);
        updatedBooking.setId(id);
        updatedBooking = bookingRepository.save(updatedBooking);
        return bookingMapper.toResponse(updatedBooking);
    } else {
        throw new RuntimeException("Booking with id " + id + " not found");
    }
}

    public void deleteBooking(int id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            bookingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Booking with id " + id + " not found");
        }
    }
    public List<BookingReponse> getAllBookingsByAccountId(Long accountId) {
        return bookingRepository.findAllByAccountId(accountId)
                .stream()
                .map(bookingMapper::toResponse)
                .collect(Collectors.toList());
    }
}


