package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.repository.PatientRepository;
import miu.cs.ads_datapersisitence.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatient(Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> searchPatient(String query) {
        return patientRepository.findPatientsByFnameContainingOrLnameContainingOrAddress_StreetContainingOrAddress_CityContainingOrAddress_StateContaining(query,query,query,query,query);
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Integer id, Patient patient) {
        Patient patient1 = patientRepository.findById(id).orElse(null);
        if(patient1 != null){
            patient1.setFname(patient.getFname());
            patient1.setLname(patient.getLname());
            patient1.getAddress().setStreet(patient.getAddress().getStreet());
            patient1.getAddress().setCity(patient.getAddress().getCity());
            patient1.getAddress().setState(patient.getAddress().getState());
            patient1.getAddress().setZip(patient.getAddress().getZip());
        }
        return patientRepository.save(patient1);
    }

    @Override
    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }
}