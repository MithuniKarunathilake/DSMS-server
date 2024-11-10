package edu.icet.service.impl;

import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    PasswordEncoder passwordEncoder;

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;
    @Override
    public List<Student> getAll() {
        List<Student> studentArrayList = new ArrayList<>();
        studentRepository.findAll().forEach(entity->{
            studentArrayList.add(mapper.map(entity, Student.class));
        });
        return studentArrayList;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(mapper.map(student, StudentEntity.class));
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Student searchStudentById(Integer id) {
        return mapper.map(studentRepository.findById(id),Student.class);
    }

    @Override
    public void updateStudentById(Student student) {
        studentRepository.save(mapper.map(student, StudentEntity.class));
    }

}
