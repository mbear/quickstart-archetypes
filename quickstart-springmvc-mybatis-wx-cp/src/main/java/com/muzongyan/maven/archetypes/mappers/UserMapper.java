/**
 * 
 */
package com.muzongyan.maven.archetypes.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.muzongyan.maven.archetypes.dtos.User;

/**
 * @author skatam
 *
 */
public interface UserMapper {

    @Select("SELECT user_id as userId, token as token, user_name as userName, wx_user_id as wxUserId, wx_device_id as wxDeviceId FROM `user`")
    public List<User> findAllUsers();

    @Select("SELECT user_id as userId, token as token, user_name as userName, wx_user_id as wxUserId, wx_device_id as wxDeviceId FROM `user` WHERE user_id=#{userId}")
    public User findUserById(Integer userId);

    @Select("SELECT user_id as userId, token as token, user_name as userName, wx_user_id as wxUserId, wx_device_id as wxDeviceId FROM `user` WHERE wx_user_id = #{wxUserId}")
    public User findUserByWxUserId(String wxUserId);

    @Select("SELECT user_id as userId, token as token, user_name as userName, wx_user_id as wxUserId, wx_device_id as wxDeviceId FROM `user` WHERE token = #{token}")
    public User findUserByToken(String token);

    @Insert("INSERT INTO `user`(token, user_name, wx_user_id, wx_device_id) VALUES (#{user.token}, #{user.userName}, #{user.wxUserId}, #{user.wxDeviceId})")
    @SelectKey(statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() as userId", before = false, keyProperty = "user.userId", resultType = int.class)
    public void createUserInfo(@Param("user") User user);

    @Update("UPDATE `user` SET token = #{token} WHERE user_id = #{userId}")
    public void updateToken(String token, int userId);
}
