/**
 * 
 */
package com.muzongyan.maven.archetypes.interceptors;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.muzongyan.maven.archetypes.dtos.User;
import com.muzongyan.maven.archetypes.services.UserService;
import com.muzongyan.maven.archetypes.utils.Constants;
import com.muzongyan.maven.archetypes.wx.services.WxCpInDbConfigStorage;

/**
 * @author muzongyan
 *
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private WxCpInDbConfigStorage wxConfigStorage;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String userToken = StringUtils.EMPTY;

        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (StringUtils.equals(Constants.COOKIE_NAME_USER, cookie.getName())) {
                    userToken = cookie.getValue();
                    break;
                }
            }
        }

        // 当前用户
        User currUser = null;
        if (StringUtils.isNotBlank(userToken)) {
            // 根据cookie中的token，取出当前用户，设置到request attribute
            currUser = userService.findUserByToken(userToken);
        }

        // 当前用户不存在，去微信通过OAuth获取用户
        if (currUser == null) {
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath() + "/";

            // 通过微信的OAuth获取用户
            String redirectUri = basePath + "wx/oauth/code";
            // 获得当前访问路径，放到state参数里
            String referer = request.getServletPath();
            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + wxConfigStorage.getCorpId()
                    + "&redirect_uri=" + URLEncoder.encode(redirectUri, "utf-8")
                    + "&response_type=code&scope=snsapi_base&state=" + URLEncoder.encode(referer, "utf-8")
                    + "#wechat_redirect";

            response.sendRedirect(url);
            return false;
        }

        // 设置当前用户
        request.setAttribute("currUser", currUser);
        return true;
    }

}
