/**
 * 
 */
package com.muzongyan.maven.archetypes.wx.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import com.muzongyan.maven.archetypes.wx.dtos.WxCpConfig;

/**
 * @author muzongyan
 *
 */
public interface WxCpConfigMapper {

    @Update("UPDATE wx_cp_config wx SET wx.access_token = #{accessToken}, wx.expires_in = #{expiresIn}"
            + " WHERE wx.corp_id = #{corpId} AND wx.agent_id = #{agentId}")
    public void updateAccessToken(@Param("accessToken") String accessToken, @Param("expiresIn") int expiresIn,
            @Param("corpId") String corpId, @Param("agentId") String agentId) throws DataAccessException;

    @Select("SELECT * FROM wx_cp_config WHERE corp_id = #{corpId} AND agent_id = #{agentId}")
    public WxCpConfig getWxCpConfig(@Param("corpId") String corpId, @Param("agentId") String agentId)
            throws DataAccessException;

}
