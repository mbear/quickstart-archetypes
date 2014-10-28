/**
 * 
 */
package com.muzongyan.maven.archetypes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muzongyan.maven.archetypes.dtos.User;
import com.muzongyan.maven.archetypes.mappers.UserMapper;

/**
 * @author muzongyan
 *
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

}
