/**
 * 
 */
package com.muzongyan.maven.archetypes.wx.services;

import java.io.StringReader;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.json.GsonHelper;
import me.chanjar.weixin.cp.api.WxCpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.muzongyan.maven.archetypes.dtos.User;

/**
 * @author muzongyan
 *
 */
@Service
public class OAuthService {

    @Autowired
    private WxCpService wxCpService;

    @Autowired
    private WxCpInDbConfigStorage config;

    /**
     * 从微信获取当前使用用户的userid和deviceid
     * 
     * @param code
     * @param agentid
     * @return
     * @throws WxErrorException
     */
    public User getCurrentUserInfo(String code) throws WxErrorException {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";
        String queryParam = "code=" + code + "&agentid=" + config.getAgentId();
        String responseContent = wxCpService.get(url, queryParam);

        JsonElement tmpJsonElement = Streams.parse(new JsonReader(new StringReader(responseContent)));
        String wxUserId = GsonHelper.getAsString(tmpJsonElement.getAsJsonObject().get("UserId"));
        String wxDeviceId = GsonHelper.getAsString(tmpJsonElement.getAsJsonObject().get("DeviceId"));
        User currentUser = new User();
        currentUser.setWxUserId(wxUserId);
        currentUser.setWxDeviceId(wxDeviceId);

        return currentUser;
    }

}
