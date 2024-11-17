package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {
    @Autowired
    private final StudentService service;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/get-student")
    public List<Student> getStudent(){
        return service.getAll();
    }

//    @PostMapping("/add-student")
//    //@ResponseStatus(HttpStatus.CREATED)
//    public void addStudent(@RequestBody Student student){
//        service.addStudent(student);
//    }

    @PostMapping("/add-student")
    public void addStudent(@RequestPart("student") Student student, @RequestPart("image") MultipartFile file) throws IOException {
        try {
            student.setImage(file.getBytes());
            service.addStudent(student);
        } catch (Exception e) {
            System.out.println("Error uploading image.");
        }
    }
    @GetMapping
    public  ResponseEntity<List<StudentEntity>> getAllUser(){
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        return  ResponseEntity.ok(studentEntityList);

    }

    @GetMapping("/search-student/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return service.searchStudentById(id);
    }

    @DeleteMapping("/delete-student/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        service.deleteStudentById(id);
    }

    @PutMapping("/update-student")
    public void updateStudent(@RequestBody Student student){
        service.updateStudentById(student);
    }

}
