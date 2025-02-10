package com.tong.springdatajpaexercise.controller;

import com.tong.springdatajpaexercise.entity.DepartmentEntity;
import com.tong.springdatajpaexercise.entity.UserEntity;
import com.tong.springdatajpaexercise.repository.DepartmentRepository;
import com.tong.springdatajpaexercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;
@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/test1")
    public void testUser() {
        DepartmentEntity deptEntity1 = new DepartmentEntity();
        deptEntity1.setDeptName("研发部门123");
        deptEntity1.setId(1L);
        DepartmentEntity deptEntity2 = new DepartmentEntity();
        deptEntity2.setDeptName("产品部门123");
//        deptEntity2.setId(2L);
        // 写入部门信息
        departmentRepository.save(deptEntity1);
        departmentRepository.save(deptEntity2);
        departmentRepository.flush();

        UserEntity entity1 = new UserEntity();
        entity1.setWorkId("123456");
        entity1.setDepartment(deptEntity1);
        entity1.setUserName("王小二");
        UserEntity entity2 = new UserEntity();
        entity2.setWorkId("234567");
        entity2.setDepartment(deptEntity1);
        entity2.setUserName("王小五");
        UserEntity entity3 = new UserEntity();
        entity3.setWorkId("345678");
        entity3.setDepartment(deptEntity1);
        entity3.setUserName("刘大壮");
        UserEntity entity4 = new UserEntity();
        entity4.setWorkId("345678");
        entity4.setDepartment(deptEntity2);
        entity4.setUserName("张三");
        // 写入用户信息
        userRepository.saveAll(Stream.of(entity1, entity2, entity3, entity4).collect(Collectors.toList()));
        userRepository.flush();
    }
}
