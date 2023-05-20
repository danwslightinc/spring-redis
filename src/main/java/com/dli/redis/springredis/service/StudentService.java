package com.dli.redis.springredis.service;

import com.dli.redis.springredis.model.Student;
import com.dli.redis.springredis.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    @Cacheable(value = "studentCache", key = "#id")
    public Student getStudentById(final String id) {
        log.info("Student with ID={} is not found in cache.", id);
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void createStudent(final Student student) {
        studentRepository.save(student);
    }
}
