package com.example.demo.Controller;

import com.example.demo.Data.Reponse.PatientReponse;
import com.example.demo.Data.Request.PatientRequest;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @PostMapping("/create")
    public ResponseEntity<PatientReponse> createPatient(@RequestBody PatientRequest patientRequest) {
        PatientReponse createdPatient = patientService.createPatient(patientRequest);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientReponse> updatePatient(@PathVariable int id, @RequestBody PatientRequest patientRequest) {
        PatientReponse updatedPatient = patientService.updatePatient(id, patientRequest);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        try {
            patientService.deletePatientById(id);
            return ResponseEntity.ok("Patient with id " + id + " deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}