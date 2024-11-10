package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService service;

    @GetMapping("/get-student")
    public List<Student> getStudent(){
        return service.getAll();
    }

    @PostMapping("/add-student")
    //@ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
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
