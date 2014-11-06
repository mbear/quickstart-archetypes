/**
 * 
 */
package com.muzongyan.maven.archetypes.wx.controllers;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muzongyan.maven.archetypes.wx.mp.aes.AesException;
import com.muzongyan.maven.archetypes.wx.mp.aes.WXBizMsgCrypt;
import com.muzongyan.maven.archetypes.wx.services.WxCpInDbConfigStorage;

/**
 * 用于微信回调
 * 
 * @author muzongyan
 *
 */
@Controller
@RequestMapping("/wx/callback")
public class CallBackController {

    @Autowired
    private WxCpInDbConfigStorage config;

    /**
     * 验证URL有效性<br\>
     * 为了开启应用的回调模式，企业号会向该URL发送get请求（在微信企业号管理平台开启回调模式时配置该URL，并获取Token、EncodingAESKey）。<br\>
     * 通过验证后，即开启回调模式。<br\>
     * 
     * @param sVerifyMsgSig
     *            微信加密签名，msg_signature结合了企业填写的token、请求中的timestamp、nonce参数、加密的消息体
     * @param sVerifyTimeStamp
     *            时间戳
     * @param sVerifyNonce
     *            随机数
     * @param sVerifyEchoStr
     *            加密的随机字符串，以msg_encrypt格式提供。需要解密并返回echostr明文，解密后有random、msg_len、msg、$CorpID四个字段，其中msg即为echostr明文
     * @return
     * @throws AesException
     * @see http://qydev.weixin.qq.com/wiki/index.php?title=%E5%9B%9E%E8%B0%83%E6%A8%A1%E5%BC%8F
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String verifyURL(@RequestParam("msg_signature") String sVerifyMsgSig,
            @RequestParam("timestamp") String sVerifyTimeStamp, @RequestParam("nonce") String sVerifyNonce,
            @RequestParam("echostr") String sVerifyEchoStr) throws AesException {
        // 需要返回的明文
        String sEchoStr = StringUtils.EMPTY;

        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(config.getToken(), config.getAesKey(), config.getCorpId());

        sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
        System.out.println("verifyurl echostr: " + sEchoStr);

        return sEchoStr;
    }

    /**
     * 接收回调请求，并处理
     * 
     * @param sReqMsgSig
     * @param sReqTimeStamp
     * @param sReqNonce
     * @param sReqData
     * @return
     * @throws AesException
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String callBack(@RequestParam("msg_signature") String sReqMsgSig,
            @RequestParam("timestamp") String sReqTimeStamp, @RequestParam("nonce") String sReqNonce,
            @RequestBody String sReqData) throws AesException {
        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(config.getToken(), config.getAesKey(), config.getCorpId());

        // 对用户回复的消息解密
        String sMsg = wxcpt.DecryptMsg(sReqMsgSig, sReqTimeStamp, sReqNonce, sReqData);
        System.out.println("after decrypt msg: " + sMsg);

        // 企业回复用户消息的加密
        return StringUtils.EMPTY;
    }
}
