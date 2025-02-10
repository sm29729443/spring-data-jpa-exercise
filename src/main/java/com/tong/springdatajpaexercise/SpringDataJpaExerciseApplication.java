package com.tong.springdatajpaexercise;

import com.tong.springdatajpaexercise.entity.DepartmentEntity;
import com.tong.springdatajpaexercise.entity.UserEntity;
import com.tong.springdatajpaexercise.repository.DepartmentRepository;
import com.tong.springdatajpaexercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
public class SpringDataJpaExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaExerciseApplication.class, args);
    }

}
