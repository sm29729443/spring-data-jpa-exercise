package com.tong.springdatajpaexercise.repository;


import com.tong.springdatajpaexercise.entity.DepartmentEntity;
import com.tong.springdatajpaexercise.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByDepartment(DepartmentEntity department);
    UserEntity findFirstByWorkId(String workId);
    List<UserEntity> findAllByDepartmentInAndUserNameLike(List<DepartmentEntity> departmentIds, String userName);

    @Query(value = "select * from user where user_name like ?1", nativeQuery = true)
    List<UserEntity> fuzzyQueryByName(String userName);
}

