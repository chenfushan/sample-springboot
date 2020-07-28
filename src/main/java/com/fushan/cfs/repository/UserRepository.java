/**
 * Alps Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.repository;

import com.fushan.cfs.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author fushan.cfs
 * @version $Id: UserRepository.java, v 0.1 2018年10月30日 下午4:46 fushan.cfs Exp $
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findUserEntityById(Integer id);

    @Query(value = "select * from user u where u.user_name = ?1", nativeQuery = true)
    List<UserEntity> findUserEntitiesByUserName(String userName);

    @Override
    UserEntity save(UserEntity userEntity);
}