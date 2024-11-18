package edu.icet.service;

import edu.icet.dto.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<Student> getAll();
    void addStudent(Student student, MultipartFile file) throws IOException;
    void deleteStudentById(Integer id);
    Student searchStudentById(Integer id);
    void updateStudentById(Student student);
}
