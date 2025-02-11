package com.tong.springdatajpaexercise.controller;

import com.tong.springdatajpaexercise.entity.DepartmentEntity;
import com.tong.springdatajpaexercise.entity.UserEntity;
import com.tong.springdatajpaexercise.repository.DepartmentRepository;
import com.tong.springdatajpaexercise.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@RestController
@Slf4j
public class TestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentEntity departmentEntityTest;

    @GetMapping("/testInsert")
    public void testUser() {
        DepartmentEntity deptEntity1 = new DepartmentEntity();
        deptEntity1.setDeptName("部門 4");
//        deptEntity1.setId(1L);
        // 写入部门信息
        departmentRepository.save(deptEntity1);
        departmentRepository.flush();

        UserEntity entity1 = new UserEntity();
        entity1.setWorkId("123456");
        entity1.setDepartment(deptEntity1);
        entity1.setUserName("王吧但");

        UserEntity entity2 = new UserEntity();
        entity2.setWorkId("22222");
        entity2.setDepartment(deptEntity1);
        entity2.setUserName("王吧但但");

        // 写入用户信息
        userRepository.saveAll(Stream.of(entity1, entity2).collect(Collectors.toList()));
        userRepository.flush();
    }

    @GetMapping("/testUpdate")
    public void testUpdate() {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        Optional<DepartmentEntity> byId = departmentRepository.findById(1L);
        if(byId.isPresent()){
            departmentEntity = byId.get();
        } else {
            System.out.println("error");
            return;
        }
        // 修改資料
        departmentEntity.setDeptName("變變");
        departmentRepository.save(departmentEntity);
        UserEntity entity1 = new UserEntity();
        entity1.setWorkId("123456");
        entity1.setDepartment(departmentEntity);
        entity1.setUserName("王吧但");

        UserEntity entity2 = new UserEntity();
        entity2.setWorkId("22222");
        entity2.setDepartment(departmentEntity);
        entity2.setUserName("王吧但但");

        // 写入用户信息
        userRepository.saveAll(Stream.of(entity1, entity2).collect(Collectors.toList()));
        userRepository.flush();
    }

    @GetMapping("/testGet")
    public void testGet() {
        DepartmentEntity departmentEntity = departmentRepository.findById(1L).get();
        Assert.notNull(departmentEntity, "departmentEntity is null");
        departmentEntityTest = departmentEntity;
        log.info("URL: /testGet, departmentEntity: {}", departmentEntity);

    }
    @GetMapping("/testMerge")
    public void testMerge() {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        BeanUtils.copyProperties(departmentEntityTest, departmentEntity);
        departmentEntity.setUpdateTime(null);
        departmentRepository.save(departmentEntity);
    }
}
