package com.example.demo.Service;


import com.example.demo.Data.Entity.Patient;
import com.example.demo.Data.Mapper.PatientMapper;
import com.example.demo.Data.Reponse.BookingReponse;
import com.example.demo.Data.Reponse.PatientReponse;
import com.example.demo.Data.Request.BookingRequest;
import com.example.demo.Data.Request.PatientRequest;
import com.example.demo.Repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    public PatientReponse createPatient(PatientRequest patientRequest) {
        Patient patient = patientMapper.toEntity(patientRequest);
        patient = patientRepository.save(patient);
        return patientMapper.toResponse(patient);
    }

    public PatientReponse updatePatient(int id, PatientRequest patientRequest) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            if (patientRequest.getName() != null) {
                existingPatient.setName(patientRequest.getName());
            }
            existingPatient = patientRepository.save(existingPatient);
            return patientMapper.toResponse(existingPatient);
        } else {
            throw new EntityNotFoundException("Patient with id " + id + " not found");
        }
    }
    public void deletePatientById(int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            patientRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Patient with id " + id + " not found");
        }
    }
}
