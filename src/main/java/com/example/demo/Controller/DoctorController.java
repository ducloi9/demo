package com.example.demo.Controller;

import com.example.demo.Data.Reponse.DoctorReponse;
import com.example.demo.Data.Request.DoctorRequest;
import com.example.demo.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorReponse> getDoctorById(@PathVariable int id) {
        Optional<DoctorReponse> doctorResponse = doctorService.findDoctorById(id);
        return doctorResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorReponse>> getAllDoctors() {
        List<DoctorReponse> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @PostMapping("/create")
    public ResponseEntity<DoctorReponse> createDoctor(@RequestBody DoctorRequest doctorRequest) {
        DoctorReponse createdDoctor = doctorService.createDoctor(doctorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
    }
}
