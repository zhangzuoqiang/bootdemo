package com.dempe.weixin.api;

import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhengdaxia
 * Date: 15/1/27
 * Time: 下午10:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController extends WeixinControllerSupport {
    private static final Logger log = Logger.getLogger(WeixinController.class);
    private static final String TOKEN = "myToken";
    private static final String APPID = "wx0f6d4d24f33cc50e";
    private static final String APPSECRET = "84e3597c5ae03e202553db8252681967";
    //设置TOKEN，用于绑定微信服务器
    @Override
    protected String getToken() {
        return TOKEN;
    }
    //使用安全模式时设置：APPID
    @Override
    protected String getAppId() {
        return APPID;
    }
    //使用安全模式时设置：密钥
    @Override
    protected String getAESKey() {
        return null;
    }
    //重写父类方法，处理对应的微信消息
    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();
        log.info("用户发送到服务器的内容:{}"+content);
        return new TextMsg("hello, qq");
    }
    /*1.1版本新增，重写父类方法，加入自定义微信消息处理器
     *不是必须的，上面的方法是统一处理所有的文本消息，如果业务觉复杂，上面的会显得比较乱
     *这个机制就是为了应对这种情况，每个MessageHandle就是一个业务，只处理指定的那部分消息
     */
    @Override
    protected List<MessageHandle> initMessageHandles() {
        List<MessageHandle> handles = new ArrayList<MessageHandle>();
        //handles.add(new MyMessageHandle());
        return handles;
    }
    //1.1版本新增，重写父类方法，加入自定义微信事件处理器，同上
    @Override
    protected List<EventHandle> initEventHandles() {
        List<EventHandle> handles = new ArrayList<EventHandle>();
        //handles.add(new MyEventHandle());
        return handles;
    }


    @RequestMapping("/test")
    @ResponseBody
    public String testController(){
        return "hello world";
    }


//    public static boolean check_signature(String signature,String timestamp, String nonce) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        String[] arr = new String[]{timestamp, nonce, TOKEN};
//        Arrays.sort(arr);
//        String s = arr[0] + arr[1] + arr[2];
//        MessageDigest  md = MessageDigest.getInstance("SHA-1");
//        byte[] digest = md.digest(s.getBytes("utf-8"));
//        return signature == bytes2HexString(digest);
//
//    }
}