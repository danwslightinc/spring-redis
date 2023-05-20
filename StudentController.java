package com.dli.redis.springredis.controller;

import com.dli.redis.springredis.model.Student;
import com.dli.redis.springredis.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final RedisTemplate<String, Student> redisTemplate;

    @GetMapping("student")
    public ResponseEntity<Student> get(@RequestParam String id) {
        var student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("student")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("redis")
    public ResponseEntity<List<String>> redis() {
        List<String> keys = new ArrayList<>();
        try (var cursor = redisTemplate.scan(ScanOptions.scanOptions().match("*").build())) {
            while (cursor.hasNext()) {
                keys.add(cursor.next());
            }
        }

        return ResponseEntity.ok(keys);
    }

}
