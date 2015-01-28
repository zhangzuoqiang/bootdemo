package com.dempe.weixin;

import com.alibaba.fastjson.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2015/1/28
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public class TokenUtil {

    private final static String DEF_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx6263fda0032c22a3&secret=aa8e8400406b2edcf5fe9bf94e8c58be";
    private final static String TEST_DEF_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx0f6d4d24f33cc50e&secret=84e3597c5ae03e202553db8252681967";



    public static JSONObject getAppToken() {
        JSONObject jsonObject = null;
        String result = HttpClientUtil.Get(TEST_DEF_URL);
        if (result != null) {
            jsonObject = JSONObject.parseObject(result);
        }
        return jsonObject;
    }


}



