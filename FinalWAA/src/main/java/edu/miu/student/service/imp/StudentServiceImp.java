package edu.miu.student.service.imp;


import edu.miu.student.domain.Student;
import edu.miu.student.repository.StudentRepository;
import edu.miu.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(long stuId) {
        return studentRepository.findById(stuId);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
        public void save(Student student) {
    studentRepository.save(student);

}
    }

