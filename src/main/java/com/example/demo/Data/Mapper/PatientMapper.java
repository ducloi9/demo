package com.example.demo.Data.Mapper;
import com.example.demo.Data.Entity.Doctor;
import com.example.demo.Data.Entity.Patient;
import com.example.demo.Data.Reponse.DoctorReponse;
import com.example.demo.Data.Reponse.PatientReponse;
import com.example.demo.Data.Request.DoctorRequest;
import com.example.demo.Data.Request.PatientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientRequest patientRequest);

    PatientReponse toResponse(Patient patient);
}
