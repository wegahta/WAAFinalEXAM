package edu.miu.student.service.imp;

import edu.miu.student.domain.Phone;
import edu.miu.student.repository.PhoneRepository;
import edu.miu.student.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImp implements PhoneService {
    @Autowired
    PhoneRepository phoneRepository;
    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }
}
