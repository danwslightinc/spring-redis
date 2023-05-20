package com.dli.redis.springredis.repo;

import com.dli.redis.springredis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
