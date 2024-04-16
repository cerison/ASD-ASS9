package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.dto.response.AddressDto;
import miu.cs.ads_datapersisitence.model.Address;
import miu.cs.ads_datapersisitence.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ads/api/v1/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/")
    public List<AddressDto> getAddress() {
        return addressService.getAddress();
    }
}
