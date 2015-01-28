package com.dempe.weixin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2015/1/28
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class MessageTest {

    private final static String URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=";
    private final static String STATUS_URL = " https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=";



    //@Test
    public void sendMsg() {
        JSONObject jsonObject = TokenUtil.getAppToken();
        if (jsonObject != null) {
            String accessToken = jsonObject.getString("access_token");
            String post_url = URL + accessToken;
            String result = HttpClientUtil.post(post_url, createParams());
            System.out.println("result:==>" + result);
        }

    }

    //@Test
    public void getMsgStatus(){
        JSONObject jsonObject = TokenUtil.getAppToken();
        if (jsonObject != null) {
            String accessToken = jsonObject.getString("access_token");
            String post_url = URL + accessToken;
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("msg_id",201053012);
            String result = HttpClientUtil.post(post_url, jsonObject1);
            System.out.println("result:==>" + result);
        }


    }

    private static JSONObject createParams() {

        JSONObject parmas = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("thumb_media_id", "5xmZcsqnwujq2vLKhVKYVl4S8zbGl8N7g2QEWJB-aOGXXribrxWPKLcVfdrS8P9K");
        jsonObject.put("author", "dempe");
        jsonObject.put("title", "Happy Day");
        jsonObject.put("content_source_url", "www.qq.com");
        jsonObject.put("content", "content");
        jsonObject.put("digest", "digest");
        jsonObject.put("content", "content");
        jsonObject.put("show_cover_pic", "1");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        parmas.put("articles", jsonArray);
        return parmas;
    }

   // @Test
    public void testJsonParams() {
        System.out.println(createParams().toJSONString());

    }
}
