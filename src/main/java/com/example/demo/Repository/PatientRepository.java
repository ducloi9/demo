package com.example.demo.Repository;
import com.example.demo.Data.Entity.Doctor;
import com.example.demo.Data.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
