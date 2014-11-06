/**
 * 
 */
package com.muzongyan.maven.archetypes.dtos;

/**
 * 微信客户端使用者
 * 
 * @author muzongyan
 *
 */
public class User {

    private int userId;

    private String token;

    private String userName;

    private String wxUserId;

    private String wxDeviceId;

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the wxUserId
     */
    public String getWxUserId() {
        return wxUserId;
    }

    /**
     * @param wxUserId
     *            the wxUserId to set
     */
    public void setWxUserId(String wxUserId) {
        this.wxUserId = wxUserId;
    }

    /**
     * @return the wxDeviceId
     */
    public String getWxDeviceId() {
        return wxDeviceId;
    }

    /**
     * @param wxDeviceId
     *            the wxDeviceId to set
     */
    public void setWxDeviceId(String wxDeviceId) {
        this.wxDeviceId = wxDeviceId;
    }

}
