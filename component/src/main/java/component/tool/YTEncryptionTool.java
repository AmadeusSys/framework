package component.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TY on 2017/6/14.
 */
@Component
public class YTEncryptionTool {

    @Autowired
    private Environment env;

    public String yt_MakeSign(String appId,String appKey,long timeStamp){

        return this.yt_Md5(this.yt_Sha1(timeStamp + appKey + timeStamp) + appId);

    }

    public Map yt_GetRequestSign(String appId, String appKey){

        long timeStamp = System.currentTimeMillis()/1000;

        String sign = this.yt_MakeSign(appId,appKey,timeStamp);

        Map formData = new HashMap<String, String>();

        formData.put("platform_time",Long.toString(timeStamp));

        formData.put("platform_sign",sign);

        formData.put("platform_id",appId);

        return formData;

    }

    public String yt_Sha1(String str){
        return this.yt_Encryption(str,"SHA-1");
    }

    public String yt_Md5(String str){
        return this.yt_Encryption(str,"MD5");
    }

    public String yt_Encryption(String str, String type) {

        try {

            MessageDigest digest = MessageDigest.getInstance(type);

            digest.update(str.getBytes());

            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();

            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
