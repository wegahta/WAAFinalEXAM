package edu.miu.student.repository;

import edu.miu.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {
}
