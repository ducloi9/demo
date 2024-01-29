package com.example.demo.Repository;

import com.example.demo.Data.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Optional<Doctor> findById(int id);

    List<Doctor> findAll();
    Doctor save(Doctor doctor);
}
