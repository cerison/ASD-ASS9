package miu.cs.ads_datapersisitence.service;

import miu.cs.ads_datapersisitence.exception.PatientNotFoundException;
import miu.cs.ads_datapersisitence.model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    public List<Patient> getAllPatient();
    public Patient getPatient(Integer id) throws PatientNotFoundException;
    List<Patient> searchPatient(String query);
    public void addPatient(Patient patient);
    public Patient updatePatient(Integer id, Patient patient)  throws PatientNotFoundException;
    public void deletePatient(Integer id)  throws PatientNotFoundException;
}
