package edu.icet.service;

import edu.icet.dto.Instructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface InstructorService {
    List<Instructor> getAll();
    void addInstructor(Instructor instructor, MultipartFile file) throws IOException;
    Instructor searchInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    void updateInstructorById(Instructor instructor);
}
