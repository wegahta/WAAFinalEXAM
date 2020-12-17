package edu.miu.student.repository;

import edu.miu.student.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository  extends JpaRepository<Phone,Long> {
}
