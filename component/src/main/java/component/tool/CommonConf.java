package component.tool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by TY on 2017/6/18.
 */
@ConfigurationProperties(prefix = "commonConf")
@Component
@PropertySource("classpath:/conf/commonConf.properties")
public class CommonConf {

    @Value("${LoinServerUrl}")
    private String LoinServerUrl;

    @Value("${LoginServerAppId}")
    private String LoginServerAppId;

    @Value("${LoginServerAppKey}")
    private String LoginServerAppKey;

    @Value("${ServerAppId}")
    private String ServerAppId;

    @Value("${ServerAppKey}")
    private String ServerAppKey;

    @Value("${DDCorpId}")
    private String DDCorpId;

    @Value("${DDSsoSecret}")
    private String DDSsoSecret;

    @Value("${DDProductAgentId}")
    private String DDProductAgentId;

    @Value("${DDCorpSecret}")
    private String DDCorpSecret;

    public String getLoinServerUrl() {
        return LoinServerUrl;
    }

    public void setLoinServerUrl(String loinServerUrl) {
        LoinServerUrl = loinServerUrl;
    }

    public String getLoginServerAppId() {
        return LoginServerAppId;
    }

    public void setLoginServerAppId(String loginServerAppId) {
        LoginServerAppId = loginServerAppId;
    }

    public String getLoginServerAppKey() {
        return LoginServerAppKey;
    }

    public void setLoginServerAppKey(String loginServerAppKey) {
        LoginServerAppKey = loginServerAppKey;
    }

    public String getServerAppId() {
        return ServerAppId;
    }

    public void setServerAppId(String serverAppId) {
        ServerAppId = serverAppId;
    }

    public String getDDCorpId() {
        return DDCorpId;
    }

    public void setDDCorpId(String DDCorpId) {
        this.DDCorpId = DDCorpId;
    }

    public String getDDSsoSecret() {
        return DDSsoSecret;
    }

    public void setDDSsoSecret(String DDSsoSecret) {
        this.DDSsoSecret = DDSsoSecret;
    }

    public String getServerAppKey() {
        return ServerAppKey;
    }

    public void setServerAppKey(String serverAppKey) {
        ServerAppKey = serverAppKey;
    }

    public String getDDProductAgentId() {
        return DDProductAgentId;
    }

    public void setDDProductAgentId(String DDProductAgentId) {
        this.DDProductAgentId = DDProductAgentId;
    }

    public String getDDCorpSecret() {
        return DDCorpSecret;
    }

    public void setDDCorpSecret(String DDCorpSecret) {
        this.DDCorpSecret = DDCorpSecret;
    }
}
