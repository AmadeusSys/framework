package permission.service;


import component.tool.YTEncryptionTool;
import component.tool.YTNetTool;
import data.model.data.transfer.object.DD.DDJsapiTicketDTO;
import data.model.data.transfer.object.DD.DDTokenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TY on 2017/6/18.
 */
@Service
public class DDService {

    private String BASEURL = "https://oapi.dingtalk.com/";

    @Autowired
    private YTEncryptionTool ytEncryptionTool;

    @Autowired
    private Environment env;

    @Autowired
    private YTNetTool ytNetTool;

    protected Logger logger = LoggerFactory.getLogger(DDService.class);

    @Cacheable(cacheNames="tokenModel", key="#ddCorpid")
    public DDTokenDTO getToken(String ddCorpid, String ddSsoSeret) throws DDServiceException, IOException {

        String url = BASEURL + "gettoken";

        Map fromData = new HashMap();

        fromData.put("corpid",ddCorpid);

        fromData.put("corpsecret",ddSsoSeret);

        DDTokenDTO ddModel = ytNetTool.yt_GetRequest(url,fromData,DDTokenDTO.class);

        if (!ddModel.isOK()){

            throw new DDServiceException(ddModel.getErrmsg(),ddModel.getErrcode());

        }

        return ddModel;

    }


    @Cacheable(cacheNames="ticketModel", key="#accessToken")
    public String getJsapiTicket(String accessToken) throws IOException {

        String url = BASEURL + "get_jsapi_ticket";

        Map fromData = new HashMap();

        fromData.put("access_token",accessToken);

        DDJsapiTicketDTO ddModel = ytNetTool.yt_GetRequest(url,fromData,DDJsapiTicketDTO.class);

        return ddModel.getTicket();

    }

    public Map getSign(String url,String ddCorpId,String jsapiTicket) throws DDServiceException, IOException {

        String nonceStr = "abcdefg";

        long timeStamp = System.currentTimeMillis() / 1000;

        String signedUrl = url;

        String signature = sign(jsapiTicket,nonceStr,timeStamp,signedUrl);

        Map signMap = new HashMap();

        signMap.put("corpId",ddCorpId);

        signMap.put("timeStamp",Long.toString(timeStamp));

        signMap.put("nonceStr",nonceStr);

        signMap.put("signature",signature);

        return signMap;

    }

    public String sign(String ticket, String nonceStr, long timeStamp, String url) {

        String plain = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + String.valueOf(timeStamp) + "&url=" + url;

        return ytEncryptionTool.yt_Sha1(plain);

    }



}

