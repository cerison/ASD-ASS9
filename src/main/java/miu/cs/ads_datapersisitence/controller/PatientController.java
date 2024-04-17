package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.exception.PatientNotFoundException;
import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ads/api/v1/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatient(@PathVariable(value = "id") Integer id) throws PatientNotFoundException{
        return patientService.getPatient(id);
    }

    @GetMapping("/search/{query}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> searchPatient(@PathVariable String query) {
        return patientService.searchPatient(query);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient updatePatient(@PathVariable(value = "id") Integer id, @RequestBody Patient patient)  throws PatientNotFoundException {
        return patientService.updatePatient(id,patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable(value = "id") Integer id)  throws PatientNotFoundException {
        patientService.deletePatient(id);
    }
}