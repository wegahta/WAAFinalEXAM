package edu.miu.student.service.imp;

import edu.miu.student.domain.Address;
import edu.miu.student.repository.AddressRepository;
import edu.miu.student.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp  implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }
}
