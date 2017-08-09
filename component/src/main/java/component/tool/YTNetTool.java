package component.tool;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by TY on 2017/6/14.
 */
@Component
public class YTNetTool {

    public <T> T yt_PostRequest(String url, Map from, Class<T> claszz) throws IOException{

        HttpPost httpPost = new HttpPost(url);

        httpPost.setEntity(prepareHttpEntity1(from));

        httpPost.addHeader("User-Agent", "Mozilla/5.0");

        String jsonString = this.httpRequest(httpPost);

        ObjectMapper mapper = new ObjectMapper();

        return  mapper.readValue(jsonString,claszz);

    }

    public <T> T yt_GetRequest(String url, Map from, Class<T> claszz) throws IOException{

        HttpEntity data = this.prepareHttpEntity1(from);

        String uri = EntityUtils.toString(data);

        HttpGet httpGet = new HttpGet(url+"?"+uri);

        httpGet.addHeader("User-Agent", "Mozilla/5.0");

        String jsonString = this.httpRequest(httpGet);

        ObjectMapper mapper = new ObjectMapper();

        return  mapper.readValue(jsonString,claszz);

    }

    private String httpRequest(HttpRequestBase requestBase) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse httpResponse = httpClient.execute(requestBase);

        BufferedReader reader = new BufferedReader(new InputStreamReader( httpResponse.getEntity().getContent()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        return response.toString();

    }

    /**
     * 利用Map结构的参数生成HttpEntity，使用UrlEncodedFormEntity对参数对进行编码
     *
     * @param params
     * @return
     */
    private static HttpEntity prepareHttpEntity1(Map<String, String> params) {

        HttpEntity requestHttpEntity = null;

        try {

            if (null != params) {

                List<NameValuePair> pairList = new ArrayList<NameValuePair>();

                for (Map.Entry<String, String> entry : params.entrySet()) {

                    NameValuePair pair = new BasicNameValuePair(entry.getKey(),entry.getValue());

                    pairList.add(pair);

                }

                requestHttpEntity = new UrlEncodedFormEntity(pairList);

            }

        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return requestHttpEntity;

    }
}
