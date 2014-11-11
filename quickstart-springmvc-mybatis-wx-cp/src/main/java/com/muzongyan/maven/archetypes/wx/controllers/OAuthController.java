/**
 * 
 */
package com.muzongyan.maven.archetypes.wx.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.muzongyan.maven.archetypes.dtos.User;
import com.muzongyan.maven.archetypes.services.UserService;
import com.muzongyan.maven.archetypes.utils.Constants;
import com.muzongyan.maven.archetypes.wx.services.OAuthService;

/**
 * @author muzongyan
 *
 */
@Controller
@RequestMapping("/wx/oauth")
public class OAuthController {

    @Autowired
    private OAuthService oAuthService;

    @Autowired
    private UserService userService;

    @Autowired
    private WxCpService wxCpService;

    @RequestMapping("/code")
    public String getCode(String code, String state, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 取得之前访问路径
            String referer = URLDecoder.decode(state, "utf-8");

            // 从微信获取当前使用者信息
            User currentUser = oAuthService.getCurrentUserInfo(code);

            // 通过微信返回的userid，从cache/db获取用户信息
            User user = userService.findUserByWxUserId(currentUser.getWxUserId());

            // 颁发token
            String token = UUID.randomUUID().toString();

            if (user == null) {
                // 创建新用户
                user = new User();
                user.setWxUserId(currentUser.getWxUserId());
                user.setWxDeviceId(currentUser.getWxDeviceId());

                // 获取微信的用户信息
                WxCpUser wxCpUser = wxCpService.userGet(currentUser.getWxUserId());
                if (wxCpUser != null) {
                    user.setUserName(wxCpUser.getName());
                }

                user.setToken(token);

                userService.createUser(user);
            } else {
                // 更新用户token
                user.setToken(token);

                userService.updateToken(user);
            }

            // 设置cookie token
            Cookie cookie = new Cookie(Constants.COOKIE_NAME_USER, token);
            cookie.setPath(Constants.SLASH);
            cookie.setMaxAge(Constants.COOKIE_MAXAGE_USER);
            response.addCookie(cookie);

            // 获取跳转前的请求url
            if (referer != null) {
                return "redirect:" + referer;
            }

        } catch (WxErrorException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
