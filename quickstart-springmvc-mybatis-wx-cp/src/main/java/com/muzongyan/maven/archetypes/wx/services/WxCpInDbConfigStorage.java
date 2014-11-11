/**
 * 
 */
package com.muzongyan.maven.archetypes.wx.services;

import me.chanjar.weixin.common.bean.WxAccessToken;
import me.chanjar.weixin.cp.api.WxCpConfigStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.muzongyan.maven.archetypes.wx.dtos.WxCpConfig;
import com.muzongyan.maven.archetypes.wx.mappers.WxCpConfigMapper;

/**
 * @author muzongyan
 *
 */
@Service("wxCpInDbConfigStorage")
public class WxCpInDbConfigStorage implements WxCpConfigStorage {

    // 微信企业号ID
    @Value("${wx.cp.corpId}")
    private String corpId;

    // 微信企业号内的应用ID
    @Value("${wx.cp.test.agentId}")
    private String agentId;

    @Autowired
    private WxCpConfigMapper wxCpConfigMapper;

    @Override
    public void updateAccessToken(WxAccessToken accessToken) {
        wxCpConfigMapper.updateAccessToken(accessToken.getAccessToken(), accessToken.getExpiresIn(), corpId, agentId);
    }

    @Override
    public void updateAccessToken(String accessToken, int expiresIn) {
        wxCpConfigMapper.updateAccessToken(accessToken, expiresIn, corpId, agentId);
    }

    @Override
    public String getAccessToken() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getAccess_token();
    }

    @Override
    public String getCorpId() {
        return corpId;
    }

    @Override
    public String getCorpSecret() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getCorp_secret();
    }

    @Override
    public String getAgentId() {
        return agentId;
    }

    @Override
    public String getToken() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getToken();
    }

    @Override
    public String getAesKey() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getAes_key();
    }

    @Override
    public int getExpiresIn() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getExpires_in();
    }

    @Override
    public String getHttp_proxy_host() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getHttp_proxy_host();
    }

    @Override
    public int getHttp_proxy_port() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getHttp_proxy_port();
    }

    @Override
    public String getHttp_proxy_username() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getHttp_proxy_username();
    }

    @Override
    public String getHttp_proxy_password() {
        WxCpConfig config = wxCpConfigMapper.getWxCpConfig(corpId, agentId);
        return config.getHttp_proxy_password();
    }

}
