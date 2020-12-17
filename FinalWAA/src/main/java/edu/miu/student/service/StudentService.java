package edu.miu.student.service;

import edu.miu.student.domain.Student;

import java.util.List;
import java.util.Optional;

public interface  StudentService {
    void save(Student student);


     List<Student> findAllStudents();

    Optional<Student> findStudentById(long stuId);

    void deleteStudent(Long id);


}
