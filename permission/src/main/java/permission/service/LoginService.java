
package permission.service;


import component.tool.CommonConf;
import component.tool.XMException;
import component.tool.YTEncryptionTool;
import component.tool.YTNetTool;
import data.mapper.UserInfoMapper;
import data.model.data.object.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzh
 * @since 2016-01-31 21:42
 */
@Service
public class LoginService {

    @Autowired
    private CommonConf conf;

    @Autowired
    private YTEncryptionTool ytEncryptionTool;

    @Autowired
    private YTNetTool ytNetTool;

    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfoDO getUserInfo(String token) throws XMException {

        UserInfoDO userInfoDO = userInfoMapper.getUserInfoDOByToken(token);

        if (userInfoDO == null){
            throw new XMException("用户信息为空,Token失效",405);
        }

        return userInfoDO;

    }

    public void paseSign(HttpServletRequest httpServletRequest) throws XMException {

        try {

            Long timeStemp = Long.parseLong(httpServletRequest.getParameter("appTime"));

            this.signDecrypt(httpServletRequest.getParameter("appId"), httpServletRequest.getParameter("appSign"),timeStemp );

        }catch (Exception e){
            throw new XMException("签名参数错误");
        }

    }

    public void signDecrypt(String appId,String appSign,long appTimeStemp) throws XMException {

        String sign = ytEncryptionTool.yt_MakeSign(appId,conf.getServerAppKey(),appTimeStemp);

        if (!sign.equals(appSign)){

           throw new XMException("签名错误！",405);

        }

    }

    /**
     * 获取登陆验证码
     * @param phoneNumber
     * @return 成功返回true
     * @throws Exception
     */
//    public boolean getLoginVerCode(String phoneNumber) throws Exception {
//
//        String baseUrl  = conf.getLoinServerUrl();
//
//        String url = baseUrl + "oauth.php/User/GetVerificationCodeEMailOrPhone";
//
//        Map fromData = ytEncryptionTool.yt_GetRequestSign(conf.getLoginServerAppId(),conf.getLoginServerAppKey());
//
//        fromData.put("Account",phoneNumber);
//
//        try {
//
//            JSONObject str = ytNetTool.yt_GetRequest(url,fromData,JSONObject.class);
//
//            String status = str.getString("status");
//
//            if ("true".equals(status)){
//
//                return true;
//
//            }else{
//
//                String msg = str.getString("msg");
//
//                throw new XMException(msg,401);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return true;
//    }

//    public UserInfo getUserInfo(String token) throws XMException {
//
//        String baseUrl  = conf.getLoinServerUrl();
//
//        String url = baseUrl + "oauth.php/Token/GetUserInfo";
//
//        Map fromData = ytEncryptionTool.yt_GetRequestSign(conf.getLoginServerAppId(),conf.getLoginServerAppKey());
//
//        fromData.put("HTTP_TOKEN",token);
//
//        try {
//
//            LoginDTO loginModel = ytNetTool.yt_GetRequest(url,fromData,LoginDTO.class);
//
//            if (loginModel.getStatus()){
//
//                String userString = loginModel.getValue().getBody();
//
//                UserInfo userInfo = JSON.parseObject(userString,UserInfo.class);
//
//                return userInfo;
//
//            }else{
//
//                String msg = loginModel.getMsg();
//
//                throw new XMException(msg,403);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }

    /**
     * 获取登陆系统Token信息
     * @param phoneNumber
     * @param verNumber
     * @return
     * @throws XMException
     */
//    public String getToken(String phoneNumber, String verNumber) throws XMException {
//
//        String baseUrl  = conf.getLoinServerUrl();;
//
//        String url = baseUrl + "oauth.php/User/GetTokenByVerificationCodeWithEMailAndCode";
//
//        Map fromData = ytEncryptionTool.yt_GetRequestSign(conf.getLoginServerAppId(),conf.getLoginServerAppKey());
//
//        fromData.put("EMail",phoneNumber);
//
//        fromData.put("Code",verNumber);
//
//        try {
//
//            LoginDTO loginModel = ytNetTool.yt_GetRequest(url,fromData,LoginDTO.class);
//
//            if (loginModel.getStatus()){
//
//                return loginModel.getValue().getBody();
//
//            }else{
//
//                String msg = loginModel.getMsg();
//
//                throw new XMException(msg,402);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//
//    }


}
