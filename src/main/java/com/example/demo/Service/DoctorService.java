package com.example.demo.Service;
import com.example.demo.Data.Entity.Doctor;
import com.example.demo.Data.Mapper.DoctorMapper;
import com.example.demo.Data.Reponse.DoctorReponse;
import com.example.demo.Data.Request.DoctorRequest;
import com.example.demo.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public Optional<DoctorReponse> findDoctorById(int id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        return doctorOptional.map(doctorMapper::toResponse);
    }

    public List<DoctorReponse> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(doctorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public DoctorReponse createDoctor(DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.toEntity(doctorRequest);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toResponse(savedDoctor);
    }
}

