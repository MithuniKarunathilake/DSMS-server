package edu.icet.service.impl;

import edu.icet.dto.Instructor;
import edu.icet.entity.InstructorEntity;
import edu.icet.repository.InstructorRepository;
import edu.icet.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final ModelMapper mapper;
    @Override
    public List<Instructor> getAll() {
        List<Instructor> instructorArrayList = new ArrayList<>();
        instructorRepository.findAll().forEach(entity->{
            instructorArrayList.add(mapper.map(entity, Instructor.class));
        });
        return instructorArrayList;
    }

    @Override
    public void addInstructor(Instructor instructor) {
        instructorRepository.save(mapper.map(instructor, InstructorEntity.class));
    }

    @Override
    public Instructor searchInstructorById(Integer id) {
        return mapper.map(instructorRepository.findById(id),Instructor.class);
    }

    @Override
    public void deleteInstructorById(Integer id) {
        instructorRepository.deleteById(id);

    }

    @Override
    public void updateInstructorById(Instructor instructor) {
        instructorRepository.save(mapper.map(instructor, InstructorEntity.class));
    }
}
