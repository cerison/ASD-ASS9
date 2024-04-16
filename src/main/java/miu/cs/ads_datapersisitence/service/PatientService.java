package miu.cs.ads_datapersisitence.service;

import miu.cs.ads_datapersisitence.model.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getAllPatient();
    public Patient getPatient(Integer id);
    List<Patient> searchPatient(String query);
    public void addPatient(Patient patient);
    public Patient updatePatient(Integer id, Patient patient);
    public void deletePatient(Integer id);
}
