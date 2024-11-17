package edu.icet.controller;

import edu.icet.dto.Instructor;
import edu.icet.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
@CrossOrigin
public class InstructorController {
    @Autowired
    private final InstructorService instructorService;

    @GetMapping("/get-instructor")
    public List<Instructor> getInstructor(){
        return instructorService.getAll();
    }

    @PostMapping("/add-instructor")
    //@ResponseStatus(HttpStatus.CREATED)
    public void addInstructor(@RequestBody Instructor instructor){
        instructorService.addInstructor(instructor);
    }

    @GetMapping("/search-instructor/{id}")
    public Instructor getInstructorById(@PathVariable Integer id){
        return instructorService.searchInstructorById(id);
    }

    @DeleteMapping("/delete-instructor/{id}")
    public void deleteInstructorById(@PathVariable Integer id){
        instructorService.deleteInstructorById(id);
    }

    @PutMapping("/update-instructor")
    public void updateInstructor(@RequestBody Instructor instructor){
        instructorService.updateInstructorById(instructor);
    }
}
