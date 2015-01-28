package com.dempe.weixin;

import com.alibaba.fastjson.JSONObject;
import com.dempe.weixin.httpclient.HttpConnectionManager;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2015/1/28
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientUtil {

    static DefaultHttpClient httpclient = HttpConnectionManager.getHttpClient();

    public static String Get(String url) {
        HttpResponse httpresponse = null;
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(url);
            httpGet.addHeader("Connection", "close");
            httpresponse = httpclient.execute(httpGet);
            if (httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(httpresponse.getEntity());
            } else {
                System.out.println("doGet Error Response: " + httpresponse.getStatusLine().toString());
            }
            EntityUtils.consume(httpresponse.getEntity());

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
            if (httpresponse != null) {
                try {
                    httpresponse.getEntity().getContent().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    public static String post(String url, JSONObject jsonObject) {
        String result = "";
        HttpResponse httpresponse = null;
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(url);
            //  String m = RandomClientMsgProducer.getmsg();
//            params.add(new BasicNameValuePair(Constants.M, m));
//            params.add(new BasicNameValuePair(Constants.APPKEY, MonitorProp.MONITOR_APPKEYS[rand.nextInt(MonitorProp.MONITOR_APPKEYS.length)]));

            StringEntity s = new StringEntity(jsonObject.toJSONString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            httpPost.setEntity(s);
            httpresponse = httpclient.execute(httpPost);
            result = EntityUtils.toString(httpresponse.getEntity());
            EntityUtils.consume(httpresponse.getEntity());

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (httpPost != null) {
                httpPost.releaseConnection();
            }
            if (httpresponse != null) {
                try {
                    httpresponse.getEntity().getContent().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
