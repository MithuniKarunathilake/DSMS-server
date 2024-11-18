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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    PasswordEncoder passwordEncoder;

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;
    private static final String URL = "C:/Users/Admin/Desktop/sample/Sample/src/main/resources/images";
    @Override
    public List<Student> getAll() {
        List<Student> studentArrayList = new ArrayList<>();
        studentRepository.findAll().forEach(entity->{
            studentArrayList.add(mapper.map(entity, Student.class));
        });
        return studentArrayList;
    }

    @Override
    public void addStudent(Student student, MultipartFile file) throws IOException {
        String filePath = URL + file.getOriginalFilename();
        StudentEntity entity = mapper.map(student, StudentEntity.class);
        entity.setImageName(file.getOriginalFilename());
        entity.setImagePath(filePath);
        studentRepository.save(entity);
        file.transferTo(new File(filePath));
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
