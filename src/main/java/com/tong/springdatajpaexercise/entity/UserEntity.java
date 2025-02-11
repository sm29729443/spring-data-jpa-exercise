package com.tong.springdatajpaexercise.entity;


import com.tong.springdatajpaexercise.listener.MyEntityListener;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table(name = "user")
@EntityListeners(value = {AuditingEntityListener.class, MyEntityListener.class})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String workId;
    private String userName;
    @ManyToOne(optional = false)
    @JoinColumn(name = "department")
    private DepartmentEntity department;
    @Column(nullable = false)
    @CreatedDate
    private Date createTime;
    @Column(nullable = false)
    @LastModifiedDate
    private Date updateTime;

}

