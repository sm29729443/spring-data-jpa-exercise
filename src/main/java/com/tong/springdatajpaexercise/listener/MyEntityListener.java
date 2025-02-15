package com.tong.springdatajpaexercise.listener;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyEntityListener {

    /** 查詢後 */
    @PostLoad
    private void logPostLoad(Object entity) {
        log.info("retrieved entity={}", entity);
    }

    /** 新增前 */
    @PrePersist
    private void logPrePersist(Object entity) {
        log.info("pre-insert entity={}", entity);
    }

    /** 新增後 */
    @PostPersist
    private void logPostPersist(Object entity) {
        log.info("post-insert entity={}", entity);
    }

    /** 更新前 */
    @PreUpdate
    private void logPreUpdate(Object entity) {
        log.info("pre-udpate entity={}", entity);
    }

    /** 更新後 */
    @PostUpdate
    private void logPostUpdate(Object entity) {
        log.info("post-update entity={}", entity);
    }

    /** 刪除前 */
    @PreRemove
    private void logPreRemove(Object entity) {
        log.info("pre-delete entity={}", entity);
    }

    /** 刪除後 */
    @PostRemove
    private void logPostRemove(Object entity) {
        log.info("post-delete entity={}", entity);
    }
}
