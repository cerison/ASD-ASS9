package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.exception.PatientNotFoundException;
import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.repository.PatientRepository;
import miu.cs.ads_datapersisitence.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        var patient = patientRepository.findAll();
        return (patient.size() == 0) ? patient : patient.stream().sorted(Comparator.comparing(Patient::getLname)).toList();
    }

    @Override
    public Patient getPatient(Integer id)  throws PatientNotFoundException{
        Patient patient = patientRepository.findById(id).orElse(null);
        if(patient == null){
            throw  new PatientNotFoundException(id + " not found");
        }
        return patient;
    }

    @Override
    public List<Patient> searchPatient(String query) {
        var patient = patientRepository.findPatientsByFnameContainingOrLnameContainingOrAddress_StreetContainingOrAddress_CityContainingOrAddress_StateContaining(query,query,query,query,query);;
        return (patient.size() == 0) ? patient : patient.stream().sorted(Comparator.comparing(Patient::getLname)).toList();
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Integer id, Patient patient) throws PatientNotFoundException{
        Patient patient1 = getPatient(id);
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
    public void deletePatient(Integer id)  throws PatientNotFoundException{
        Patient patient1 = getPatient(id);
        if(patient1 != null){
            patientRepository.deleteById(id);
        }
    }
}