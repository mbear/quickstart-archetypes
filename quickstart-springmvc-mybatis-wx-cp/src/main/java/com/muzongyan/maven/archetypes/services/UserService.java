/**
 * 
 */
package com.muzongyan.maven.archetypes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

    /**
     * 通过微信userid，获取用户信息
     * 
     * @param wxUserId
     * @return
     */
    @Cacheable(value = "users", key = "#wxUserId", unless = "#result == null")
    public User findUserByWxUserId(String wxUserId) {
        return userMapper.findUserByWxUserId(wxUserId);
    }

    /**
     * 通过内部颁发的token，获取用户信息
     * 
     * @param token
     * @return
     */
    @Cacheable(value = "users", key = "#token", unless = "#result == null")
    public User findUserByToken(String token) {
        return userMapper.findUserByToken(token);
    }

    /**
     * 通过userid，获取用户信息
     * 
     * @param userId
     * @return
     */
    @Cacheable(value = "users", key = "#userId", unless = "#result == null")
    public User findUserById(int userId) {
        return userMapper.findUserById(userId);
    }

    /**
     * 取得所有用户
     * 
     * @return
     */
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    /**
     * 创建新用户，返回新用户主键到user.userid
     * 
     * @param user
     */
    @Caching(put = { @CachePut(value = "users", key = "#user.wxUserId"),
            @CachePut(value = "users", key = "#user.userId"), @CachePut(value = "users", key = "#user.token") })
    public User createUser(User user) {
        userMapper.createUserInfo(user);
        return user;
    }

    /**
     * 更新用户的token
     * 
     * @param user
     * @return
     */
    @Caching(put = { @CachePut(value = "users", key = "#user.wxUserId"),
            @CachePut(value = "users", key = "#user.userId"), @CachePut(value = "users", key = "#user.token") })
    public User updateToken(User user) {
        userMapper.updateToken(user.getToken(), user.getUserId());
        return user;
    }

}
