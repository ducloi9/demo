package com.example.demo.Data.Mapper;

import com.example.demo.Data.Entity.Booking;
import com.example.demo.Data.Reponse.BookingReponse;
import com.example.demo.Data.Request.BookingRequest;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface BookingMapper {
   BookingReponse toResponse(Booking booking);
    Booking toEntity(BookingRequest request);

}
