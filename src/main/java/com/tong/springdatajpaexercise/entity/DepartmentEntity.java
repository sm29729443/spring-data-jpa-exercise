package com.tong.springdatajpaexercise.entity;


import com.tong.springdatajpaexercise.listener.MyEntityListener;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Entity
@Table(name = "department")
@EntityListeners(value = {AuditingEntityListener.class, MyEntityListener.class})
@Component
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deptName;
    @CreatedDate
    @Column(nullable = false)
    private Date createTime;
    @LastModifiedDate
    @Column(nullable = false)
    private Date updateTime;
}

