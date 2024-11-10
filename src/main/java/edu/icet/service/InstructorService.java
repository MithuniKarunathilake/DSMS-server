package edu.icet.service;

import edu.icet.dto.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAll();
    void addInstructor(Instructor instructor);
    Instructor searchInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    void updateInstructorById(Instructor instructor);
}
