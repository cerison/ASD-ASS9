package miu.cs.ads_datapersisitence.repository;

import miu.cs.ads_datapersisitence.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}