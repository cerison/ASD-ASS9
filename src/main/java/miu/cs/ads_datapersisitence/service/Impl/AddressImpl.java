package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.dto.response.AddressDto;
import miu.cs.ads_datapersisitence.dto.response.PatientDto;
import miu.cs.ads_datapersisitence.repository.AddressRepository;
import miu.cs.ads_datapersisitence.repository.PatientRepository;
import miu.cs.ads_datapersisitence.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AddressImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<AddressDto> getAddress() {
        return addressRepository.findAll()
                .stream()
                .map(address1 -> modelMapper.map(address1,AddressDto.class))
                .map(address -> {
                    var patient = patientRepository.findAll()
                            .stream()
                            .filter(patient1 -> patient1.getAddress().getId() == address.getId())
                            .toList();
                    if(patient.size() > 0 ){
                        if(patient.get(0) != null){
                            address.setPatientDto(new PatientDto(patient.get(0).getFname(),patient.get(0).getLname()));
                        }
                    }
                    return address;
                })
                .sorted(Comparator.comparing(AddressDto::getCity))
                .toList();
    }
}