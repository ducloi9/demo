package com.example.demo.Repository;

import com.example.demo.Data.Entity.Booking;
import com.example.demo.Data.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking save(Booking booking);
    Optional<Booking> findById(int id);

    List<Booking> findAllByAccountId(Long accountId);

}
