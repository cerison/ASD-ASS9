package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ads/api/v1/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/")
    public List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable(value = "id") Integer id) throws NotFoundException {
        var patient = patientService.getPatient(id);
        if(patient == null){
            throw  new NotFoundException(id + " not found");
        }
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/search/{query}")
    public List<Patient> searchPatient(@PathVariable String query) {
        return patientService.searchPatient(query);
    }

    @PostMapping("/")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Integer id, @RequestBody Patient patient)  throws NotFoundException {
        var patient1 = patientService.getPatient(id);
        if(patient1 == null){
            throw  new NotFoundException(id + " not found");
        }
        return ResponseEntity.ok(patientService.updatePatient(id,patient));
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable(value = "id") Integer id) {
        patientService.deletePatient(id);
    }
}