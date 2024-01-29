package com.example.demo.Data.Mapper;

import com.example.demo.Data.Entity.Doctor;
import com.example.demo.Data.Reponse.DoctorReponse;
import com.example.demo.Data.Request.DoctorRequest;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorRequest doctorRequest);

    DoctorReponse toResponse(Doctor doctor);
}
