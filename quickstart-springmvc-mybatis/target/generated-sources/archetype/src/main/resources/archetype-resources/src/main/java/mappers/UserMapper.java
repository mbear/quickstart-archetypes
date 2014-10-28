#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import ${package}.dtos.User;

/**
 * @author skatam
 *
 */
public interface UserMapper {
	
	@Select("select user_id as userId, username as userName from user where user_id=${symbol_pound}{userId}")
	public User findUserById(Integer userId);
	
	@Select("select user_id as userId, username as userName from user")
	public List<User> findAllUsers();
}
